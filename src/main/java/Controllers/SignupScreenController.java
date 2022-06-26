package Controllers;

import Models.CSEDUPORTALUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupScreenController  implements Initializable {
    @FXML
    private Button SignupScreenLogin;
    @FXML
    private ChoiceBox signupSemesterChoicebox;
    @FXML
    private ChoiceBox signupYearChoicebox;
    @FXML
    private TextField studentName;
    @FXML
    private TextField studentEmail;
    @FXML
    private TextField studentPassword;
    @FXML
    private TextField studentRoll;
    @FXML
    private TextField studentReg;


    @FXML
    private Button signupbutton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        signupSemesterChoicebox.getItems().addAll("1","2");
        signupSemesterChoicebox.setValue("1");

        signupYearChoicebox.getItems().addAll("1","2","3","4");
        signupYearChoicebox.setValue("2");

        SignupScreenLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CSEDUPORTALUtils.changeScence(actionEvent,"LoginScreen.fxml","Log in",null);
            }
        });

        signupbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CSEDUPORTALUtils.signUpUser(actionEvent,studentName.getText(),studentEmail.getText(),studentPassword.getText(), (String) signupSemesterChoicebox.getValue(), (String) signupYearChoicebox.getValue(),studentRoll.getText(),studentReg.getText());
            }
        });
    }


}
