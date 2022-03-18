package com.example.cseduportalcse2112;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController  {



    @FXML
    private Label mylable;

    @FXML
    private TextField txtusername;

    @FXML
    private PasswordField txtpassword;

    public void LoginCode(ActionEvent event)
    {
        if(txtusername.getText().equals("myuser") && txtpassword.getText().equals("mypass"))
        {
          mylable.setText("Login Successful");
        }
        else
        {
            mylable.setText("Incorrect Username or Password");
        }
    }


}
