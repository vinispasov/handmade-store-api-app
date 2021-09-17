package com.project.handmadestoreapi.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;

public class DatabaseConfig {

	private static Firestore FIRESTORE;

	public static Firestore getFirestore() {

		if (FIRESTORE != null) {
			return FIRESTORE;
		}

		FileInputStream serviceAccount;
		FirebaseOptions options = null;
		try {
			serviceAccount = new FileInputStream("D:\\Programming\\Repos\\handmade-store-api-app\\src\\main\\resources\\handmade-store-api-firebase-adminsdk-vaerz-7d3c0933fd.json");
			options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://handmade-store-api-default-rtdb.europe-west1.firebasedatabase.app")
					.build();

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (options != null) {
			FirebaseApp.initializeApp(options);
		}

		FIRESTORE = FirestoreClient.getFirestore();

		return FIRESTORE;
	}
}
