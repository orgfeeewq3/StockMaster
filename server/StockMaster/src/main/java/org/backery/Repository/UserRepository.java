package org.backery.Repository;

import org.backery.Model.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsernameOrEmail(String username, String email);
    User findByUsername(String username);


    Optional<User> findByEmail(String email);

    //User findByEmail(String email);
    Boolean existsByUsernameOrEmail(String username, String email);
}