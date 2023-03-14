package org.backery.Service.impl;

import org.backery.Model.Entities.Product;
import org.backery.Model.dtos.ProductDTO;
import org.backery.Repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl {

    String successMessage = "Producto agregado exitosamente!";
    private ProductRepository productRepository;

    public List<Product> findAll() throws Exception {
        return productRepository.findAll();
    }

    public String registerProduct(ProductDTO productDTO) {
        Product newProduct = new Product(productDTO.getId(),productDTO.getName(), productDTO.getDescription(), productDTO.getImageurl());

        productRepository.save(newProduct);
        return successMessage;

    }
}
