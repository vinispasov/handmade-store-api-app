package com.project.handmadestoreapi.services;

import com.google.cloud.firestore.QuerySnapshot;
import com.project.handmadestoreapi.entities.Item;
import com.project.handmadestoreapi.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ItemService} class represents a service, which perform some business logic for Item entity.
 */
@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> getAllItems() {

		QuerySnapshot querySnapshot = itemRepository.getAllItems();

		List<Item> items = new ArrayList<>();
		if (querySnapshot != null) {
			items = querySnapshot.toObjects(Item.class);
		}

		return items;
	}

	public Item saveItem(Item item) {
		return itemRepository.saveItem(item);
	}

	public void deleteItem(Item item) {
		itemRepository.deleteItem(item);
	}

	public Item updateItem(Item item) {
		return itemRepository.updateItem(item);
	}
}
