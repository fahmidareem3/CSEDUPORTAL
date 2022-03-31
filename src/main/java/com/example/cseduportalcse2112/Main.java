package com.example.cseduportalcse2112;

public class Main {
    private static  boolean isStudentIn ;
    private static  int YearIndex ;
    private static  int SemesterIndex ;

    public static void main(String[] args) {

         CSEDU  CSEDUDEPT = new CSEDU();
         CSEDUDEPT.setYearList(1);
         CSEDUDEPT.YearList.get(0).setSemesterList(1);
    }
}
