package org.backery.Repository;

import org.backery.Model.Entities.Stored;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoredRepository extends JpaRepository<Stored, Integer> {
    Stored findById(int id);
    Stored findByName(String name);
    Stored findByAvailable(int available);
    Stored existsStoredById(int id);
}
