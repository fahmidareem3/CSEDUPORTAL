package Models;

import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;

public class DBDATAGETTER {

    protected static ArrayList<String>TeacherName = new ArrayList<>();
    protected static  ArrayList<String>CourseName = new ArrayList<>();
    protected static ArrayList<String>CourseCode = new ArrayList<>();
    protected static ArrayList<String>CourseCredit = new ArrayList<>();
    protected static ArrayList<CourseBook>CourseBooks = new ArrayList<>();
    protected static ArrayList<ClassRoutine>ClassRoutines = new ArrayList<>();

    protected static ArrayList<String>LectureName = new ArrayList<>();
    protected static ArrayList<String>LectureDate = new ArrayList<>();
    protected static ArrayList<String>IsAttended = new ArrayList<>();
    protected static ArrayList<String>LectureID = new ArrayList<>();
    protected static ArrayList<Integer>PercentageOfAttendence = new ArrayList<>();


    private static String Year;
    private static String Semester;

    private static String StudentName;
    private static String StudentRegistrationNumber;



    public DBDATAGETTER() {
        getUserData(Year,Semester);
    }
    public static String getYear() {
        return Year;
    }

    public static String getSemester() {
        return Semester;
    }
    public static String getStudentName() {

        return StudentName;
    }

    public static String getStudentRegistrationNumber() {

        return StudentRegistrationNumber;
    }

    public static void courseGenerate(String year, String semester,String studentName,  String reg){
        Year = year;
        Semester = semester;
        StudentName = studentName;
        StudentRegistrationNumber = reg;
        getUserData(Year,Semester);
        getBookListData(Year,Semester);
    }
    public static ArrayList<String> getCourseName(){
        getUserData(Year,Semester);
        return CourseName;
    }
    public static ArrayList<String> getTeacherName(){
        getUserData(Year,Semester);
        return TeacherName;
    }
    public static ArrayList<String> getCourseCode(){
        getUserData(Year,Semester);
        return CourseCode;
    }
    public static ArrayList<String> getCourseCredit(){
        getUserData(Year,Semester);
        return CourseCredit;
    }
    public static ArrayList<CourseBook> getCourseBooks(){
        getBookListData(Year,Semester);
        return CourseBooks;
    }
    public static ArrayList<ClassRoutine> getClassRoutines(){
        getClassRoutine(Year,Semester);
        return ClassRoutines;
    }

    public static ArrayList<Integer> getPercentageOfAttendence(){
        ArrayList<Integer>PercentageOfAttendenceList = new ArrayList<>();
        ArrayList<String>allCourseCodes = new ArrayList<>(getCourseCode());


        int sum = 0 ;
        for(int i = 0 ;i<5;i++){
            ArrayList<String>AttendencebyCourse  = new ArrayList<>(getLectureIsAttended(allCourseCodes.get(i)));
            ;
            sum = 0;
            for(int j = 0 ;j<10;j++){
                sum =sum +  Integer.parseInt(AttendencebyCourse.get(j));
            }
            PercentageOfAttendenceList.add(sum*10);
        }

        return PercentageOfAttendenceList;
    }
    public static ArrayList<String> getLectureDate(String courseCode){
        getAttendanceData(DBDATAGETTER.getYear(),  DBDATAGETTER.getSemester(), courseCode, DBDATAGETTER.getStudentRegistrationNumber());
        return LectureDate;
    }
    public static ArrayList<String> getLectureTitle(String courseCode){
        getAttendanceData(DBDATAGETTER.getYear(),  DBDATAGETTER.getSemester(), courseCode, DBDATAGETTER.getStudentRegistrationNumber());
        return LectureName;
    }
    public static ArrayList<String> getLectureId(String courseCode){
        getAttendanceData(DBDATAGETTER.getYear(),  DBDATAGETTER.getSemester(), courseCode, DBDATAGETTER.getStudentRegistrationNumber());
        return LectureID;
    }
    //       IsAttended
    public static ArrayList<String> getLectureIsAttended(String courseCode){
        getAttendanceData(DBDATAGETTER.getYear(),  DBDATAGETTER.getSemester(), courseCode, DBDATAGETTER.getStudentRegistrationNumber());
        return IsAttended;
    }

    public static void getAttendanceData(String  year, String semester, String courseCode, String userId){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        LectureID.clear();
        LectureDate.clear();
        IsAttended.clear();
        LectureName.clear();
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cseduportal","root","user");
            preparedStatement = connection.prepareStatement("SELECT * FROM cseduportal.attendance Inner Join lectures on lectures.id = attendance.Lecture_Id Inner Join course on lectures.CourseCode = course.CourseCode where course.Year = ? and course.Semester = ? and course.CourseCode = ? and attendance.Registration_Id = ? ORDER BY lectures.Id ASC");
            preparedStatement.setString(1,year);
            preparedStatement.setString(2,semester);
            preparedStatement.setString(3,courseCode);
            preparedStatement.setString(4,getStudentRegistrationNumber() );
            resultSet = preparedStatement.executeQuery();

            if(!resultSet.isBeforeFirst()){
                System.out.println("User Not Found");
                System.out.println("printed from kala");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User Not Found");
                alert.show();
            }

            while(resultSet.next()) {

                String retrivedYear = resultSet.getString("Year");
                String retrivedSemester = resultSet.getString("Semester");
                String retrivedCourseCode = resultSet.getString("CourseCode");
                String retrivedLectureName = resultSet.getString("LectureName");
                String retrivedLectureDate = resultSet.getString("LectureDate");
                String retrivedIsAttended = resultSet.getString("IsAttended");
                String retrivedLectureID  = resultSet.getString("Lecture_Id");

                if(retrivedYear.equals(year) && retrivedSemester.equals(semester) && retrivedCourseCode.equals(courseCode) ) {
                    LectureName.add(retrivedLectureName);
                    LectureDate.add(retrivedLectureDate);
                    IsAttended.add(retrivedIsAttended);
                    LectureID.add(retrivedLectureID);
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

    public static void getBookListData(String  year, String semester){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cseduportal","root","user");
            preparedStatement = connection.prepareStatement("SELECT Year,Semester,BookName,AuthorName,CourseCode FROM booklist WHERE Year = ?");
            preparedStatement.setString(1,year);

            resultSet = preparedStatement.executeQuery();

            if(!resultSet.isBeforeFirst()){
                System.out.println("Book Not Found");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Book Not Found");
                alert.show();
            }else{
                while(resultSet.next()) {
                    String retrivedYear = resultSet.getString("Year");
                    String retrivedSemester = resultSet.getString("Semester");
                    String retrivedBooks = resultSet.getString("BookName");
                    String retrivedAuthors = resultSet.getString("AuthorName");
                    String retrivedCourseCode = resultSet.getString("CourseCode");



                    if(retrivedYear.equals(year) && retrivedSemester.equals(semester)){
                        CourseBooks.add(new CourseBook(retrivedBooks,retrivedAuthors,retrivedCourseCode));
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

    public static void getClassRoutine(String  year, String semester){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cseduportal","root","user");
            preparedStatement = connection.prepareStatement("SELECT Year,Semester,Date,Time FROM classroutine WHERE Year = ?");
            preparedStatement.setString(1,year);

            resultSet = preparedStatement.executeQuery();

            if(!resultSet.isBeforeFirst()){
                System.out.println("Book Not Found");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Book Not Found");
                alert.show();
            }else{
                while(resultSet.next()) {
                    String retrivedYear = resultSet.getString("Year");
                    String retrivedSemester = resultSet.getString("Semester");
                    String retrivedDate = resultSet.getString("Date");
                    String retrivedTime = resultSet.getString("Time");



                    if(retrivedYear.equals(year) && retrivedSemester.equals(semester)){
                        ClassRoutines.add(new ClassRoutine(retrivedDate,retrivedTime));
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

    public static void setAttendanceData(String  CourseCode, String LectureName,String value){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        LectureID.clear();
        LectureDate.clear();
        IsAttended.clear();
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cseduportal","root","user");
//                preparedStatement = connection.prepareStatement("UPDATE attendance INNER JOIN lectures on attendance.Lecture_Id = lectures.Id SET attendance.IsAttended = ? WHERE lectures.CourseCode = ? AND lectures.LectureName = ?");
//            preparedStatement = connection.prepareStatement("UPDATE attendance INNER JOIN lectures on attendance.Lecture_Id = lectures.Id SET attendance.IsAttended = 1 WHERE lectures.CourseCode = 'CSE-1101' AND lectures.LectureName = 'Lecture 1'");
//                preparedStatement.setString(1,value);
//                preparedStatement.setString(2,CourseCode);
//                preparedStatement.setString(3,LectureName);

            Statement stmt = connection.createStatement();
            int y= stmt.executeUpdate("UPDATE attendance INNER JOIN lectures on attendance.Lecture_Id = lectures.Id SET attendance.IsAttended = '"+value+"' WHERE lectures.CourseCode = '"+CourseCode+"' AND lectures.LectureName = '"+ LectureName+"'" );
            System.out.println(y);
//                if(!resultSet.isBeforeFirst()){
//                    System.out.println("User Not Found");
//                    System.out.println("printed from kala");
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setContentText("User Not Found");
//                    alert.show();
//                }
            //
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
