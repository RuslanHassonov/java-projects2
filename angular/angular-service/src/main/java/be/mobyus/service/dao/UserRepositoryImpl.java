package be.mobyus.service.dao;

import org.springframework.stereotype.Repository;

import be.mobyus.service.domain.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Override
	public User get(String username) {
		return null;
	}

	@Override
	public void save(User user) {

	}
}
