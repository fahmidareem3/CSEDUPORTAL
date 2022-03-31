package com.example.cseduportalcse2112;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginScreenController extends Login implements Initializable {
    @FXML
    private  Button LoginScreenSignup;

    @FXML
    private TextField userRegistration;
    @FXML
    private TextField userPassword;
    @FXML
    private Button loginButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoginScreenSignup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CSEDUPORTALUtils.changeScence(actionEvent,"SignupScreen.fxml","Sign Up",null);

            }
        });
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CSEDUPORTALUtils.loginUser(actionEvent,userRegistration.getText(),userPassword.getText());

            }
        });
    }


}
