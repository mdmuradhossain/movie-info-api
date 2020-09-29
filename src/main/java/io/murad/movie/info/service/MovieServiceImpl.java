package io.murad.movie.info.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import io.murad.movie.info.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	public static final String COL_NAME = "users";

	@Override
	public String saveMovieInfo(Movie movie) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(movie.getMovieName())
				.set(movie);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	@Override
	public Movie getMovieInfoByName(String movieName) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(movieName);
		ApiFuture<DocumentSnapshot> future = documentReference.get();

		DocumentSnapshot document = future.get();

		Movie movie = null;

		if (document.exists()) {
			movie = document.toObject(Movie.class);
			return movie;
		} else {
			return null;
		}
	}

	@Override
	public String updateMovieInfo(Movie movie) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(movie.getMovieName())
				.set(movie);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	@Override
	public String deleteMovieInfoByName(String movieName) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(movieName).delete();
		return "Document with Patient ID " + movieName + " has been deleted";
	}

}
