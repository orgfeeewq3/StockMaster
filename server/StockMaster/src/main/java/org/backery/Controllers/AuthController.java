package org.backery.Controllers;

import jakarta.validation.Valid;
import lombok.Data;
import org.backery.Model.Entities.User;
import org.backery.Model.dtos.MessageDTO;
import org.backery.Model.dtos.SignInDTO;
import org.backery.Model.dtos.SignUpDTO;
import org.backery.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Data
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

    @PostMapping(value="/signin")
    private ResponseEntity<MessageDTO> login(@Valid //@ModelAttribute
                                            SignInDTO signInDTO, BindingResult result, Model model) {
        try {
            if(result.hasErrors()) {
                String errors = result.getAllErrors().toString();
                throw new Exception("Hay errores: " + errors);
            }

            String userLogged = userService.login(signInDTO);
            if (userLogged == null)
                throw new Exception("Error al iniciar sesion el usuario");

            return new ResponseEntity<>(    //Sii todo esta bien, se retorna ok
                    new MessageDTO("Bienvenido", userLogged),
                    HttpStatus.OK
            );

        } catch (Exception e) { //Si hay un error, se retorna un error interno
            return new ResponseEntity<>(
                    MessageDTO.builder().message("Error: "+e.getMessage()).build(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageDTO> register(@Valid //@ModelAttribute
                                                   SignUpDTO signUpDTO, BindingResult result, Model model) {
        try {
            if(result.hasErrors()) {
                String errors = result.getAllErrors().toString();
                throw new Exception("Hay errores: " + errors);
            }

            Boolean userRegistered = userService.register(signUpDTO);
            if (!userRegistered)
                throw new Exception("Error al registrar el usuario");

            return new ResponseEntity<>(
                    MessageDTO.builder().message("Usuario Registrado").build(),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    MessageDTO.builder().message("Error: "+e.getMessage()).build(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

}


