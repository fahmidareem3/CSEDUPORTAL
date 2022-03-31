package com.example.cseduportalcse2112;

import java.util.ArrayList;

public class Year extends CSEDU implements YearInterface {
    private int year;
    ArrayList<Semester> SemesterList = new ArrayList<>();

    public Year() {

    }
    public Year(int n) {
        this.year = n;
    }

    @Override
    public void setYear(int n) {
        this.year = n;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public void setSemesterList(int n) {
        SemesterList.add(new Semester(n));
    }

    @Override
    public ArrayList<Semester> getSemesterList() {
        return SemesterList;
    }

}
