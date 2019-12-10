package be.mobyus.service.dao;

import be.mobyus.service.domain.User;

public interface UserRepository {

    User get(String username);

    void save(User user);
}
