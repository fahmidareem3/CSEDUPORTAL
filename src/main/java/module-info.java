module com.example.cseduportalcse2112 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cseduportalcse2112 to javafx.fxml;
    exports com.example.cseduportalcse2112;
}