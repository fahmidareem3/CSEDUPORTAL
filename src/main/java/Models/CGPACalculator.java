package Models;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class CGPACalculator  {


    private String[] grade = new String[5];
    private double[] gpa = new double[5];
    private double[] credits = new double[5];
    static double total_credit;
    double cgpa;

//    @Override
//    public void start(Stage stage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(Models.CSEDUPORTAL.class.getResource("CGPACalculatorScreen.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1100, 680);
//        stage.setTitle("CGPA Calculator");
//        stage.setScene(scene);
//        stage.show();
//    }
//    public static void main(String[] args) {
//        launch();
//    }


    @FXML
    private Label cgpacalculated;
    @FXML
    private Text cgpacalculated2;

    public void gradeSetter(String grade1, String grade2, String grade3, String grade4, String grade5) {

            grade[0] = grade1;
            grade[1] = grade2;
            grade[2] = grade3;
            grade[3] = grade4;
            grade[4] = grade5;
            for(int i = 0; i < 5; i++){
                if(grade[i].equals("A+")){
                    gpa[i] = 4;
                }
                else if(grade[i].equals("A")){
                    gpa[i] = 3.75;
                }
                else if(grade[i].equals("A-")){
                    gpa[i] = 3.50;
                }
                else if(grade[i].equals("B+")){
                    gpa[i] = 3.25;
                }
                else if(grade[i].equals("B")){
                    gpa[i] = 3.00;
                }
                else if(grade[i].equals("B-")){
                    gpa[i] = 2.75;
                }
                else if(grade[i].equals("C+")){
                    gpa[i] = 2.50;
                }
                else if(grade[i].equals("C")){
                    gpa[i] = 2.00;
                }
                else if(grade[i].equals("F")){
                    gpa[i] = 0.00;
                }
                else{

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Invalid Input");
                    alert.show();

                }

        }

    }

    public void getCredit(){

        ArrayList<String> credit_string = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            credit_string.add(DBDATAGETTER.getCourseCredit().get(i));
        }

        for(int i = 0; i < 5; i++){
            credits[i] = Double.parseDouble(credit_string.get(i));

        }


    }
    public double getTotal_credit(){
        total_credit = 0;
        for (int i = 0; i < 5; i++) {

            total_credit += credits[i];
        }
        return total_credit;
    }
    public void CgpaCalculator() {

        getCredit();
        double totalcredit = getTotal_credit();
        cgpa = (gpa[0] * credits[0] + gpa[1] * credits[1] + gpa[2] * credits[2] + gpa[3] * credits[3] + gpa[4] * credits[4])/totalcredit;

        String Cgpa = String.valueOf(String.format("%.2f",cgpa));
        cgpacalculated.setText(Cgpa);
        cgpacalculated2.setText(Cgpa);

    }
    public void reset(){
        cgpa = 0.0;
        String Cgpa = String.valueOf(String.format("%.2f",cgpa));
        cgpacalculated.setText(Cgpa);
        cgpacalculated2.setText(Cgpa);
    }
}
