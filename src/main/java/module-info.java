module com.example.cseduportalcse2112 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.cseduportalcse2112 to javafx.fxml;
    exports com.example.cseduportalcse2112;
}