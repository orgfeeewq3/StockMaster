package org.example;

public class Main {
    public static void main(String[] args) {
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
    }
}