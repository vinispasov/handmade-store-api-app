package com.project.handmadestoreapi.services;

import com.project.handmadestoreapi.entities.User;
import com.project.handmadestoreapi.repositories.ItemRepository;
import com.project.handmadestoreapi.repositories.UserRepository;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
/**
 * The {@code UserService} class represents a service, which perform some business logic for User entity.
 */
@Service
public class UserService {

	private final UserRepository userRepository;
	private final ItemRepository itemRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, ItemRepository itemRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.itemRepository = itemRepository;
		this.passwordEncoder = passwordEncoder;
	}


	/**
	 * The {@code createUser} method is responsible for the new users registrations.
	 */
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
	/**
	 * The {@code updateBasket} method is responsible for all the interactions with the basket.
	 * The basket is basically list with items, which is located in the User entity.
	 * Adding and removing items from the basket goes through this method.(The list inside the User is updated.)
	 */
	public User updateBasket(User incomingUser) {

		if (Objects.equals(incomingUser, null)) {
			return null;
		}
		User existingUser = userRepository.getUserByEmail(incomingUser.getEmail());

		if (existingUser != null) {
			userRepository.updateUser(incomingUser);
			incomingUser.setItemsInBasket(itemRepository.getListWithItemsFromIds(incomingUser.getItemIdsInBasket()));
			return incomingUser;
		}

		return null;
	}

}
