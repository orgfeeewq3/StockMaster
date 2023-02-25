package org.backery.Model.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class Stored extends Process{

    public Stored(String nombre, int cantidad) {
        super(nombre, cantidad);
    }
}
