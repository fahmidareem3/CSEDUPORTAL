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
    @FXML
    private Text upcomingclassname2;
    @FXML
    private Text upcomingclassteachername2;
    @FXML
    private Text upcomingclassname3;
    @FXML
    private Text upcomingclassteachername3;
    @FXML
    private Text upcomingclassname4;
    @FXML
    private Text upcomingclassteachername4;
    @FXML
    private Text upcomingclassname5;
    @FXML
    private Text upcomingclassteachername5;




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

    private final ArrayList<String>CourseNameList = new ArrayList<>();
    private final ArrayList<String>TeacherNameList = new ArrayList<>();

    public DashboardScreenController() {
        super();
        setName(super.getStudentName());
        setUpcomingList(super.getCourseName());
        setTeacherName(super.getTeacherName());
    }

    public void setName(String Name){
        System.out.println(Name);
        this.name = Name;
    }
    public String getStudentName() {
        System.out.println(this.name);
        return this.name;
    }
    public void setUpcomingList(ArrayList<String> result){
        for(int i  = 0 ; i < 5 ; i++){
            CourseNameList.add(result.get(i));
        }
    }
    public ArrayList<String> getUpcomingList(){

        return CourseNameList;
    }
    private void setTeacherName(ArrayList<String> teacherName) {
        for(int i  = 0 ; i < 5 ; i++){
            TeacherNameList.add(teacherName.get(i));
        };
    }
    public ArrayList<String> getTeacherNameList() {
        return TeacherNameList;
    }

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
        studentName.setText(DBDATAGETTER.getStudentName());
        upcomingclassname1.setText(getUpcomingList().get(0));
        upcomingclassteachername1.setText(getTeacherNameList().get(0));
        upcomingclassname2.setText(getUpcomingList().get(1));
        upcomingclassteachername2.setText(getTeacherNameList().get(1));
        upcomingclassname3.setText(getUpcomingList().get(2));
        upcomingclassteachername3.setText(getTeacherNameList().get(2));
        upcomingclassname4.setText(getUpcomingList().get(3));
        upcomingclassteachername4.setText(getTeacherNameList().get(3));
        upcomingclassname5.setText(getUpcomingList().get(4));
        upcomingclassteachername5.setText(getTeacherNameList().get(4));

    }

}
