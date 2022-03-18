package com.example.cseduportalcse2112;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class DashboardScreenController  extends Dashboard{
    public void getupcomingclasses(ActionEvent action){
        super.setupcomingclassname();
        super.setupcomingclassteachername();
        super.setupcomingclasstime();
        super.setupcomingclassdate();

    }

}
