package com.example.cseduportalcse2112;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WelcomeScreenController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}