package com.project.handmadestoreapi.services;

import com.project.handmadestoreapi.entities.User;
import com.project.handmadestoreapi.repositories.UserRepository;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}


	public User createUser(User userToCreate) {
		if (Objects.equals(userToCreate.getPassword(), null)) {
			throw new RuntimeException();
		}
		String encodedPassword = passwordEncoder.encode(userToCreate.getPassword());
		userToCreate.setPassword(encodedPassword);
		return userRepository.saveUser(userToCreate);
	}

	public User loginUser(User incomingUser) {

		if (Objects.equals(incomingUser, null)) {
			return null;
		}
		User user = userRepository.getUserByEmail(incomingUser.getEmail());
		boolean isLoginSuccessful;

		try {
			isLoginSuccessful = passwordEncoder.matches(incomingUser.getPassword(), user.getPassword());
		} catch (NullPointerException npe) {
			return null;
		}
		if (isLoginSuccessful) {
			user.setLoggedIn(true);
			userRepository.updateUser(user);
			return user;
		}

		return null;
	}

	public User logoutUser(User incomingUser) {

		if (Objects.equals(incomingUser, null)) {
			return null;
		}
		User user = userRepository.getUserByEmail(incomingUser.getEmail());

		if (user != null && user.isLoggedIn()) {
			user.setLoggedIn(false);
			userRepository.updateUser(user);
			return user;
		}

		return null;

	}

	public User updateBasket(User incomingUser) {

		if (Objects.equals(incomingUser, null)) {
			return null;
		}
		User user = userRepository.getUserByEmail(incomingUser.getEmail());

		if (user != null) {
			userRepository.updateUser(user);
			return user;
		}

		return null;
	}

}
