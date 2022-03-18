module com.adrianl.adrianfxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.net.http;
    requires javafx.base;
    requires javafx.graphics;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome5;



    opens com.adrianl.adrianfxml to javafx.fxml;
    exports com.adrianl.adrianfxml;
    opens com.adrianl.adrianfxml.controll to javafx.fxml;
    exports com.adrianl.adrianfxml.controll;
}