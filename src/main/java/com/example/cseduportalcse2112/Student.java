package com.example.cseduportalcse2112;

public class Student extends Classroom implements StudentInterface {
    private String Name;
    private int Year;
    private int Semester ;
    private String Email;
    private String Password;
    private int RollNumber;
    private int RegistrationNumber;

    public Student() {

    }
    public Student(String Name, String Email , String Password, int Year, int Semester, int RollNumber, int RegistrationNumber ) {
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
        this.Year = Year;
        this.Semester = Semester;
        this.RollNumber = RollNumber;
        this.RegistrationNumber = RegistrationNumber;

    }

    @Override
    public void setStudentName(String Name) {
            this.Name = Name;
    }

    @Override
    public String getStudentName() {
        return this.Name;
    }

    @Override
    public void setCurrentYear(int n) {
        this.Year = n;
    }

    @Override
    public int getCurrentYear() {
        return this.Year;
    }

    @Override
    public void setCurrentSemester(int n) {
            this.Semester = n;
    }

    @Override
    public int getCurrentSemester() {
        return this.Semester;
    }
}
