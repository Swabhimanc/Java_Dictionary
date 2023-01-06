module com.example.google_dictionary {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.example.google_dictionary to javafx.fxml;
    exports com.example.google_dictionary;
}