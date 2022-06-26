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
import java.util.Locale;
import java.util.ResourceBundle;

public class DashboardScreenController extends Dashboard implements Initializable  {


    @FXML
    private ImageView cgpaCalculatorIcon;

    @FXML
    private Text ProfileIcon;

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

    @FXML
    private Text upcomingclasstime1;
    @FXML
    private Text upcomingclasstime2;
    @FXML
    private Text upcomingclasstime3;
    @FXML
    private Text upcomingclasstime4;
    @FXML
    private Text upcomingclasstime5;


    @FXML
    private Text upcomingclassdate1;
    @FXML
    private Text upcomingclassdate2;
    @FXML
    private Text upcomingclassdate3;
    @FXML
    private Text upcomingclassdate4;
    @FXML
    private Text upcomingclassdate5;




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
        this.name = Name;
    }
    public String getStudentName() {
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
        ProfileIcon.setText(String.valueOf(DBDATAGETTER.getStudentName().charAt(0)).toUpperCase(Locale.ROOT));
        upcomingclassname1.setText(getUpcomingList().get(0));
        upcomingclassteachername1.setText(getTeacherNameList().get(0));
        upcomingclasstime1.setText(DBDATAGETTER.getClassRoutines().get(0).getTime());
        upcomingclassdate1.setText(DBDATAGETTER.getClassRoutines().get(0).getDate());

        upcomingclassname2.setText(getUpcomingList().get(1));
        upcomingclassteachername2.setText(getTeacherNameList().get(1));
        upcomingclasstime2.setText(DBDATAGETTER.getClassRoutines().get(1).getTime());
        upcomingclassdate2.setText(DBDATAGETTER.getClassRoutines().get(1).getDate());

        upcomingclassname3.setText(getUpcomingList().get(2));
        upcomingclassteachername3.setText(getTeacherNameList().get(2));
        upcomingclasstime3.setText(DBDATAGETTER.getClassRoutines().get(2).getTime());
        upcomingclassdate3.setText(DBDATAGETTER.getClassRoutines().get(2).getDate());

        upcomingclassname4.setText(getUpcomingList().get(3));
        upcomingclassteachername4.setText(getTeacherNameList().get(3));
        upcomingclasstime4.setText(DBDATAGETTER.getClassRoutines().get(3).getTime());
        upcomingclassdate4.setText(DBDATAGETTER.getClassRoutines().get(3).getDate());

        upcomingclassname5.setText(getUpcomingList().get(4));
        upcomingclassteachername5.setText(getTeacherNameList().get(4));
        upcomingclasstime5.setText(DBDATAGETTER.getClassRoutines().get(4).getTime());
        upcomingclassdate5.setText(DBDATAGETTER.getClassRoutines().get(4).getDate());

    }

}
