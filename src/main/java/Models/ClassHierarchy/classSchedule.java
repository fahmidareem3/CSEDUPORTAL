package Models.ClassHierarchy;

public class classSchedule implements classScheduleInterface{
    private String ClassDay;
    private String ClassTime;

    public classSchedule(String classDay, String classTime) {
        ClassDay = classDay;
        ClassTime = classTime;
    }

    public classSchedule(String classSchedule) {
        this.ClassDay = classSchedule;
    }

    @Override
    public void setClassSchedule(String classSchedule) {
        this.ClassDay = classSchedule;
    }

    @Override
    public String getClassSchedule() {
        return ClassDay;
    }
    @Override
    public String getClassTime() {
        return ClassTime;
    }

    @Override
    public void setClassTime(String classTime) {
        this.ClassTime = classTime;
    }
}
