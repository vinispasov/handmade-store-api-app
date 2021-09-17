package com.project.handmadestoreapi.services;

import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.project.handmadestoreapi.entities.Order;
import com.project.handmadestoreapi.repositories.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getAllOrders() {

		QuerySnapshot querySnapshot = orderRepository.getAllOrders();
		List<Order> orders = new ArrayList<>();

		if (querySnapshot != null) {
			orders = querySnapshot.toObjects(Order.class);
		}

		return orders;
	}

	public List<Order> getOrdersByEmail(String email) {

		List<QueryDocumentSnapshot> documents = orderRepository.getOrdersByEmail(email);

		if (documents != null) {
			return convertToListWithOrders(documents);
		}

		return null;
	}

	private List<Order> convertToListWithOrders(List<QueryDocumentSnapshot> documents) {
		List<Order> customerOrders = new ArrayList<>();
		documents.forEach(document -> customerOrders.add(document.toObject(Order.class)));

		return customerOrders;
	}

}
