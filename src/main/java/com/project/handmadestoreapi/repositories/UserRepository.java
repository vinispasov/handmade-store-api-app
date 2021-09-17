package com.project.handmadestoreapi.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.SetOptions;
import com.project.handmadestoreapi.configuration.DatabaseConfig;
import com.project.handmadestoreapi.entities.User;
import com.project.handmadestoreapi.exceptions.UserExistException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	private final DatabaseConfig databaseConfig = new DatabaseConfig();

	public User saveUser(User user) {
		if (getUserByEmail(user.getEmail()) != null) {
			throw new UserExistException("User already exist");
		}
		DocumentReference documentReference = databaseConfig.getFirestore().collection("users").document();
		user.setId(documentReference.getId());
		documentReference.set(user, SetOptions.merge());
		return user;
	}

	public User updateUser(User user) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> userMap = objectMapper.convertValue(user, Map.class);
		databaseConfig.getFirestore()
				.collection("items")
				.document(user.getId())
				.update(userMap);

		return user;
	}

	public User getUserByEmail(String email) {
		CollectionReference collectionReference = databaseConfig.getFirestore()
				.collection("users");

		try {
			List<QueryDocumentSnapshot> documents =
					collectionReference.whereEqualTo("email", email).get().get().getDocuments();

			if (!documents.isEmpty()) {
				return documents.get(0).toObject(User.class);
			}
			return null;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}


}
