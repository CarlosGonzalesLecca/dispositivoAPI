package com.zegel.serviceRestDispositivo.Business;
import com.zegel.serviceRestDispositivo.Entities.User;
import com.zegel.serviceRestDispositivo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserBusiness {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user) {
        try {
            String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
            return userRepository.save(user);
        } catch (Exception e) {
            throw e;
        }
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
