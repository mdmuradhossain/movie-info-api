package io.murad.movie.info.service;

//import java.io.FileInputStream;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.stereotype.Service;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;

//@Service
//public class FBInitialize {
//
//	@PostConstruct
//	public void initialize() {
//		try {
//			FileInputStream serviceAccount =
//					  new FileInputStream("E:\\Java\\service_account.json");
//
//					FirebaseOptions options = new FirebaseOptions.Builder()
//					  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//					  .setDatabaseUrl("https://movie-info-app-e5617.firebaseio.com")
//					  .build();
//
//					FirebaseApp.initializeApp(options);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
