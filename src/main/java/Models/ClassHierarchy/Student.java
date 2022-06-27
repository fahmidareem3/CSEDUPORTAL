package Models.ClassHierarchy;

public class Student extends Classroom implements StudentInterface {
    private String Name;
    private int Year;
    private int Semester ;
    private String Email;


    public Student(String Name, String Email , int Year, int Semester, int RollNumber, int RegistrationNumber ) {
        this.Name = Name;
        this.Email = Email;
        this.Year = Year;
        this.Semester = Semester;
        this.RollNumber = RollNumber;
        this.RegistrationNumber = RegistrationNumber;

    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public int getYear() {
        return Year;
    }

    @Override
    public void setYear(int year) {
        Year = year;
    }

    @Override
    public int getSemester() {
        return Semester;
    }

    @Override
    public void setSemester(int semester) {
        Semester = semester;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    public int getRollNumber() {
        return RollNumber;
    }

    public void setRollNumber(int rollNumber) {
        RollNumber = rollNumber;
    }

    public int getRegistrationNumber() {
        return RegistrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        RegistrationNumber = registrationNumber;
    }

    private int RollNumber;
    private int RegistrationNumber;

    public Student() {

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
