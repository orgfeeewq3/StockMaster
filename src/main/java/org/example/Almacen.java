package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Almacen {
    int id;
    String nombre;
    int cantidad;
//    @Data
//    @AllArgsConstructor
    public Almacen() {
    }

    public Almacen(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
