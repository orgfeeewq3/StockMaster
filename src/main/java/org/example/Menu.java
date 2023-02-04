package org.example;

import java.util.Scanner;

public class Menu {
    Scanner lector = new Scanner(System.in);
    int opcion = 0;
    Producto productoobj = new Producto();
    public void mostrar_menu() {
        while (opcion != 4) {
            System.out.println("Bienvenido a StockMaster. Elige una de las opciones.");
            System.out.println(" 1. Ingresar producto nuevo. \n 2. Consultar inventario actual. \n 3. Generar reporte. \n 4. Salir");
            opcion = lector.nextInt();

            switch (opcion) {
                case 1 -> productoobj.ingresar_prod();
                case 2 -> productoobj.mostrar_prod();
                case 3 -> System.out.println("aun no hago nada");
                case 4 -> {
                    break;
                }
                default -> {
                }
            }
        }
    }
}