package Models;

import Models.ClassHierarchy.Classroom;

import java.util.ArrayList;
import java.util.Objects;

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
    public int getTotalClassForToday() {
        int i = 0;

        for (int k = 0; k < 4; k++) {
            i=i+1;
            for (int l = k+1; l < 5; l++) {
                if (DBDATAGETTER.getClassRoutines().get(k).getDate().equals(DBDATAGETTER.getClassRoutines().get(l).getDate())) {
                    i=i+1;
                }
            }
            break;
        }
        return i;
    }
}
