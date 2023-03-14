package org.backery.Model.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class Stored_Old extends Process{

    public Stored_Old(String nombre, int cantidad) {
        super(nombre, cantidad);
    }
}
