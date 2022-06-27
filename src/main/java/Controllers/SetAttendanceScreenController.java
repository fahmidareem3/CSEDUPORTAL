package Controllers;

import Models.DBDATAGETTER;
import Models.NavigationHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;


public class SetAttendanceScreenController implements Initializable {

    @FXML
    private ImageView LogoutImage;

    @FXML
    private Text attendance;

    @FXML
    private Text booklet;

    @FXML
    private Text cgpa;

    @FXML
    private Text classroom;

    @FXML
    private Text home;

    @FXML
    private Text logout;


    @FXML
    private ImageView cgpaCalculatorIcon;


    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private ChoiceBox LecturechoiceBox;

    @FXML
    private Label courseName;

    @FXML
    private Label lectureName;

    @FXML
    private Button setAttended;

    @FXML
    private Button notAttended;

    String courseID ;
    String LectureTitle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        NavigationHandler.HandleNavigation(home,classroom,attendance,booklet,cgpa,logout);

        for (int i=0; i<5; i++)
        {
            choiceBox.getItems().add(DBDATAGETTER.getCourseCode().get(i));
            choiceBox.getStyleClass().add("CourseChoiceBoxContent");
        }
        courseID = DBDATAGETTER.getCourseCode().get(0);
        LectureTitle = DBDATAGETTER.getLectureTitle(courseID).get(0);
        choiceBox.getSelectionModel().selectFirst();

        String x= DBDATAGETTER.getCourseCode().get(0);

        for (int i=0; i<10; i++)
        {
            LecturechoiceBox.getItems().add(DBDATAGETTER.getLectureTitle(x).get(i));

        }

        LecturechoiceBox.getSelectionModel().selectFirst();

        choiceBox.setOnAction((event) -> {
            int selectedIndex = choiceBox.getSelectionModel().getSelectedIndex();
            Object selectedItem = choiceBox.getSelectionModel().getSelectedItem();
            courseID = String.valueOf(choiceBox.getValue());
          });


  LecturechoiceBox.setOnAction((event) -> {
            int selectedIndex = LecturechoiceBox.getSelectionModel().getSelectedIndex();
            Object selectedItem = LecturechoiceBox.getSelectionModel().getSelectedItem();

            System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
            System.out.println("   ChoiceBox.getValue(): " + LecturechoiceBox.getValue());
            LectureTitle = String.valueOf(LecturechoiceBox.getValue());
             });

  setAttended.setOnAction((event) -> {
            System.out.println(courseID);
            System.out.println(LectureTitle);
            DBDATAGETTER.setAttendanceData(courseID , LectureTitle, "1");

        });

        notAttended.setOnAction((event) -> {
            System.out.println(courseID);
            System.out.println(LectureTitle);
            DBDATAGETTER.setAttendanceData(courseID , LectureTitle, "0");

        });


}




}
