package Models;

import Classhirerchy.CSEDU;

public class DATAHUB {

    public static CSEDU DataProvider(){
        CSEDU CSEDUDEPT = new CSEDU();
        CSEDUDEPT.setYearList(Integer.parseInt(DBDATAGETTER.getYear()));
        CSEDUDEPT.getYearList().get(0).setSemesterList(Integer.parseInt(DBDATAGETTER.getSemester()));

        for(int i = 0 ; i < 5 ;i++){
            CSEDUDEPT.getYearList().get(0).getSemesterList().get(0).setClassroomList(
                    DBDATAGETTER.getCourseName().get(i),DBDATAGETTER.getCourseCode().get(i),DBDATAGETTER.getTeacherName().get(i),
                    Double.parseDouble(DBDATAGETTER.getCourseCredit().get(i))
            );

        }
        CSEDUDEPT.getYearList().get(0).getSemesterList().get(0).getClassroomList().get(1).setStudentList(DBDATAGETTER.getStudentName(),null,null,1,1,0,0);

        return CSEDUDEPT;
    }
}
