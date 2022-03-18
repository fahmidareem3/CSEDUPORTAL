package com.example.cseduportalcse2112;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CSEDUPORTALUtils {

    public static void changeScence(ActionEvent event, String fxmlFile, String Title, String StudentName){
        Parent root = null;
        if(StudentName != null){
            try{
                FXMLLoader loader = new FXMLLoader(CSEDUPORTALUtils.class.getResource(fxmlFile));
                root = loader.load();
                DashboardScreenController DashboardScreenController = loader.getController();
                DashboardScreenController.getClass();
            }

            catch (IOException e){
                System.out.println(e.getStackTrace());
            }
        }else{
            try{
                root = FXMLLoader.load(CSEDUPORTALUtils.class.getResource(fxmlFile));
            }catch (IOException e){
                System.out.println("Can't Load File");
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(Title);
        stage.setScene(new Scene(root,1100,680));
        stage.show();
    }
    public static void changeScenceforMouseEvent(MouseEvent event, String fxmlFile, String Title, String StudentName){
        Parent root = null;
        if(StudentName != null){
            try{
                FXMLLoader loader = new FXMLLoader(CSEDUPORTALUtils.class.getResource(fxmlFile));
                root = loader.load();
                DashboardScreenController DashboardScreenController = loader.getController();
                DashboardScreenController.getClass();
            }

            catch (IOException e){
                System.out.println(e.getStackTrace());
            }
        }else{
            try{
                root = FXMLLoader.load(CSEDUPORTALUtils.class.getResource(fxmlFile));
            }catch (IOException e){
                System.out.println("Can't Load File");
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(Title);
        stage.setScene(new Scene(root,1100,680));
        stage.show();
    }
}