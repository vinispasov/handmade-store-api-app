package com.project.handmadestoreapi.repositories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.project.handmadestoreapi.configuration.DatabaseConfig;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Repository;
/**
 * The {@code OrderRepository} class represents a repository, which is connected with the Order entity representation in the database.
 */
@Repository
public class OrderRepository {

	private final DatabaseConfig databaseConfig = new DatabaseConfig();

	public QuerySnapshot getAllOrders() {

		Firestore db = databaseConfig.getFirestore();

		ApiFuture<QuerySnapshot> query = db.collection("orders").get();
		QuerySnapshot querySnapshot = null;
		try {
			querySnapshot = query.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return querySnapshot;
	}

	public List<QueryDocumentSnapshot> getOrdersByEmail(String email) {
		CollectionReference collectionReference = databaseConfig.getFirestore()
				.collection("orders");

		try {
			return collectionReference.whereEqualTo("email", email).get().get().getDocuments();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}


}
