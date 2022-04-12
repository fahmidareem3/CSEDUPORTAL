package Models;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class CGPACalculator  {


    private double[] gpa = new double [5];
    private double[] credits = new double[5];
    static double total_credit;
    double cgpa;

//    @Override
//    public void start(Stage stage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(CSEDUPORTAL.class.getResource("CGPACalculatorScreen.fxml"));
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

    public void gpaSetter(double gpa1, double gpa2, double gpa3, double gpa4, double gpa5) {

            gpa[0] = gpa1;
            gpa[1] = gpa2;
            gpa[2] = gpa3;
            gpa[3] = gpa4;
            gpa[4] = gpa5;
            for(int i = 0; i < 5; i++){
                if(gpa[i] > 4.00 || gpa[i] < 0.00){
                   gpa[i] = 0;
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
            //System.out.println(credits[i]);
        }
//        credits[0] = 3;
//        credits[1] = 3;
//        credits[2] = 3;
//        credits[3] = 2;
//        credits[4] = 3;


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
