package Controllers;

import Models.AttendanceModel;
import Models.CSEDUPORTALUtils;
import Models.NavigationHandler;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AttendanceScreenController extends AttendanceModel implements Initializable {
    //Navigation
    @FXML
    private Text home;
    @FXML
    private Text classroom;
    @FXML
    private Text attendance;
    @FXML
    private Text booklet;
    @FXML
    private Text cgpa;
    @FXML
    private Text logout;
    @FXML
    private ImageView LogoutImage;

    @FXML
    private Text coursename1;
    @FXML
    private Text coursename2;
    @FXML
    private Text coursename3;
    @FXML
    private Text coursename4;
    @FXML
    private Text coursename5;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        NavigationHandler.HandleNavigation(home,classroom,attendance,booklet,cgpa,logout);

        LogoutImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent,"LoginScreen.fxml","Log in",null);
            }
        });
        coursename1.setText(getCourseName().get(0));
        coursename2.setText(getCourseName().get(1));
        coursename3.setText(getCourseName().get(2));
        coursename4.setText(getCourseName().get(3));
        coursename5.setText(getCourseName().get(4));
    }
}
