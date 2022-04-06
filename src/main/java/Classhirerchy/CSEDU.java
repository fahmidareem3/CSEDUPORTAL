package Classhirerchy;

import java.util.ArrayList;

public class CSEDU implements CSEDUINTERFACE {
    protected  ArrayList<Year> YearList = new ArrayList<>();
    @Override
    public void setYearList(int n) {
        YearList.add(new Year(n));
    }

    @Override
    public ArrayList<Year> getYearList() {
        return YearList;
    }
}
