module com.example.detyra2 {
    requires javafx.controls;
    requires javafx.fxml;




    opens Code to javafx.fxml;
    exports Code;
    exports Controller;

    opens Controller to javafx.fxml;
}