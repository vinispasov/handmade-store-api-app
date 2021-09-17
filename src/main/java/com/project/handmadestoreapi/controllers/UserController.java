package com.project.handmadestoreapi.controllers;

import com.project.handmadestoreapi.entities.User;
import com.project.handmadestoreapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.PUT)
	public User loginUser(@RequestBody User user) {
		return userService.loginUser(user);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.PUT)
	public User logoutUser(@RequestBody User user) {
		return userService.logoutUser(user);
	}

	@RequestMapping(value = "/basket", method = RequestMethod.PUT)
	public User updateBasket(@RequestBody User user) {
		return userService.updateBasket(user);
	}
}
