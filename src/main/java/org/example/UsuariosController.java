package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//import static org.example.Main.prodControl;

public class UsuariosController {
    Usuario usuario = new Usuario();
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
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

    public void register(String nombre, String correo, String usuario, String contrasena) {
        for (Usuario u : listaUsuarios) {
            if (u.getUsuario().equals(usuario)) {
                System.out.println("El usuario ya existe");
                return;
            }
        }
        listaUsuarios.add(new Usuario(nombre, correo, usuario, contrasena));
        System.out.println("Usuario registrado");
    }

    public void login(String usuario, String contrasena) {
        for (Usuario u : listaUsuarios) {
            System.out.println("hoooola"+u.getUsuario());
            System.out.println("yeahhh"+usuario+contrasena);
            if (u.getUsuario() == usuario) {
                System.out.println("Bienvenido " + u.getNombre());

                prodControl();

                return;
            }
        }
        System.out.println("El usuario o contraseña estan incorrectos, o no existen");

    }

    public static void prodControl(){
        Scanner scan = new Scanner(System.in);
        ProductoController productoController = new ProductoController();
        String nombre;
        int cantidad;
        System.out.println("Bienvenido al sistema de almacen");
        System.out.println("1. Crear producto");
        System.out.println("2. Abastecer producto");
        System.out.println("3. Vender producto");
        System.out.println("4. Mostrar productos");
        System.out.println("5. Mostrar ingresos");
        System.out.println("6. Mostrar ventas");
        System.out.println("7. Salir");
        int opcion = 0;
        switch(opcion){
            case 1:
                System.out.println("Creando producto");
                System.out.println("Ingrese el nombre del producto");
                nombre = scan.nextLine();
                System.out.println("Ingrese cantidad de producto");
                cantidad = scan.nextInt();
                productoController.crearProducto(nombre, cantidad);
                break;
            case 2:
                System.out.println("Abasteciendo producto");
                System.out.println("Ingrese el nombre del producto");
                nombre = scan.nextLine();
                System.out.println("Ingrese cantidad de producto");
                cantidad = scan.nextInt();
                productoController.abastecerProducto(nombre, cantidad);
                break;
            case 3:
                System.out.println("Vendiendo producto");
                System.out.println("Ingrese el nombre del producto");
                nombre = scan.nextLine();
                System.out.println("Ingrese cantidad de producto");
                cantidad = scan.nextInt();
                productoController.venderProducto(nombre, cantidad);
                break;
            case 4:
                productoController.mostrarProductos();
                break;
            case 5:
                productoController.mostrarIngresos();
                break;
            case 6:
                productoController.mostrarVentas();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }

    }
}
