package Controllers;

import Models.CSEDUPORTALUtils;
import Models.DBDATAGETTER;
import Models.NavigationHandler;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class BookletScreenController  implements Initializable {

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

    //Book Fields

    @FXML
    private Text studentName;

    @FXML
    private Text bookName1;
    @FXML
    private Text bookName2;

    @FXML
    private Text bookName3;
    @FXML
    private Text bookName4;
    @FXML
    private Text bookName5;

    @FXML
    private Text authorName1;
    @FXML
    private Text authorName2;
    @FXML
    private Text authorName3;
    @FXML
    private Text authorName4;
    @FXML
    private Text authorName5;

    @FXML
    private Text courseCode1;
    @FXML
    private Text courseCode2;
    @FXML
    private Text courseCode3;
    @FXML
    private Text courseCode4;
    @FXML
    private Text courseCode5;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        NavigationHandler.HandleNavigation(home,classroom,attendance,booklet,cgpa,logout);

        LogoutImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent,"LoginScreen.fxml","Log in",null);
            }
        });

        studentName.setText(DBDATAGETTER.getStudentName());
        bookName1.setText(DBDATAGETTER.getCourseBooks().get(0).getBookName());
        bookName2.setText(DBDATAGETTER.getCourseBooks().get(1).getBookName());
        bookName3.setText(DBDATAGETTER.getCourseBooks().get(2).getBookName());
        bookName4.setText(DBDATAGETTER.getCourseBooks().get(3).getBookName());
        bookName5.setText(DBDATAGETTER.getCourseBooks().get(4).getBookName());

        authorName1.setText(DBDATAGETTER.getCourseBooks().get(0).getAuthorName());
        authorName2.setText(DBDATAGETTER.getCourseBooks().get(1).getAuthorName());
        authorName3.setText(DBDATAGETTER.getCourseBooks().get(2).getAuthorName());
        authorName4.setText(DBDATAGETTER.getCourseBooks().get(3).getAuthorName());
        authorName5.setText(DBDATAGETTER.getCourseBooks().get(4).getAuthorName());

        courseCode1.setText(DBDATAGETTER.getCourseBooks().get(0).getCourseCode());
        courseCode2.setText(DBDATAGETTER.getCourseBooks().get(1).getCourseCode());
        courseCode3.setText(DBDATAGETTER.getCourseBooks().get(2).getCourseCode());
        courseCode4.setText(DBDATAGETTER.getCourseBooks().get(3).getCourseCode());
        courseCode5.setText(DBDATAGETTER.getCourseBooks().get(4).getCourseCode());
    }
}
