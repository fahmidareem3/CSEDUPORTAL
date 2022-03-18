package com.example.cseduportalcse2112;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CSEDUPORTAL.class.getResource("DashboardScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 680);
        stage.setTitle("CSEDU PORTAL");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {

        launch();
    }

    @FXML
    private Text upcomingclassname1;
    @FXML
    private Text upcomingclassname2;
    @FXML
    private Text upcomingclassname3;
    @FXML
    private Text upcomingclassname4;
    @FXML
    private Text upcomingclassname5;

    @FXML
    private Text upcomingclassteachername1;
    @FXML
    private Text upcomingclassteachername2;
    @FXML
    private Text upcomingclassteachername3;
    @FXML
    private Text upcomingclassteachername4;
    @FXML
    private Text upcomingclassteachername5;
    @FXML
    private Text upcominclasstime1;
    @FXML
    private Text upcominclasstime2;
    @FXML
    private Text upcominclasstime3;
    @FXML
    private Text upcominclasstime4;
    @FXML
    private Text upcominclasstime5;
    @FXML
    private Text upcominclassdate1;
    @FXML
    private Text upcominclassdate2;
    @FXML
    private Text upcominclassdate3;
    @FXML
    private Text upcominclassdate4;
    @FXML
    private Text upcominclassdate5;

    public void setupcomingclassname(){
        upcomingclassname1.setText("Data Structure and Algorithm");
        upcomingclassname2.setText("Object Oriented Programming");
        upcomingclassname3.setText("Digital Logic Design");
        upcomingclassname4.setText("Bangladesh Studies");
        upcomingclassname5.setText("Linear Algebra");
    }
    public void setupcomingclassteachername(){
        upcomingclassteachername1.setText("Dr. Md. Rezaul Karim");
        upcomingclassteachername2.setText("Dr Muhammad Ibrahim");
        upcomingclassteachername3.setText("Dr. S.M Mostafa Al Mamun");
        upcomingclassteachername4.setText("Dr. Suraiya Parvin");
        upcomingclassteachername5.setText("Md. Ashraful Islam");

    }
    public void setupcomingclasstime(){
        upcominclasstime1.setText("11:30 AM");
        upcominclasstime2.setText("10:00 AM");
        upcominclasstime3.setText("10:00 AM");
        upcominclasstime4.setText("2:30 PM");
        upcominclasstime5.setText("8:30 AM");

    }
    public void setupcomingclassdate(){
        upcominclassdate1.setText("Monday,March 21");
        upcominclassdate2.setText("Monday,March 21");
        upcominclassdate3.setText("Sunday,March 20");
        upcominclassdate4.setText("Tuesday,March 23");
        upcominclassdate5.setText("Sunday,March 20");
    }

}
