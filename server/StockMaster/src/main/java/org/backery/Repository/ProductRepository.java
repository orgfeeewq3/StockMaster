package org.backery.Repository;

import org.backery.Model.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findById(int id);
    Product findByName(String name);
}
