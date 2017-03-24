package mylinks.service;


import mylinks.model.User;
import java.util.List;

public interface UserService {

    User findByUsername(String username);

    List<User> findAll();
}
