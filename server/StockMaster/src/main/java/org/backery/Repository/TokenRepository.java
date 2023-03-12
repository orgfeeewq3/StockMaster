package org.backery.Repository;

import org.backery.Model.Entities.Token;
import org.backery.Model.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    List<Token> findByUserAndActive(User user, Boolean active);

}