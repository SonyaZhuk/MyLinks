package mylinks.service;


import mylinks.model.Role;
import mylinks.model.User;
import mylinks.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import mylinks.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
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
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(roleRepository.getOne(1L));
            user.setRoles(roleSet);
        }
        return userRepository.save(user);
    }
}
