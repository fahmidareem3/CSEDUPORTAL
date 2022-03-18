package com.example.cseduportalcse2112;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeScreenController implements Initializable{
    @FXML
    private Label welcomeText;
    @FXML
    private Button getStartedButton;
    @FXML
    private Button WelcomeScreenLogin;



        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            getStartedButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Button Clicked");
                CSEDUPORTALUtils.changeScence(actionEvent,"SignupScreen.fxml","Log in",null);
            }
        });
            WelcomeScreenLogin.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println("Button Clicked");
                    CSEDUPORTALUtils.changeScence(actionEvent,"LoginScreen.fxml","Log in",null);
                }
            });

        }
    }