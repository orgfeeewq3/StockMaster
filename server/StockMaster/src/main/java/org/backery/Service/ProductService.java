package org.backery.Service;

import org.backery.Model.Entities.Product;
import org.backery.Model.dtos.ProductDTO;

import java.util.List;

public interface ProductService {

    List<Product> findAll() throws Exception;
    String registerProduct(ProductDTO productDTO) throws Exception;
}
