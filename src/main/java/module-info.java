module com.example.java_tamuna_metonidzee {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.java_tamuna_metonidzee to javafx.fxml;
    exports com.example.java_tamuna_metonidzee;
}