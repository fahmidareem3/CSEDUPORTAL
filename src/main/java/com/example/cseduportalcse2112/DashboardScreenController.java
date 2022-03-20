package com.example.cseduportalcse2112;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardScreenController implements Initializable {
//    @FXML
//    private Button logoutButton;
    @FXML
    private ImageView LogoutImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("Button Clicked");
//                CSEDUPORTALUtils.changeScence(actionEvent,"LoginScreen.fxml","Log in",null);
//            }
//        });
//
        LogoutImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent,"LoginScreen.fxml","Log in",null);
            }
        });
    }
}
