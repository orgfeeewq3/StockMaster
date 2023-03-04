package org.backery.Service.impl;

import org.backery.Model.Entities.User;
import org.backery.Model.dtos.SignInDTO;
import org.backery.Model.dtos.SignUpDTO;
import org.backery.Repository.UserRepository;
import org.backery.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean existsByIdentifier(String identifier) throws Exception{
        return userRepository.existsByUsernameOrEmail(identifier,identifier);
    }

    @Override
    public Boolean login(SignInDTO signIn) throws Exception {
        if(!existsByIdentifier(signIn.getIdentifier()))  //Se verifica que el usuario exista
            throw new Exception("Este usuario no existe");
        System.out.println("El usuario existe");
        User user = findOneByIdentifer(signIn.getIdentifier()); //Se obtiene el usuario
        System.out.println("El usuario es: " + user.toString());
        if(!comparePassword(user, signIn.getPassword()))  //Se compara la contraseña
            throw new Exception("La contrasena no es correcta.");
        else return true;
    }

    @Override
    public User findOneByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean register(SignUpDTO singUp) throws Exception {
        try{
            Boolean exist = existsByIdentifier(singUp.getUsername()) ||
                            existsByIdentifier(singUp.getEmail());
            if(exist) {
                throw new Exception("El usuario ya existe");
            }
            User newUser = new User(
                    singUp.getName(),
                    singUp.getEmail(),
                    singUp.getUsername(),
                    singUp.getPassword()
            );
            newUser.setIsadmin(false); //Se establece que el usuario no es administrador por defecto
            userRepository.save(newUser);  //.insertUser(newUser);

            exist = existsByIdentifier(newUser.getUsername());  //.existsByIdentifier(newUser.getUsername());
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
                .findByUsernameOrEmail(identifier,identifier);

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
        User foundUser = userRepository
                .findByUsernameOrEmail(username, email);
        return foundUser;
    }

    @Override
    public Boolean comparePassword(User user, String passToCompare) throws Exception {
       User userFound = findOneById(user.getId());
       return userFound.getPassword().equals(passToCompare);
    }
}
