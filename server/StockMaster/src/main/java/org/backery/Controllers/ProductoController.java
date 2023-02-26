package org.backery.Controllers;
import org.backery.Model.Entities.Stored;
import org.backery.Model.Entities.Input;
import org.backery.Model.Entities.Output;

import java.util.ArrayList;

public class ProductoController {
    Stored stored = new Stored();
    Input input = new Input();
    Output output = new Output();

    ArrayList<Stored> listaStored = new ArrayList<>();
    ArrayList<Input> listaInputs = new ArrayList<>();
    ArrayList<Output> listaOutputs = new ArrayList<>();

    public void crearProducto(String nombre, int cantidad){

        listaStored.add(new Stored(nombre, cantidad));
    }

    public void abastecerProducto(String nombre, int cantidad){
        input.setNombre(nombre);
        input.setCantidad(cantidad);
        listaInputs.add(new Input(nombre, cantidad)); // Agregar ingreso a la lista de ingresos

        boolean existe = false;
        for (Stored value : listaStored)
            if (value.getNombre().equals(input.getNombre())) {
                value.setCantidad(value.getCantidad() + input.getCantidad());
                existe = true;
            }
        if(!existe)
            System.out.println("El producto no existe");
    } //---------

    public void venderProducto(String nombre, int cantidad){
        output.setNombre(nombre);
        output.setCantidad(cantidad);
        listaOutputs.add(new Output(nombre,cantidad)); // Agregar venta a la lista de ventas

        for (int i = 0; i < listaStored.size(); i++) {
            if (listaStored.get(i).getNombre().equals(output.getNombre())) {
                if(listaStored.get(i).getCantidad() >= output.getCantidad()){
                    listaStored.get(i).setCantidad(listaStored.get(i).getCantidad() - output.getCantidad());
                }else{
                    System.out.println("No hay suficientes productos");
                }
            }
        }
    }



    public void mostrarProductos(){ //Mostrar productos en almacen
        System.out.printf("\n%-10s %10s\n", " Nombre", "Cantidad");
        for (Stored value : listaStored)
            System.out.printf("|%-10s|%10d|\n", value.getNombre() , value.getCantidad());
    }

    public void mostrarIngresos(){ //Mostrar ingresos de productos
        System.out.printf("\n%-10s %10s\n", " Nombre", "Cantidad");
        for (Input value : listaInputs)
            System.out.printf("|%-10s|%10d|\n", value.getNombre() , value.getCantidad());
    }

    public void mostrarVentas(){ //Mostrar ventas de productos
        System.out.printf("\n%-10s %10s\n", " Nombre", "Cantidad");
        for (Output value : listaOutputs)
            System.out.printf("|%-10s|%10d|\n", value.getNombre() , value.getCantidad());
    }



    public void destruirProducto(String nombre){
        for (int i = 0; i < listaStored.size(); i++) {
            if (listaStored.get(i).getNombre().equals(nombre)) {
                listaStored.remove(i);
            }
        }
    }
}
