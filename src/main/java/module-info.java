module Models {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens Models to javafx.fxml;
    exports Models;
    exports Controllers;
    opens Controllers to javafx.fxml;
    exports Models.ClassHierarchy;
    opens Models.ClassHierarchy to javafx.fxml;
}