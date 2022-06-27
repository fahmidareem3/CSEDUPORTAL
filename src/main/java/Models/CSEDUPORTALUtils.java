package Models;

import Controllers.DashboardScreenController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.sql.*;

public class CSEDUPORTALUtils  {
    private static String StudentRegistrationNumber;
    private static String StudentEmail;
    private static String StudentRoll;
    private static String StudentYear;
    private static String StudentSemester;

    public static String getStudentYear() {
        return StudentYear;
    }

    public static void setStudentYear(String studentYear) {
        StudentYear = studentYear;
    }

    public static String getStudentSemester() {
        return StudentSemester;
    }

    public static void setStudentSemester(String studentSemester) {
        StudentSemester = studentSemester;
    }

    public static String getStudentRoll() {
        return StudentRoll;
    }

    public static void setStudentRoll(String studentRoll) {
        StudentRoll = studentRoll;
    }

    public static String getStudentEmail() {
        return StudentEmail;
    }

    public static void setStudentEmail(String studentEmail) {
        StudentEmail = studentEmail;
    }

    public static void setStudentRegistration(String Reg){
        StudentRegistrationNumber = Reg;
    }
    public static String getStudentRegistration(){
        return StudentRegistrationNumber ;
    }


    public static void changeScence(ActionEvent event, String fxmlFile, String Title, String StudentName){
        Parent root = null;
        if(StudentName != null){
            try{
                FXMLLoader loader = new FXMLLoader(CSEDUPORTALUtils.class.getResource(fxmlFile));
                root = loader.load();
                DashboardScreenController DashboardScreenController = loader.getController();
                DashboardScreenController.getClass();
            }

            catch (IOException e){
                System.out.println(e.getStackTrace());
            }
        }else{
            try{
                root = FXMLLoader.load(CSEDUPORTALUtils.class.getResource(fxmlFile));
            }catch (IOException e){
                System.out.println("Can't Load File");
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(Title);
        stage.setScene(new Scene(root,1100,680));
        stage.show();
    }
    public static void changeScenceWindow(WindowEvent event, String fxmlFile, String Title, String StudentName){
        Parent root = null;
        if(StudentName != null){
            try{
                FXMLLoader loader = new FXMLLoader(CSEDUPORTALUtils.class.getResource(fxmlFile));
                root = loader.load();
                DashboardScreenController DashboardScreenController = loader.getController();
                DashboardScreenController.getClass();
            }

            catch (IOException e){
                System.out.println(e.getStackTrace());
            }
        }else{
            try{
                root = FXMLLoader.load(CSEDUPORTALUtils.class.getResource(fxmlFile));
            }catch (IOException e){
                System.out.println("Can't Load File");
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(Title);
        stage.setScene(new Scene(root,1100,680));
        stage.show();
    }
    public static void changeScenceforMouseEvent(MouseEvent event, String fxmlFile, String Title, String StudentName){
        Parent root = null;
        if(StudentName != null){
            try{
                FXMLLoader loader = new FXMLLoader(CSEDUPORTALUtils.class.getResource(fxmlFile));
                root = loader.load();
                DashboardScreenController DashboardScreenController = loader.getController();
                DashboardScreenController.getClass();
            }

            catch (IOException e){
                System.out.println(e.getStackTrace());
            }
        }else{
            try{
                root = FXMLLoader.load(CSEDUPORTALUtils.class.getResource(fxmlFile));
            }catch (IOException e){
                System.out.println("Can't Load File");
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(Title);
        stage.setScene(new Scene(root,1100,680));
        stage.show();
    }

    public static void signUpUser(ActionEvent event,String Name,String Email,String Password,String semester,String year,String roll,String registration){
        Connection connection = null;
        PreparedStatement userInsert = null;
        PreparedStatement checkUserExist = null;
        ResultSet resultSet = null;
        PreparedStatement checkLectureAttendance = null;
        PreparedStatement attendenceinsert = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cseduportal","root","user");
            checkUserExist = connection.prepareStatement("SELECT * FROM student WHERE Registration = ?");
            checkUserExist.setString(1, registration);

            resultSet = checkUserExist.executeQuery();

            if(Name.isEmpty() || Email.isEmpty() || Password.isEmpty()|| semester.isEmpty() || year.isEmpty() || roll.isEmpty() || registration.isEmpty() ){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please fill in all the fields");
                alert.show();
            }else{
                if(resultSet.isBeforeFirst()){
                    System.out.println("User Already Exist");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("User Already Exist");
                    alert.show();
                }
                else{
                    userInsert = connection.prepareStatement("INSERT INTO student (Name,Email,Password,Year,Semester,Roll,Registration) VALUES (?,?,?,?,?,?,? )");
                    userInsert.setString(1,Name);
                    userInsert.setString(2,Email);
                    userInsert.setString(3,Password);
                    userInsert.setString(4, String.valueOf(year));
                    userInsert.setString(5, String.valueOf(semester));
                    userInsert.setString(6, String.valueOf(roll));
                    userInsert.setString(7,registration);
                    userInsert.executeUpdate();

                    checkLectureAttendance = connection.prepareStatement("SELECT lectures.id FROM cseduportal.lectures Inner Join course on lectures.CourseCode = course.CourseCode   where course.Year = ? and course.Semester = ?");
                    checkLectureAttendance.setString(1 , year);
                    checkLectureAttendance.setString(2 , semester);
                    resultSet = checkLectureAttendance.executeQuery();

                    while (resultSet.next()) {
                        String id = resultSet.getString("id");
                        attendenceinsert = connection.prepareStatement("INSERT INTO `attendance`(  `Registration_Id`, `Lecture_Id`, `IsAttended`) VALUES (?,?,0)");
                        attendenceinsert.setString(1, registration);
                        attendenceinsert.setString(2,id);
                        attendenceinsert.executeUpdate();
                    }


                    DBDATAGETTER.courseGenerate(String.valueOf(year),String.valueOf(semester),Name, registration);
                    setStudentRegistration(registration);
                    changeScence(event,"DashboardScreen.fxml","Dashboard",null);
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(resultSet != null){
                try{
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(userInsert != null){
                try{
                    userInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if(checkUserExist != null){
                try{
                    checkUserExist.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }

    }
    public static void loginUser(ActionEvent event, String Registration, String Password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cseduportal","root","user");
            preparedStatement = connection.prepareStatement("SELECT Registration,Password,Email,Roll,Year,Semester,Name FROM student WHERE Registration = ? ");
            preparedStatement.setString(1,Registration);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.isBeforeFirst() || Registration ==null){
                System.out.println("User Not Found");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User Not Found");
                alert.show();
            }else{
                while(resultSet.next()) {
                    String retrivedPassword = resultSet.getString("Password");
                    String retrivedRegistration = resultSet.getString("Registration");
                    String retrivedYear = resultSet.getString("Year");
                    String retrivedSemester = resultSet.getString("Semester");
                    String retrivedName = resultSet.getString("Name");
                    String retrivedRoll = resultSet.getString("Roll");
                    String retrivedEmail = resultSet.getString("Email");

                    if(retrivedPassword.equals(Password)){
                        DBDATAGETTER.courseGenerate(retrivedYear,retrivedSemester,retrivedName, retrivedRegistration);
                        setStudentRegistration(retrivedRegistration);
                        setStudentEmail(retrivedEmail);
                        setStudentRoll(retrivedRoll);
                        setStudentYear(retrivedYear);
                        setStudentSemester(retrivedSemester);
                        changeScence(event,"DashboardScreen.fxml","Dashboard",null);

                    }
                    else{
                        System.out.println("Password did not match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("The provided credentials are incorrect!");
                        alert.show();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(resultSet != null){
                try{
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null){
                try{
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if(connection != null){
                try{
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}