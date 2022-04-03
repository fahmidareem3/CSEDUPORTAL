package com.example.cseduportalcse2112;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardScreenController extends Dashboard implements Initializable  {


    @FXML
    private ImageView cgpaCalculatorIcon;

    @FXML
    private AnchorPane CgpaCalculatorPane;

    @FXML
    private Text studentName;
    @FXML
    private Text upcomingclassname1;
    @FXML
    private Text upcomingclassteachername1;

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

    private String name;
    private ArrayList<String>CourseNameList = new ArrayList<>();
    private ArrayList<String>TeacherNameList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        NavigationHandler.HandleNavigation(home,classroom,attendance,booklet,cgpa,logout);

        LogoutImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent,"LoginScreen.fxml","Log in",null);
            }
        });
        cgpaCalculatorIcon.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent,"CGPACalculatorScreen.fxml","CGPA Calculator",null);
            }
        });
        studentName.setText(getStudentName());
        upcomingclassname1.setText(getUpcomingList());
        upcomingclassteachername1.setText(getTeacherName());

    }
    public DashboardScreenController() {
        super();
        setName(super.getName());
        setUpcomingList(super.getCourseName());
        setTeacherName(super.getTeacherName());
    }

    public void setName(String Name){
        this.name = Name;
    }
    public String getStudentName() {
        return this.name;
    }
    public void setUpcomingList(String result){

        CourseNameList.add(result);
    }
    public String getUpcomingList(){

        return CourseNameList.get(0);
    }
    private void setTeacherName(String teacherName) {
        TeacherNameList.add(teacherName);
    }
    public String getTeacherNameList() {
        return TeacherNameList.get(0);
    }
}
