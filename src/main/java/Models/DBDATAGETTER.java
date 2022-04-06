package Models;

import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;

public class DBDATAGETTER {

    protected static ArrayList<String>TeacherName = new ArrayList<>();
    protected static  ArrayList<String>CourseName = new ArrayList<>();
    protected static ArrayList<String>CourseCode = new ArrayList<>();
    protected static ArrayList<String>CourseCredit = new ArrayList<>();

    public DBDATAGETTER() {
        getUserData("1","2");
    }


    public static void courseGenerate(String Year, String Semester){
        getUserData(Year,Semester);
    }
    public static ArrayList<String> getCourseName(){
        getUserData("1","2");
        return CourseName;
    }
    public static ArrayList<String> getTeacherName(){
        getUserData("1","2");
        return TeacherName;
    }
    public static ArrayList<String> getCourseCode(){
        getUserData("1","2");
        return CourseCode;
    }
    public static ArrayList<String> getCourseCredit(){
        getUserData("1","2");
        return CourseCredit;
    }
    public static void getUserData(String  year, String semester){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cseduportal","root","user");
            preparedStatement = connection.prepareStatement("SELECT Year,Semester,CourseName,CourseTeacher,CourseCode,CourseCredit FROM course WHERE Year = ? ");
            preparedStatement.setString(1,year);
            resultSet = preparedStatement.executeQuery();

            if(!resultSet.isBeforeFirst()){
                System.out.println("User Not Found");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User Not Found");
                alert.show();
            }else{
                while(resultSet.next()) {
                    String retrivedYear = resultSet.getString("Year");
                    String retrivedSemester = resultSet.getString("Semester");
                    String retrivedCourseName = resultSet.getString("CourseName");
                    String retrivedTeacherName = resultSet.getString("CourseTeacher");
                    String retrivedCourseCode = resultSet.getString("CourseCode");
                    String retrivedCourseCredit = resultSet.getString("CourseCredit");

                    if(retrivedYear.equals(year) && retrivedSemester.equals(semester)){
                        CourseName.add(retrivedCourseName);
                        TeacherName.add(retrivedTeacherName);
                        CourseCode.add(retrivedCourseCode);
                        CourseCredit.add(retrivedCourseCredit);
                    }
                    else{
//                        System.out.println("No Data Found");
//                        Alert alert = new Alert(Alert.AlertType.ERROR);
//                        alert.setContentText("Can't Find Semester!");
//                        alert.show();
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
