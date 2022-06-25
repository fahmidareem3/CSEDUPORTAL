package Models;

import java.util.ArrayList;

public class AttendanceModel {
    protected static ArrayList<String> CourseName = new ArrayList<>();
    protected static String StudentName ;
    protected static ArrayList<Classroom> ClassroomData = new ArrayList<>();

    public AttendanceModel() {
        for(int i = 0 ; i < 5 ; i++){
            ClassroomData.add(DATAHUB.DataProvider().getYearList().get(0).getSemesterList().get(0).getClassroomList().get(i));
        }
    }

    public ArrayList<String> getCourseName(){
        for(int i = 0 ; i < 5 ; i++){
            CourseName.add(ClassroomData.get(i).getClassroomName());
        }
        return CourseName;
    }
}
