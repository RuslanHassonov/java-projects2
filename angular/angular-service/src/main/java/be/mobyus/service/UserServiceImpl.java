package be.mobyus.service;

import be.mobyus.service.dao.UserRepository;
import be.mobyus.service.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User loadUser(String username) {
        User user = userRepository.get(username);
        user.setPassword(null);
        return user;
    }
}
