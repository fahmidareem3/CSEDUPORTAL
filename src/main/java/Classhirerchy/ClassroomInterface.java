package Classhirerchy;

import java.util.ArrayList;

public interface ClassroomInterface {
    void setClassroom(String name);
    String getClassroomName();
    double getCourseCredit();
    String getClassroomTeacherName();
    String getCourseCode();
    void setBook(String BookName, String AuthorName);
    ArrayList<Book> getBook();
    void setStudentList(String Name, String Email , String Password, int Year, int Semester, int RollNumber, int RegistrationNumber);
    ArrayList<Student>getStudentList();

}
