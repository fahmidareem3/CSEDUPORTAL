package Models;

import java.util.ArrayList;

public class Semester extends Year implements SemesterInterface {
    private int Name;
    ArrayList<Classroom>ClassroomList = new ArrayList<>();

    public Semester() {

    }

    public Semester(int name) {
        this.Name = name;
    }

    @Override
    public void setSemester(int n) {
        this.Name = n;
    }

    @Override
    public int getSemester() {
        return this.Name;
    }

    @Override
    public void setClassroomList(String Name, String courseCode, String teachername, double Credit) {
        ClassroomList.add(new Classroom(Name, courseCode, teachername, Credit));
    }

    @Override
    public ArrayList<Classroom> getClassroomList() {
        return ClassroomList;
    }

}
