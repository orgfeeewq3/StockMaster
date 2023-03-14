package org.backery.Service.impl;

import org.backery.Model.Entities.Product;
import org.backery.Model.dtos.ProductDTO;
import org.backery.Repository.ProductRepository;
import org.backery.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    String successMessage = "Producto agregado exitosamente!";
    @Override
    public List<Product> findAll() throws Exception{
        return productRepository.findAll();
    }
    @Override
    public String registerProduct(ProductDTO productDTO) throws Exception{
        try {
            Product newProduct = Product.builder()
                    .name(productDTO.getName())
                    .description(productDTO.getDescription())
                    .build();
            productRepository.save(newProduct);
            return successMessage;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}