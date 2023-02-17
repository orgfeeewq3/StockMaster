package org.backery.Repository;

import org.backery.Model.Entities.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class UserRepository {
    private static ArrayList<Usuario> usersList = new ArrayList<>();
    static {
        usersList.add(new Usuario(1, "moises", "moises@email.com", "moi123", "1234"));
        usersList.add(new Usuario(2, "alexi", "alexi@email.com", "alx123", "7890"));
    }
    public Boolean existsByUsername(String username){
        return usersList.stream().anyMatch(user -> user.getUsuario().equals(username));
    }
    public List<Usuario> findAll() {
        return usersList;
    }

    public Optional<Usuario> findById(int id) {
        return usersList.stream().filter(user -> user.getId() == id).findFirst();
    }

    public Usuario findOneByUsernameOrEmail(String identifier, String identifier2) {
        System.out.println("identifierRepo: " + identifier);
        Usuario userFound = usersList.stream().filter(
                user -> user.getUsuario().equals(identifier) || user.getCorreo().equals(identifier2)).findFirst().orElse(null);
        return userFound;
    }
}
