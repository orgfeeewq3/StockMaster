package org.backery.Service;

import org.backery.Model.Entities.User;
import org.backery.Model.dtos.SignInDTO;
import org.backery.Model.dtos.SignUpDTO;
import java.util.List;

public interface UserService {
    User findOneByUsername(String username)throws Exception;
    Boolean existsByIdentifier(String identifier) throws Exception;
    Boolean login(SignInDTO signIn) throws Exception;
    Boolean register(SignUpDTO singUp) throws Exception;
    User findOneById(int id) throws Exception;
    List<User> findAll() throws Exception;
    User findOneByIdentifer(String identifier) throws Exception;
    User findOneByUsernameAndEmail(String username, String email) throws Exception;
    Boolean comparePassword(User user, String passToCompare) throws Exception;

//    void insertToken(User user, String token) throws Exception;
//    Boolean isTokenValid(User user, String token) throws Exception;
//    User getUserAuthenticated() throws Exception;

}
