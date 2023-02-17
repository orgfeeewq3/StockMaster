package org.backery.Model.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class LoginDTO {
    @NotNull(message = "El identificador no puede ser nulo")
    @NotEmpty(message = "El identificador no puede ser vacio")
    @NotBlank(message = "El identificador no puede ser en blanco")
    private String identifier;

    @NotBlank
    private String password;

    public LoginDTO() {
        super();
    }

}
