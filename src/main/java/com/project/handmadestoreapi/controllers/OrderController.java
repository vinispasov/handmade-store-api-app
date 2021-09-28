package com.project.handmadestoreapi.controllers;


import com.project.handmadestoreapi.entities.Order;
import com.project.handmadestoreapi.services.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@code OrderController} class represents an endpoint from where you can interact with the Order entity
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@RequestMapping( value = "/email",method = RequestMethod.GET)
	public List<Order> getOrdersByEmail(@RequestBody String email) {
		return orderService.getOrdersByEmail(email);
	}


}
