module ma.enset.tp6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;


    //opens org.example.tp6 to javafx.fxml;
    opens ma.enset.tp6.controller to javafx.fxml;
    opens ma.enset.tp6.models to javafx.base;

    exports ma.enset.tp6;
}