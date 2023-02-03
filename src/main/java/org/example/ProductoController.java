package org.example;
import java.util.ArrayList;

public class ProductoController {
    Almacen almacen = new Almacen();
    Ingreso ingreso = new Ingreso();
    Venta venta = new Venta();

    ArrayList<Almacen> listaAlmacen = new ArrayList<Almacen>();

    public void crearProducto(String nombre, int cantidad){
        listaAlmacen.add(new Almacen(nombre, cantidad));
    }

    public void abastecerProducto(String nombre, int cantidad){
        ingreso.setNombre(nombre);
        ingreso.setCantidad(cantidad);
        for (Almacen value : listaAlmacen)
            if (value.getNombre().equals(ingreso.getNombre()))
                value.setCantidad(value.getCantidad() + ingreso.getCantidad());
    }

    public void venderProducto(String nombre, int cantidad){
        venta.setNombre(nombre);
        venta.setCantidad(cantidad);
        for (int i = 0; i < listaAlmacen.size(); i++) {
            if (listaAlmacen.get(i).getNombre().equals(venta.getNombre())) {
                if(listaAlmacen.get(i).getCantidad() >= venta.getCantidad()){
                    listaAlmacen.get(i).setCantidad(listaAlmacen.get(i).getCantidad() - venta.getCantidad());
                }else{
                    System.out.println("No hay suficientes productos");
                }
            }
        }
    }



    public void mostrarProductos(){
        System.out.printf("\n%-10s %10s\n", " Nombre", "Cantidad");
        for (Almacen value : listaAlmacen)
            System.out.printf("|%-10s|%10d|\n", value.getNombre() , value.getCantidad());
    }





//    public void sacarProducto(String nombre, int cantidad){
//        almacen.setNombre(nombre);
//        almacen.setCantidad(cantidad);
//        listaAlmacen.remove(almacen);
//    }
}
