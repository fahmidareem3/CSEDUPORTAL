module Models {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens Models to javafx.fxml;
    exports Models;
    exports Classhirerchy;
    opens Classhirerchy to javafx.fxml;
    exports Controllers;
    opens Controllers to javafx.fxml;
}