package Controllers;

import Models.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
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

    @FXML
    private Text status1;

    @FXML
    private Text status2;

    @FXML
    private Text status3;

    @FXML
    private Text status4;

    @FXML
    private Text status5;

    @FXML
    private Text studentName;

    @FXML
    private Text semesterCode;

    @FXML

    private Text ProfileIcon;


    @FXML
    private Text attendancepercentageforcourse1;

    @FXML
    private Text attendancepercentageforcourse2;

    @FXML
    private Text attendancepercentageforcourse3;

    @FXML
    private Text attendancepercentageforcourse4;

    @FXML
    private Text attendancepercentageforcourse5;
    @FXML
    private Button setAttendancebutton;
    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;


    private ArrayList<String> CourseNameList = DBDATAGETTER.getCourseName();
    private  ArrayList<String>CourseCodeList = DBDATAGETTER.getCourseCode();
    private String name = DBDATAGETTER.getStudentName();

    private static String courseCodeSelected;
    public static int countBelowAverage;
    public static String getCourseCodeSelected(){
        return courseCodeSelected;
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        countBelowAverage=0;

        ArrayList getAttendancePercentage = DBDATAGETTER.getPercentageOfAttendence();
        attendancepercentageforcourse1.setText(getAttendancePercentage.get(0) +"%" );
        attendancepercentageforcourse2.setText(getAttendancePercentage.get(1) +"%" );
        attendancepercentageforcourse3.setText(getAttendancePercentage.get(2) +"%" );
        attendancepercentageforcourse4.setText(getAttendancePercentage.get(3) +"%" );
        attendancepercentageforcourse5.setText(getAttendancePercentage.get(4) +"%" );

        for (int j = 0; j < 5; j++) {


            if (DBDATAGETTER.getPercentageOfAttendence().get(j) < 50) {

//                countBelowAverage++;
                Text  txt = new Text ();
                if (j == 0) {
                    txt = status1;

                } else if (j == 1) {
                    txt = status2;

                } else if (j == 2) {
                    txt = status3;

                } else if (j == 3) {
                    txt = status4;

                } else if (j == 4) {
                    txt = status5;

                }

                txt.setText("Below Average");

            }


        }

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

        studentName.setText(DBDATAGETTER.getStudentName());

        semesterCode.setText(new GenerateSemesterCode().GetSemesterCode());

        ProfileIcon.setText(String.valueOf(DBDATAGETTER.getStudentName().charAt(0)).toUpperCase(Locale.ROOT));





        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                courseCodeSelected = CourseCodeList.get(0);
                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent, "AttendanceGraph.fxml", "Graph", null);

            }
        });

        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                courseCodeSelected = CourseCodeList.get(1);
                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent, "AttendanceGraph.fxml", "Graph", null);

            }
        });

        button3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                courseCodeSelected = CourseCodeList.get(2);
                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent, "AttendanceGraph.fxml", "Graph", null);

            }
        });

        button4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                courseCodeSelected = CourseCodeList.get(3);
                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent, "AttendanceGraph.fxml", "Graph", null);

            }
        });

        button5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                courseCodeSelected = CourseCodeList.get(4);
                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent, "AttendanceGraph.fxml", "Graph", null);

            }
        });
        setAttendancebutton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent, "SetAttendanceScreen.fxml", "Set Your Attendance", null);


            }
        });

    }
}
