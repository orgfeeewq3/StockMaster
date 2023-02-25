package org.backery.Model.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class Output extends Process{

    public Output(String nombre, int cantidad) {
        super(nombre, cantidad);
    }
}