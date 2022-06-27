package Controllers;

import Models.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class ClassroomScreenController extends ClassroomScreenModel  implements Initializable  {

    @FXML Text studentName;
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

    @FXML
    private  Text ProfileIcon;


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
                    addStudent(DBDATAGETTER.getStudentName(),0);
                    enrollstatus1.setText("Enrolled");
                    classroombutton1.setStyle("-fx-background-color: #05B958");


            }
        });

        if(ClassroomData.get(0).getStudentList().size() < 1 ) {
            enrollstatus1.setText("Pending");
            classroombutton1.setStyle("-fx-background-color: #E02A2A");
        }else{
            enrollstatus1.setText("Enrolled");
            classroombutton1.setStyle("-fx-background-color: #05B958");
        }

        enrollstatus2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addStudent(DBDATAGETTER.getStudentName(),1);
                enrollstatus2.setText("Enrolled");
                classroombutton2.setStyle("-fx-background-color: #05B958");


            }
        });

        if(ClassroomData.get(1).getStudentList().size() < 1 ) {
            enrollstatus2.setText("Pending");
            classroombutton2.setStyle("-fx-background-color: #E02A2A");
        }else{
            enrollstatus2.setText("Enrolled");
            classroombutton2.setStyle("-fx-background-color: #05B958");
        }

        //3
        enrollstatus3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addStudent(DBDATAGETTER.getStudentName(),2);
                enrollstatus3.setText("Enrolled");
                classroombutton3.setStyle("-fx-background-color: #05B958");


            }
        });

        if(ClassroomData.get(2).getStudentList().size() < 1 ) {
            enrollstatus3.setText("Pending");
            classroombutton3.setStyle("-fx-background-color: #E02A2A");
        }else{
            enrollstatus3.setText("Enrolled");
            classroombutton3.setStyle("-fx-background-color: #05B958");
        }

        //4
        enrollstatus4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addStudent(DBDATAGETTER.getStudentName(),3);
                enrollstatus4.setText("Enrolled");
                classroombutton4.setStyle("-fx-background-color: #05B958");


            }
        });

        if(ClassroomData.get(3).getStudentList().size() < 1 ) {
            enrollstatus4.setText("Pending");
            classroombutton4.setStyle("-fx-background-color: #E02A2A");
        }else{
            enrollstatus4.setText("Enrolled");
            classroombutton4.setStyle("-fx-background-color: #05B958");
        }

        //5
        enrollstatus5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addStudent(DBDATAGETTER.getStudentName(),4);
                enrollstatus5.setText("Enrolled");
                classroombutton5.setStyle("-fx-background-color: #05B958");

            }
        });

        if(ClassroomData.get(4).getStudentList().size() < 1 ) {
            enrollstatus5.setText("Pending");
            classroombutton5.setStyle("-fx-background-color: #E02A2A");
        }else{
            enrollstatus5.setText("Enrolled");
            classroombutton5.setStyle("-fx-background-color: #05B958");
        }


        studentName.setText(DBDATAGETTER.getStudentName());
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

        ProfileIcon.setText(String.valueOf(DBDATAGETTER.getStudentName().charAt(0)).toUpperCase(Locale.ROOT));

    }
}
