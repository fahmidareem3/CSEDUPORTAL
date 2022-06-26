package Models;

public class ClassRoutine {


    private String Date;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    private String Time;
    public ClassRoutine(String date, String time) {
        Date = date;
        Time = time;
    }
}
