package com.adrianl.resumen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Locale esp = new Locale("es", "ES");
        Locale eng = new Locale("en","EN");
        ResourceBundle resource = ResourceBundle.getBundle("com.adrianl.resumen.i18n.strings",eng);
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"), resource);
        Scene scene = new Scene(root, 600, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {launch();}
}