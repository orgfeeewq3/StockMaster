package org.backery.Repository;

import org.backery.Model.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepotory extends JpaRepository<User, Integer> {
    User findOneByUsername(String username);
}
