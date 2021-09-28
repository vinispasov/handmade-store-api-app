package com.project.handmadestoreapi.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.SetOptions;
import com.project.handmadestoreapi.configuration.DatabaseConfig;
import com.project.handmadestoreapi.entities.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
/**
 * The {@code ItemRepository} class represents a repository, which is connected with the Item entity representation in the database.
 */
@Repository
public class ItemRepository {
	private final DatabaseConfig databaseConfig = new DatabaseConfig();

	public QuerySnapshot getAllItems() {

		Firestore db = databaseConfig.getFirestore();

		ApiFuture<QuerySnapshot> query = db.collection("items").get();
		QuerySnapshot querySnapshot = null;
		try {
			querySnapshot = query.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return querySnapshot;
	}

	public Item saveItem(Item item) {
		DocumentReference documentReference = databaseConfig.getFirestore().collection("items").document();
		item.setId(documentReference.getId());
		documentReference.set(item, SetOptions.merge());
		return item;
	}

	public void deleteItem(Item item) {
		databaseConfig.getFirestore()
				.collection("items")
				.document(item.getId())
				.delete();
	}

	public Item updateItem(Item item) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> itemMap = objectMapper.convertValue(item, Map.class);
		databaseConfig.getFirestore()
				.collection("items")
				.document(item.getId())
				.update(itemMap);

		return item;
	}

	/**
	 * The {@code getListWithItemsFromIds} method receive @param itemIds, it takes the list with Item entity from itemIds,
	 * because there are restrictions in Firestore database and we cannot save list with another entity in the current one.
	 * That's why we save the itemIds as a list with strings and afterwards we get the actual items from the Item records.
	 */
	public List<Item> getListWithItemsFromIds (List<String> itemIds) {
		List<Item> items = new ArrayList<>();
		itemIds.forEach(itemId -> {
			try {
				items.add(databaseConfig.getFirestore()
						.collection("items")
						.document(itemId).get().get().toObject(Item.class));
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
		return items;
	}
}
