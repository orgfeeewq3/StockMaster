package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {
    Scanner lector = new Scanner(System.in);
    ArrayList<String> list_usuario = new ArrayList<String>();
    ArrayList<String> list_contrasena = new ArrayList<String>();
    String usuario = "", contraseña = "", agregarusuario = "", agregarcontra = "", sesion = "";
    public void login() {
        //creamos cuenta admin como default
        list_usuario.add("admin");
        list_contrasena.add("admin");

        //obtenemos info
        System.out.println("Escribe tu usuario y contraseña para iniciar sesion");
        System.out.print("Usuario: ");
        usuario = lector.next();
        System.out.println();
        System.out.print("Contraseña: ");
        contraseña = lector.next();
        sesion = usuario;
    }
    public void agregar_Usuario() {
        System.out.println("Escribe el nombre de usuario que deseas agregar");
        System.out.print("Usuario: ");
        agregarusuario = lector.next();
        System.out.println("Escribe una contraseña para el usuario");
        System.out.print("Contraseña:");
        agregarcontra = lector.next();

        list_usuario.add(agregarusuario);
        list_contrasena.add(agregarcontra);

        System.out.println("Usuario agregado!");
    }
}