package org.backery.Repository;

import org.backery.Model.Entities.Token;
import org.backery.Model.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    Optional<List<Token>> findByIdUserAndActive(User user, Boolean active);


    Optional<Token> findById(Integer integer);
}