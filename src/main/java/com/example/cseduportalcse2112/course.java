package com.example.cseduportalcse2112;

import java.util.ArrayList;

public class course {
    private ArrayList<courseRoom> CourseList;
    void setCourseList(String year,String semester){
        CourseList.add(new courseRoom(year,semester));
    }

    public ArrayList<courseRoom> getCourseList() {
        return CourseList;
    }

    public void setCourseList(ArrayList<courseRoom> courseList) {
        CourseList = courseList;
    }
}
