package org.example;

public class Main {
    public static void main(String[] args) {
//        mostrarMenu();
        prodControl();
    }

//    public static void mostrarMenu(){
//        System.out.println("1. Crear producto");
//        System.out.println("2. Abastecer producto");
//        System.out.println("3. Vender producto");
//        System.out.println("4. Mostrar productos");
//        System.out.println("5. Mostrar ingresos");
//        System.out.println("6. Mostrar ventas");
//        System.out.println("7. Salir");
//    }
    public static void prodControl(){
        ProductoController productoController = new ProductoController();

        System.out.println("Bienvenido al sistema de almacen");
        System.out.println("\n1. Crear producto");
        productoController.crearProducto("Coca Cola", 10);
        productoController.crearProducto("Pepsi", 10);
        productoController.crearProducto("Fanta", 10);

        productoController.mostrarProductos();

        System.out.println("\n2. Vender producto");
        productoController.venderProducto("Coca Cola", 5);
        productoController.venderProducto("Pepsi", 3);
        productoController.venderProducto("Fanta", 7);

        productoController.mostrarProductos();

        System.out.println("\n3. Abastecer producto");
        productoController.abastecerProducto("Coca Cola", 5);
        productoController.abastecerProducto("Pepsi", 3);
        productoController.abastecerProducto("Fanta", 7);

        productoController.mostrarProductos();
        productoController.mostrarVentas();
        productoController.mostrarIngresos();
    }
}