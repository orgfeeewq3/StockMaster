package org.backery.Repository;

import org.backery.Model.Entities.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private static ArrayList<Usuario> usersList = new ArrayList<>();
    static {
        usersList.add(new Usuario(1, "moises", "moises@email.com", "moi123", "1234"));
        usersList.add(new Usuario(2, "alexi", "alexi@email.com", "alx123", "7890"));
    }

    public List<Usuario> findAll() {
        return usersList;
    }

    public Optional<Usuario> findById(int id) {
        return usersList.stream().filter(user -> user.getId() == id).findFirst();
    }

    public Usuario findOneByUsernameOrEmail(String identifier, String identifier1) {
        usersList.stream().filter(
                user -> user.getUsuario() == identifier || user.getCorreo() ==
                        identifier1).findFirst();
        return null;
    }
}
