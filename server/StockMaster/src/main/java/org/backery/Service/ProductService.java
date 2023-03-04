package org.backery.Service;

import org.backery.Model.Entities.Product;
import org.backery.Model.dtos.ProductDTO;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product registerProduct(ProductDTO productDTO);
}
