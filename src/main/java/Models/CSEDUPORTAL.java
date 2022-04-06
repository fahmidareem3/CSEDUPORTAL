package Models;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CSEDUPORTAL extends Application {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CSEDUPORTAL.class.getResource("WelcomeScreen.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 1100, 680);

        stage.setTitle("CSEDU PORTAL");
        stage.setScene(scene);
        Image image = new Image(getClass().getResourceAsStream("/assets/CSEDULOGO.png"));
        stage.getIcons().add(image);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }


}