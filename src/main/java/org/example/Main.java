package org.example;

import java.util.Scanner;
import lombok.val;

public class Main {

    public static void main(String[] args) {
        String nombre;
        String correo;
        String usuario = "";
        String contrasena = "";
        int opcion = 0;
        Scanner scan = new Scanner(System.in);

        UsuariosController usuariosController = new UsuariosController();

    while (true) {
            System.out.println("1. Registrase");
            System.out.println("2. Iniciar sesion");
            System.out.println("3. Salir");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> {
                    scan.nextLine();
                    System.out.println("Registrando usuario");
                    System.out.println("Ingrese su nombre");
                    nombre = scan.nextLine();
                    System.out.println("Ingrese su correo");
                    correo = scan.nextLine();
                    System.out.println("Ingrese su usuario");
                    usuario = scan.nextLine();
                    System.out.println("Ingrese su contraseña");
                    contrasena = scan.nextLine();
                    usuariosController.register(nombre, correo, usuario, contrasena);
                }
                case 2 -> {
                    scan.nextLine();
                    System.out.println("Iniciando sesion");
                    System.out.println("Ingrese su usuario");
                    usuario = scan.nextLine();
                    System.out.println(usuario+" Ingrese su contraseña");
                    contrasena = scan.nextLine();
                    usuariosController.login(usuario, contrasena);
                }
                //iniciarSesion();
                case 3 -> System.exit(0);
                default -> System.out.println("Opcion no valida");
            }}

    }

}