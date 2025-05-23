module com.example.osas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.osas to javafx.fxml;
    exports com.example.osas;
}