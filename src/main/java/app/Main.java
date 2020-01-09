package app;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Main implements ServletContextListener {
        public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            File file = new DefaultResourceLoader().getResource("firebase.json").getFile();
            FileInputStream serviceAccount =
                    new FileInputStream(file);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://spring-firebase-eac32.firebaseio.com/")
                    .setStorageBucket("spring-firebase-eac32.appspot.com")
                    .build();
            FirebaseApp.initializeApp(options);
            serviceAccount.close();
            System.out.println("connect success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
