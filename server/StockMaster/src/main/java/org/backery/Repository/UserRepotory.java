package org.backery.Repository;

import org.backery.Model.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Repository
public interface UserRepotory  {
    //User findOneByUsername(String username);
}


//package org.backery.Repository;
//
//        import org.backery.Model.Entities.User;
//        import org.springframework.stereotype.Repository;
//
//        import java.util.ArrayList;
//        import java.util.List;
//        import java.util.Optional;
//@Repository
//public class UserRepository {
//    private static ArrayList<User> usersList = new ArrayList<>();
//    static {
////        usersList.add(new User(1, "moises", "moises@email.com", "moi123", "1234"));
////        usersList.add(new User(2, "alexi", "alexi@email.com", "alx123", "7890"));
//    }
//    public void insertUser(User user){
//        usersList.add(user);
//    }
//    public Boolean existsByIdentifier(String identifier){ //existe un user con ese username o email?
//        return usersList.stream().anyMatch(
//                user -> user.getUsername().equals(identifier) ||
//                        user.getEmail().equals(identifier));
//    }
//    public List<User> findAll() {
//        return usersList;
//    } //SELECT * FROM users
//
//    public Optional<User> findById(int id) {
//        return usersList.stream().filter(user -> user.getId() == id).findFirst();
//    }
//
//    public User findOneByUsernameOrEmail(String identifier, String identifier2) {
//        System.out.println("identifierRepo: " + identifier);
//        User userFound = usersList.stream().filter(
//                user -> user.getUsername().equals(identifier) || user.getEmail().equals(identifier2)).findFirst().orElse(null);
//        return userFound;
//    }
//}

