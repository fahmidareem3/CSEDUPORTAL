package com.example.cseduportalcse2112;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupScreenController  implements Initializable {
    @FXML
    private Button SignupScreenLogin;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SignupScreenLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Button Clicked");
                CSEDUPORTALUtils.changeScence(actionEvent,"LoginScreen.fxml","Log in",null);
            }
        });
    }


}
