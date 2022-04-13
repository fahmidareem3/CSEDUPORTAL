package Controllers;

import Models.CSEDUPORTALUtils;
import Models.ClassroomScreenModel;
import Models.DATAHUB;
import Models.NavigationHandler;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ClassroomScreenController extends ClassroomScreenModel  implements Initializable  {
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

    //Classroom Screen Data Fields

    @FXML
    private Text classroomcode1;
    @FXML
    private Text classroomcode2;
    @FXML
    private Text classroomcode3;
    @FXML
    private Text classroomcode4;
    @FXML
    private Text classroomcode5;


    @FXML
    private Text classroomname1;
    @FXML
    private Text classroomname2;
    @FXML
    private Text classroomname3;
    @FXML
    private Text classroomname4;
    @FXML
    private Text classroomname5;

    @FXML
    private Text classroomteacher1;
    @FXML
    private Text classroomteacher2;
    @FXML
    private Text classroomteacher3;
    @FXML
    private Text classroomteacher4;
    @FXML
    private Text classroomteacher5;

    @FXML
    private AnchorPane classroombutton1;
    @FXML
    private AnchorPane classroombutton2;
    @FXML
    private AnchorPane classroombutton3;
    @FXML
    private AnchorPane classroombutton4;
    @FXML
    private AnchorPane classroombutton5;

    @FXML
    private  Text enrollstatus1;
    @FXML
    private  Text enrollstatus2;
    @FXML
    private  Text enrollstatus3;
    @FXML
    private  Text enrollstatus4;
    @FXML
    private  Text enrollstatus5;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        NavigationHandler.HandleNavigation(home,classroom,attendance,booklet,cgpa,logout);

        LogoutImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent,"LoginScreen.fxml","Log in",null);
            }
        });
        enrollstatus1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(!getEnrolledList().get(0)) {
                    ClassroomData.get(0).setEnrolledStudentList(CSEDUPORTALUtils.getStudentRegistration());
                    getEnrolledList();
                    System.out.println(getEnrolledList().get(0));
//                    classroombutton1.setStyle("-fx-background-color: #05B958");
//                    enrollstatus1.setText("Enrolled");

                }
            }
        });


        classroomcode1.setText(getCourseCode().get(0));
        classroomcode2.setText(getCourseCode().get(1));
        classroomcode3.setText(getCourseCode().get(2));
        classroomcode4.setText(getCourseCode().get(3));
        classroomcode5.setText(getCourseCode().get(4));

        classroomname1.setText(getCourseName().get(0));
        classroomname2.setText(getCourseName().get(1));
        classroomname3.setText(getCourseName().get(2));
        classroomname4.setText(getCourseName().get(3));
        classroomname5.setText(getCourseName().get(4));

        classroomteacher1.setText(getTeacherName().get(0));
        classroomteacher2.setText(getTeacherName().get(1));
        classroomteacher3.setText(getTeacherName().get(2));
        classroomteacher4.setText(getTeacherName().get(3));
        classroomteacher5.setText(getTeacherName().get(4));

        if(!getEnrolledList().get(0)) {
            classroombutton1.setStyle("-fx-background-color: #E02A2A");
            enrollstatus1.setText("Pending");
        }else{
            classroombutton1.setStyle("-fx-background-color: #05B958");
            enrollstatus1.setText("Enrolled");
        }
        if(!getEnrolledList().get(1)) {
            classroombutton2.setStyle("-fx-background-color: #E02A2A");
            enrollstatus2.setText("Pending");
        }else{
            classroombutton2.setStyle("-fx-background-color: #05B958");
            enrollstatus2.setText("Enrolled");
        }
        if(!getEnrolledList().get(2)) {
            classroombutton3.setStyle("-fx-background-color: #E02A2A");
            enrollstatus3.setText("Pending");
        }else{
            classroombutton3.setStyle("-fx-background-color: #05B958");
            enrollstatus3.setText("Enrolled");
        }
        if(!getEnrolledList().get(3)) {
            classroombutton4.setStyle("-fx-background-color: #E02A2A");
            enrollstatus4.setText("Pending");
        }else{
            classroombutton4.setStyle("-fx-background-color: #05B958");
            enrollstatus4.setText("Enrolled");
        }
        if(!getEnrolledList().get(4)) {
            classroombutton5.setStyle("-fx-background-color: #E02A2A");
            enrollstatus5.setText("Pending");
        }else{
            classroombutton5.setStyle("-fx-background-color: #05B958");
            enrollstatus5.setText("Enrolled");
        }


    }
}
