package com.example.cseduportalcse2112;

import java.util.ArrayList;

public interface SemesterInterface {
    void setSemester(int n);
    int getSemester();
    void setClassroomList(String Name, String courseCode, String teacherName,  double Credit);
    ArrayList<Classroom> getClassroomList();
}
