package org.example;

import java.util.Scanner;

public class Producto {
    Scanner lector = new Scanner(System.in);
    String[][] matriz_prod = new String[1][5];
    /*
    pueden cambiar los valores en la matriz para que sean mas grandes. para debugging, la hice pequeña. el 1 corresponde a las filas, y el 5 a las columnas
    si cambian el tamaño de la matrirz, no olviden cambiar tambien los valores en las for loops de mostrar_prod.
     */
    public void ingresar_prod() {
        System.out.println("""
                Digita los datos del producto en el siguiente orden:
                 Nombre del articulo
                 Codigo del articulo
                 Nombre del proveedor
                 Fecha de ingreso
                 Cantidad ingresada""");

        for(int i = 0; i < 1; i++) {
            for(int j = 0; j < 5; j++) {
                matriz_prod[i][j] = lector.next();
            }
            System.out.println();
        }
    }
    public void mostrar_prod() {
        System.out.println("+++Reporte+++");
        System.out.println("Nombre del Articulo " + " Codigo del articulo " + " Nombre del proveedor " + " Fecha de ingreso " + " Cantidad ingresada ");
        for (int i = 0; i < 1; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.print(matriz_prod[i][j] + "                    " );
            }
            System.out.println();
        }
    }
}