package Models;

import java.util.ArrayList;

public class ClassroomScreenModel {
    protected static ArrayList<String> CourseName = new ArrayList<>();
    protected static ArrayList<String> CourseCode = new ArrayList<>();
    protected static String StudentName ;
    protected static ArrayList<String> TeacherName = new ArrayList<>();
    protected static ArrayList<Classroom> ClassroomData = new ArrayList<>();
    protected static ArrayList<Boolean> EnrolledList = new ArrayList<>();

    public ClassroomScreenModel() {
        for(int i = 0 ; i < 5 ; i++){
            ClassroomData.add(DATAHUB.DataProvider().getYearList().get(0).getSemesterList().get(0).getClassroomList().get(i));
        }
    }

    public ArrayList<Boolean> getEnrolledList(){
        for(int i = 0 ; i < 5 ; i++){
            boolean flag = false;
            for(int j = 0 ; j < ClassroomData.get(i).getEnrolledStudentList().size();j++){
                if(ClassroomData.get(i).getEnrolledStudentList().get(j) == CSEDUPORTALUtils.getStudentRegistration()){
                    EnrolledList.add(true);
                    flag = true;
                    break;
                }
            }
            if(!flag) EnrolledList.add(false);
        }
        return EnrolledList;
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
