package mylinks.service;


import mylinks.model.User;
import java.util.List;

public interface UserService {

    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findAll();

    User save(User user) throws Exception;
}
