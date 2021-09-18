package com.project.handmadestoreapi.controllers;

import com.project.handmadestoreapi.entities.Item;
import com.project.handmadestoreapi.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Item saveItem(@RequestBody Item item) {
		return itemService.saveItem(item);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteItem(@RequestBody Item item) {
		 itemService.deleteItem(item);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Item updateItem(@RequestBody Item item) {
		return itemService.updateItem(item);
	}
}
