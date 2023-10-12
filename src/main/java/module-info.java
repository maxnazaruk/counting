module com.example.counting {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.ooxml;
    requires java.desktop;


    opens com.example.counting to javafx.fxml;
    exports com.example.counting;
}