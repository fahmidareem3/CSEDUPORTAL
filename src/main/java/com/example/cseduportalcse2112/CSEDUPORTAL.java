package com.example.cseduportalcse2112;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CSEDUPORTAL extends Application {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CSEDUPORTAL.class.getResource("WelcomeScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 680);
        stage.setTitle("CSEDU PORTAL");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }


}