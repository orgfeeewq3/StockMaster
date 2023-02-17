package org.backery.Service.impl;

import org.backery.Model.Entities.Usuario;
import org.backery.Repository.UserRepository;
import org.backery.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
//    @Autowired
    private UserRepository userRepository;
    @Override
    public Usuario findOneByUsername(String username) {
        return null;
    }

    @Override
    public Usuario findOneById(int id) throws Exception {
        Usuario foundUser = userRepository
                .findById(id)
                .orElse(null);
        return foundUser;
    }

    @Override
    public List<Usuario> findAll() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public Usuario findOneByIdentifer(String identifier) throws Exception {
        Usuario foundUser = userRepository
                .findOneByUsernameOrEmail(identifier, identifier);
        return foundUser;
    }

    @Override
    public Usuario findOneByUsernameAndEmail(String username, String email) throws Exception {
        Usuario foundUser = userRepository
                .findOneByUsernameOrEmail(username, email);
        return foundUser;
    }

    @Override
    public Boolean comparePassword(Usuario user, String passToCompare) throws Exception {
       Usuario userFound = findOneById(user.getId());
       return userFound.getContrasena().equals(passToCompare);
    }
}
