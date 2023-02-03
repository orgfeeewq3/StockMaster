package org.example;

public class Ingreso {
    private int id;
    private String nombre;
    private int cantidad;

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

    public Ingreso(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
}
