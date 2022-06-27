package Controllers;

import Models.CSEDUPORTALUtils;
import Models.DBDATAGETTER;
import Models.NavigationHandler;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AttendanceGraphScreenController implements Initializable {

    @FXML
    public NumberAxis yAxis;
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
    public LineChart attendanceLineChart;

    String courseCode = AttendanceScreenController.getCourseCodeSelected();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        NavigationHandler.HandleNavigation(home,classroom,attendance,booklet,cgpa,logout);

        LogoutImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent,"LoginScreen.fxml","Log in",null);
            }
        });

        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(1);
        yAxis.setTickUnit(1);
        attendanceLineChart.getData().clear();

        XYChart.Series series = new XYChart.Series();

        ArrayList<String> LectureName = DBDATAGETTER.getLectureTitle(courseCode);
        ArrayList<String>IsAttended = DBDATAGETTER.getLectureIsAttended(courseCode);
        ArrayList<String>LectureDate = DBDATAGETTER.getLectureDate(courseCode);
        ArrayList<String>CourseCode = DBDATAGETTER.getCourseCode();

        for(int i = 0 ; i<10 ;i++){
            String lectureDate =  LectureDate.get(i) ;
            series.getData().add(new XYChart.Data(lectureDate,Integer.parseInt(IsAttended.get(i)) ));
        }
        series.setName("Attendance");
        this.attendanceLineChart.getData().add(series);

    }
}
