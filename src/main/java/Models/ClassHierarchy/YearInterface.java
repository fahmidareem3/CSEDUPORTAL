package Models.ClassHierarchy;

import java.util.ArrayList;

public interface YearInterface {
    void setYear(int n);
    int getYear();
    void setSemesterList(int n);
    ArrayList<Semester> getSemesterList();
}
