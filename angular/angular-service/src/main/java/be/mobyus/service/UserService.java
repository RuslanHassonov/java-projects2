package be.mobyus.service;

import be.mobyus.service.domain.User;

public interface UserService {

    User loadUser(String username);
}
