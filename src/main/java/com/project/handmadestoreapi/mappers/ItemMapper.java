package com.project.handmadestoreapi.mappers;

import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.project.handmadestoreapi.entities.Item;

import java.util.List;

public class ItemMapper {

	public Item mapObjectToItem(QueryDocumentSnapshot queryDocumentSnapshot) {
		return queryDocumentSnapshot.toObject(Item.class);
	}
}
