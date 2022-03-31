package com.example.cseduportalcse2112;

public class courseRoom {
    private String year;
    private String semester;
    public courseRoom(String year,String semester) {
        this.year = year;
        this.semester = semester;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
