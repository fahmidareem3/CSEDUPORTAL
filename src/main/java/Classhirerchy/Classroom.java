package Classhirerchy;

import java.util.ArrayList;

public class Classroom extends Semester implements ClassroomInterface{
    private String Name;
    private String TeacherName;
    private String CourseCode;
    private double Credit;
    ArrayList<Book>BookList = new ArrayList<>();
    ArrayList<Student>StudentList = new ArrayList<>();
    ArrayList<classSchedule>ClassScheduleList = new ArrayList<>();

    public Classroom() {
    }
    public Classroom(String name, String courseCode, String teacherName , double credit) {
        Name = name;
        Credit = credit;
        TeacherName = teacherName;
        CourseCode = courseCode;
    }
    @Override
    public void setClassroom(String name) {
        this.Name = name;
    }

    @Override
    public String getClassroomName() {
        return this.Name;
    }

    @Override
    public double getCourseCredit() {
        return this.Credit;
    }

    @Override
    public String getClassroomTeacherName() {
        return this.TeacherName;
    }

    @Override
    public String getCourseCode() {
        return this.CourseCode;
    }

    @Override
    public void setBook(String BookName, String AuthorName) {
            BookList.add(new Book(BookName, AuthorName));
    }

    @Override
    public ArrayList<Book> getBook() {
        return BookList;
    }

    @Override
    public void setStudentList(String Name, String Email , String Password, int Year, int Semester, int RollNumber, int RegistrationNumber ) {
        StudentList.add(new Student(Name, Email , Password, Year, Semester, RollNumber, RegistrationNumber ));
    }

    @Override
    public ArrayList<Student> getStudentList() {
        return StudentList;
    }

    @Override
    public void setClassScheduleList(String classScheduleDay,String classScheduleTime) {
        ClassScheduleList.add(new classSchedule(classScheduleTime,classScheduleDay));
    }

    @Override
    public ArrayList<classSchedule> getClassSchedueList() {
        return ClassScheduleList;
    }

}
