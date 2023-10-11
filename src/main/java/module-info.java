module com.example.counting {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.counting to javafx.fxml;
    exports com.example.counting;
}