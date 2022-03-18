module com.adrianl.resumen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.adrianl.resumen to javafx.fxml;
    exports com.adrianl.resumen;
}