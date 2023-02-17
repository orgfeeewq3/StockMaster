package org.backery.Model.Entities;

public class Ingreso {
    private int id;
    private String nombre;
    private int cantidad;

    public Ingreso() {
    }

    public Ingreso(String nombre, int cantidad) {
        this.id = id;
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
