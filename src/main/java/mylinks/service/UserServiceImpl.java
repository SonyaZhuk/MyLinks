package mylinks.service;


import mylinks.model.Role;
import mylinks.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mylinks.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) throws Exception {
        if (user.getId() == null) {
            if (!user.getPassword().equals(user.getPassword())) {
                throw new Exception("Password fields are not equals");
            }
            user.setPassword(user.getPassword());
//            Set<Role> roleSet = new HashSet<>();
////            roleSet.add(roleRepository.findByName("user"));
//            user.setRoles(roleSet);
        }
        return userRepository.save(user);
    }
}
