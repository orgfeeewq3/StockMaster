package org.backery.Controllers;

import jakarta.validation.Valid;
import org.backery.Model.Entities.Usuario;
import org.backery.Model.dtos.MessageDTO;
import org.backery.Model.dtos.LoginDTO;
import org.backery.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {   //TODO: la ruta es en request mapping y no en rest controller
//    @Autowired
    UserService userService;
//
//    @Autowired
//    private AuthenticationManager authManager;
//
//    @Autowired
//    private TokenManager tokenManager;

  /*  @PostMapping("/signup")
    public ResponseEntity<MessageDTO> registerUser(@Valid UserInfo userInfo, BindingResult result) {
        try {
            if(result.hasErrors()) {
                String errors = result.getAllErrors().toString();


                return new ResponseEntity<>(
                        new MessageDTO("Hay errores: " + errors),
                        HttpStatus.BAD_REQUEST
                );
            }

            User foundUser = userService
                    .findOneByUsernameAndEmail(userInfo.getUsername(), userInfo.getEmail());

            if(foundUser != null) {
                return new ResponseEntity<>(
                        new MessageDTO("Este usuario ya existe"),
                        HttpStatus.BAD_REQUEST
                );
            }

            userService.register(userInfo);

            return new ResponseEntity<>(
                    new MessageDTO("Usuario Registrado"),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new MessageDTO("Error interno"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    } */

    @PostMapping(value="/signin")
    private ResponseEntity<MessageDTO> login( LoginDTO loginInfo) {
        try {

//            if(result.hasErrors()) {
//                return new ResponseEntity<>(
//                        new TokenDTO(),
//                        HttpStatus.BAD_REQUEST
//                );
//            }

            Usuario user = userService.findOneByIdentifer(loginInfo.getIdentifier());

            if(!userService.comparePassword(user, loginInfo.getPassword())) {
                return new ResponseEntity<>(
                        new MessageDTO("Hay errores: " ),
                        HttpStatus.BAD_REQUEST
                );
            }

            return new ResponseEntity<>(
                    new MessageDTO("Bienvenido"),
                    HttpStatus.OK
            );

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(
                    new MessageDTO("Error interno :("),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}


