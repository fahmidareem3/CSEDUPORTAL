package Models;

import java.util.ArrayList;

public interface ClassroomInterface {
    void setClassroom(String name);
    String getClassroomName();
    double getCourseCredit();
    String getClassroomTeacherName();
    String getCourseCode();
    void setBook(String BookName, String AuthorName);
    ArrayList<Book> getBook();
    void setStudentList(String Name, String Email, int Year, int Semester, int RollNumber, int RegistrationNumber);
    ArrayList<Student>getStudentList();

    void setClassScheduleList(String ClassScheduleDay,String classScheduleTime);
    ArrayList<classSchedule>getClassSchedueList();

    void setEnrolledStudentList(String Reg);
    ArrayList<String>getEnrolledStudentList();
    Boolean isStudentEnrolled(String Reg);

}
