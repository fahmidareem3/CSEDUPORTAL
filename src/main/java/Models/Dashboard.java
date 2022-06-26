package Models;

import java.util.ArrayList;

public class Dashboard {
    protected static ArrayList<String> CourseName = new ArrayList<>();
    protected static String StudentName ;
    protected static ArrayList<String> TeacherName = new ArrayList<>();
    protected static ArrayList<Classroom> ClassroomData = new ArrayList<>();

    public Dashboard() {
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
    public void setStudentName(){
       StudentName = DBDATAGETTER.getStudentName();

    }
    public String getStudentName(){
       return StudentName;

    }

    public ArrayList<String> getTeacherName(){
        for(int i = 0 ; i < 5 ; i++){
            TeacherName.add(ClassroomData.get(i).getClassroomTeacherName());
        }
        return TeacherName;
    }
}
