package org.backery.Controllers;

import jakarta.validation.Valid;
import org.backery.Model.Entities.Stored;
import org.backery.Model.Entities.Input;
import org.backery.Model.Entities.Output;
import org.backery.Model.dtos.MessageDTO;
import org.backery.Model.dtos.ProductDTO;
import org.backery.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<MessageDTO> createProduct(@Valid ProductDTO productDTO, BindingResult result) throws Exception {

        if(result.hasErrors()){
            String errors = result.getAllErrors().toString();
            return new ResponseEntity<>(
                    MessageDTO.builder().message("Error: "+errors).build(),
                    HttpStatus.BAD_REQUEST
            );
        }
        var response = productService.registerProduct(productDTO);

        return new ResponseEntity<>(
                MessageDTO.builder().message(response).build(),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<MessageDTO> getAllProducts() throws Exception {
        var response = productService.findAll();
        return new ResponseEntity<>(
                MessageDTO.builder()
                        .message("Productos encontrados: "+response.size())
                        .content(response.toString())
                        .build(),
                HttpStatus.OK
        );
    }
    /*
    Stored stored = new Stored();
    Input input = new Input();
    Output output = new Output();

    ArrayList<Stored_Old> listaStoredOld = new ArrayList<>();
    ArrayList<Input> listaInputs = new ArrayList<>();
    ArrayList<Output> listaOutputs = new ArrayList<>();

    public void crearProducto(String nombre, int cantidad){

        listaStoredOld.add(new Stored_Old(nombre, cantidad));
    }

    public void abastecerProducto(String nombre, int cantidad){
        input.setNombre(nombre);
        input.setCantidad(cantidad);
        listaInputs.add(new Input(nombre, cantidad)); // Agregar ingreso a la lista de ingresos

        boolean existe = false;
        for (Stored_Old value : listaStoredOld)
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

        for (int i = 0; i < listaStoredOld.size(); i++) {
            if (listaStoredOld.get(i).getNombre().equals(output.getNombre())) {
                if(listaStoredOld.get(i).getCantidad() >= output.getCantidad()){
                    listaStoredOld.get(i).setCantidad(listaStoredOld.get(i).getCantidad() - output.getCantidad());
                }else{
                    System.out.println("No hay suficientes productos");
                }
            }
        }
    }



    public void mostrarProductos(){ //Mostrar productos en almacen
        System.out.printf("\n%-10s %10s\n", " Nombre", "Cantidad");
        for (Stored_Old value : listaStoredOld)
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
        for (int i = 0; i < listaStoredOld.size(); i++) {
            if (listaStoredOld.get(i).getNombre().equals(nombre)) {
                listaStoredOld.remove(i);
            }
        }
    }
*/
}