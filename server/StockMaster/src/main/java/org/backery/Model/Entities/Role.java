package org.backery.Model.Entities;

import jakarta.validation.constraints.Size;

public enum Role {
    @Size(max = 255)
    ADMIN,
    @Size(max = 255)
    USER
}
