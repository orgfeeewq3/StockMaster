package org.backery.Model.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDTO {
    @NotBlank
    private String identifier;

    @NotBlank
    private String password;

    public LoginDTO(String identifier, String password) {
        super();
        this.identifier = identifier;
        this.password = password;
    }

    public LoginDTO() {
        super();
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
