package org.backery.Repository;

import org.backery.Model.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(int id) throws Exception;
    Optional<Product> findByName(String name) throws Exception;
}
