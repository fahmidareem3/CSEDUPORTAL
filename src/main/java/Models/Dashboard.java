package Models;

import Classhirerchy.CSEDU;
import Classhirerchy.Classroom;

public class Dashboard {
    protected static String CourseName;
    protected static String StudentName;
    protected static String TeacherName;
    protected static Classroom ClassroomData = new Classroom();

    public Dashboard() {
        ClassroomData = DATAHUB.DataProvider().getYearList().get(0).getSemesterList().get(0).getClassroomList().get(1);
    }
    public String getName(){
        StudentName = ClassroomData.getStudentList().get(0).getStudentName();
        return StudentName;

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
