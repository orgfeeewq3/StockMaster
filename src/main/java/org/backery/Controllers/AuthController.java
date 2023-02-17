package org.backery.Controllers;

import jakarta.validation.Valid;
import org.backery.Model.Entities.Usuario;
import org.backery.Model.dtos.MessageDTO;
import org.backery.Model.dtos.LoginDTO;
import org.backery.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {   //TODO: la ruta es en request mapping y no en rest controller
    @Autowired
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
    private ResponseEntity<MessageDTO> login(@Valid LoginDTO loginInfo, BindingResult result, Model model) {
        try {
            System.out.println("result: " + result);
            if(result.hasErrors()) {
                throw new Exception("Hay errores en el formulario");
            }
            if (loginInfo.getIdentifier() == null || loginInfo.getPassword() == null) {
                throw new Exception("No se puede dejar vacio el usuario o la contrasena");
            }
            if(!userService.existsByUsername(loginInfo.getIdentifier())) { //Se verifica que el usuario exista
                throw new Exception("Este usuario no existe");
            }

            Usuario user = userService.findOneByIdentifer(loginInfo.getIdentifier()); //Se obtiene el usuario

            if(!userService.comparePassword(user, loginInfo.getPassword())) { //Se compara la contraseña
                throw new Exception("La contrasena no es correcta.");
            }

            return new ResponseEntity<>(    //Sii todo esta bien, se retorna ok
                    new MessageDTO("Bienvenido"),
                    HttpStatus.OK
            );

        } catch (Exception e) { //Si hay un error extrano, se retorna un error interno
            System.out.println(e.getMessage());
            return new ResponseEntity<>(
                    new MessageDTO(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}


