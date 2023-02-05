package org.example;

import static org.example.Main.prodControl;

public class UsuariosController {
    public Usuarios usuarios = new Usuarios();
    public void dispatch_revisar() {
        boolean revisar_usuario = usuarios.list_usuario.contains(usuarios.usuario), revisar_contra = usuarios.list_contrasena.contains(usuarios.contraseña);

        if (revisar_usuario & revisar_contra) {
            if (usuarios.sesion.equals("admin")) {
                usuarios.agregar_Usuario();
                usuarios.login();
            }
            prodControl();
        } else {
            System.out.println("El usuario o contraseña estan incorrectos, o no existen");
        }
    }
    public void dispatch_login() {
        usuarios.login();
    }
}
