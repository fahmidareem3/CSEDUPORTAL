package Models;

public class GenerateSemesterCode {

    public String GetSemesterCode(){
        if(DBDATAGETTER.getYear().equals("1")){
            if(DBDATAGETTER.getSemester().equals("1")){
                return ("Year I Semester I");
            }else{
                return("Year I Semester II");
            }

        }else if(DBDATAGETTER.getYear().equals("2")){
            if(DBDATAGETTER.getSemester().equals("1")){
                return("Year II Semester I");
            }else{
                return("Year II Semester II");
            }
        }else if(DBDATAGETTER.getYear().equals("3")){
            if(DBDATAGETTER.getSemester().equals("1")){
                return("Year III Semester I");
            }else{
                return ("Year III Semester II");
            }
        }else{
            if(DBDATAGETTER.getSemester().equals("1")){
                return("Year IV Semester I");
            }else{
                return("Year IV Semester II");
            }
        }
    }
}
