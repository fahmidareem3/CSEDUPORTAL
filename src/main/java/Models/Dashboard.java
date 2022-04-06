package Models;

import Classhirerchy.CSEDU;
import Classhirerchy.Classroom;

public class Dashboard {
    protected static CSEDU CSEDUDEPT;
    protected static String CourseName;
    protected static String TeacherName;
    protected static Classroom ClassroomData = new Classroom();

    public Dashboard() {
        ClassroomData = DATAHUB.DataProvider().getYearList().get(0).getSemesterList().get(0).getClassroomList().get(2);
    }
    public String getName(){
        CSEDUDEPT = new CSEDU();
        CSEDUDEPT.setYearList(1);
        CSEDUDEPT.getYearList().get(0).setSemesterList(1);
        CSEDUDEPT.getYearList().get(0).getSemesterList().get(0).setClassroomList("OOP","CSE-2102","MIB",1.5);
        CSEDUDEPT.getYearList().get(0).getSemesterList().get(0).getClassroomList().get(0).setStudentList("Fahmida Ara","Demo","Demo",2,1,31,201971);
        return CSEDUDEPT.getYearList().get(0).getSemesterList().get(0).getClassroomList().get(0).getStudentList().get(0).getStudentName();

    }
    public String getCourseName(){
        CourseName = ClassroomData.getClassroomName();
        return CourseName;
    }
    public String getTeacherName(){
        TeacherName = ClassroomData.getClassroomTeacherName();
        return TeacherName;
    }
}
