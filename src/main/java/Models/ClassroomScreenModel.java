package Models;

import java.util.ArrayList;
import java.util.Objects;

public class ClassroomScreenModel {
    protected static ArrayList<String> CourseName = new ArrayList<>();
    protected static ArrayList<String> CourseCode = new ArrayList<>();
    protected static ArrayList<String> TeacherName = new ArrayList<>();
    protected static ArrayList<Classroom> ClassroomData = new ArrayList<>();

    public ClassroomScreenModel() {
        for(int i = 0 ; i < 5 ; i++){
            ClassroomData.add(DATAHUB.DataProvider().getYearList().get(0).getSemesterList().get(0).getClassroomList().get(i));
        }
    }
    public void addStudent(String Name,int i){
        ClassroomData.get(i).setStudentList(Name,CSEDUPORTALUtils.getStudentEmail(),Integer.parseInt(CSEDUPORTALUtils.getStudentYear()),Integer.parseInt(CSEDUPORTALUtils.getStudentSemester()),Integer.parseInt(CSEDUPORTALUtils.getStudentRoll()),Integer.parseInt(CSEDUPORTALUtils.getStudentRegistration()));
    }
    public ArrayList<String> getCourseName(){
        for(int i = 0 ; i < 5 ; i++){
            CourseName.add(ClassroomData.get(i).getClassroomName());
        }
        return CourseName;
    }

    public ArrayList<String> getTeacherName(){
        for(int i = 0 ; i < 5 ; i++){
            TeacherName.add(ClassroomData.get(i).getClassroomTeacherName());
        }
        return TeacherName;
    }
    public ArrayList<String> getCourseCode(){
        for(int i = 0 ; i < 5 ; i++){
            CourseCode.add(ClassroomData.get(i).getCourseCode());
        }
        return CourseCode;
    }
}
