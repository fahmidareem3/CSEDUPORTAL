package com.example.cseduportalcse2112;

public class DATAHUB {

    public static CSEDU DataProvider(){
        CSEDU CSEDUDEPT = new CSEDU();
        CSEDUDEPT.setYearList(1);
        CSEDUDEPT.getYearList().get(0).setSemesterList(2);
        for(int i = 0 ; i < 5 ;i++){
            CSEDUDEPT.getYearList().get(0).getSemesterList().get(0).setClassroomList(
                    DBDATAGETTER.getCourseName().get(i),DBDATAGETTER.getCourseCode().get(i),DBDATAGETTER.getTeacherName().get(i),
                    Double.parseDouble(DBDATAGETTER.getCourseCredit().get(i))
            );
        }

        return CSEDUDEPT;
    }
}
