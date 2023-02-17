package org.backery.Service;

import org.backery.Model.Entities.Usuario;

import java.util.List;

public interface UserService {

    Usuario findOneByUsername(String username);

//    void register(UserInfo userInfo) throws Exception;
    Usuario findOneById(int id) throws Exception;
    List<Usuario> findAll() throws Exception;
    Usuario findOneByIdentifer(String identifier) throws Exception;
    Usuario findOneByUsernameAndEmail(String username, String email) throws Exception;
    Boolean comparePassword(Usuario user, String passToCompare) throws Exception;

//    void insertToken(User user, String token) throws Exception;
//    Boolean isTokenValid(User user, String token) throws Exception;
//    User getUserAuthenticated() throws Exception;

}
