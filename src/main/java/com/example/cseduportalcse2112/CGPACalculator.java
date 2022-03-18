package com.example.cseduportalcse2112;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CGPACalculator extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(CSEDUPORTAL.class.getResource("CGPACalculatorScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 680);
        stage.setTitle("CGPA Calculator");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
