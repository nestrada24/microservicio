package com.accenture.technology.repository;

import java.util.List;
import java.util.Optional;

import com.accenture.technology.doc.User;

public interface UserRepository {

	public Optional<List<User>> findAll();

	public User saveUser(User user);

	public void updateUser(User user);

	public void deleteUser(String userId);

	public Optional<User> findOne(String userId);
	  
}
