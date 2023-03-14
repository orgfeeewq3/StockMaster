package org.backery.Service.impl;

import jakarta.transaction.Transactional;
import org.backery.Model.Entities.Role;
import org.backery.Model.Entities.Token;
import org.backery.Model.Entities.User;
import org.backery.Model.dtos.SignInDTO;
import org.backery.Model.dtos.SignUpDTO;
import org.backery.Repository.TokenRepository;
import org.backery.Repository.UserRepository;
import org.backery.Security.JwtService;
import org.backery.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.backery.Model.Entities.Role.USER;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private PasswordEncoder passEncoder;
    @Autowired
   private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Boolean existsByIdentifier(String identifier) throws Exception{
        return userRepository.existsByUsernameOrEmail(identifier,identifier);
    }

    @Override
    public String login(SignInDTO signIn) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getIdentifier()
                                                      , signIn.getPassword() )
        );
        if(!existsByIdentifier(signIn.getIdentifier()))  //Se verifica que el usuario exista
            throw new Exception("Este usuario no existe");
        User user = findOneByIdentifer(signIn.getIdentifier()); //Se obtiene el usuario
        String jwtToken = jwtService.generateToken(user);
        insertToken(user, jwtToken);
        if(!comparePassword(user, signIn.getPassword()))  //Se compara la contraseña encriptada
            throw new Exception("La contrasena no es correcta.");
        else return jwtToken;
    }

    @Override
    public User findOneByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }

    @Override
    public Boolean register(SignUpDTO singUp) throws Exception {
        try{
            Boolean exist = existsByIdentifier(singUp.getUsername()) ||
                            existsByIdentifier(singUp.getEmail());
            if(exist) {
                throw new Exception("El usuario ya existe");
            }
            User user = User.builder()
                    .name( singUp.getName())
                    .email(singUp.getEmail())
                    .username(singUp.getUsername())
                    .password(passEncoder.encode(singUp.getPassword()))
                    .role("USER")
                    .build();
            userRepository.save(user);  //.insertUser(newUser);

            exist = existsByIdentifier(user.getUsername());  //.existsByIdentifier(newUser.getUsername());
            if (exist) {
                return true;
            } else {
                throw new Exception("No se pudo registrar el usuario");
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public User findOneById(int id) throws Exception {
        return userRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public List<User> findAll() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public User findOneByIdentifer(String identifier) throws Exception {
//        System.out.println("identifier: " + identifier);

        User foundUser = userRepository
                .findByUsernameOrEmail(identifier,identifier).orElseThrow();

        System.out.println("foundUserepo: " + foundUser);

//        if(foundUser == null) {
//            foundUser = userRepository
//                    .findByEmail(identifier);
//        }
//        System.out.println("foundUserepo: " + foundUser);
        return foundUser;
    }

    @Override
    public User findOneByUsernameAndEmail(String username, String email) throws Exception {
        return userRepository
                .findByUsernameOrEmail(username, email).orElseThrow();
    }

    @Override
    public Boolean comparePassword(User user, String passToCompare) throws Exception {
       return  passEncoder.matches(passToCompare, user.getPassword());
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void insertToken(User user, String jwtToken) throws Exception {
        cleanTokens(user);
        Token token = Token.builder()
                .content(jwtToken)
                .active(true)
                .issuedat(jwtService.extractIssued(jwtToken))
                .expiredat(jwtService.extractExpiration(jwtToken))
                .idUser(user)
                .build();
        tokenRepository.save(token);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Boolean isTokenValid(User user, String token) throws Exception {
       /* cleanTokens(user);

        List<Token> tokens = tokenRepository.findByUserAndActive(user, true);

        return tokens.stream()
                .filter((userToken) -> {
                    return userToken.getContent().equals(token) && userToken.getActive();
                })
                .findAny()
                .orElse(null) != null;*/
    return false;
    }

    @Override
    public User getUserAuthenticated() throws Exception {
        return null;
    }

    @Transactional(rollbackOn = Exception.class)
    public void cleanTokens(User user) {
        Optional<List<Token>> tokens = Optional.of(tokenRepository.findByIdUserAndActive(user, true).orElseThrow());

        tokens.orElseThrow().forEach((userToken) -> {
            if(!jwtService.validateToken(userToken.getContent(), user)) {
                userToken.setActive(false);
                tokenRepository.save(userToken);
            }
        });
    }

    //@Override
    public String getUserAuth() throws Exception {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
