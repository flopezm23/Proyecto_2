module com.example.proyecto2_2022 {
    requires javafx.controls;
    requires javafx.fxml;
    requires itextpdf;


    opens com.example.proyecto2_2022 to javafx.fxml;
    exports com.example.proyecto2_2022;
}