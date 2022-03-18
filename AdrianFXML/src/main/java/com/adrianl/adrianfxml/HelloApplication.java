package com.adrianl.adrianfxml;

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
        ResourceBundle resource = ResourceBundle.getBundle("com.adrianl.adrianfxml.i18n.string",eng);
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"), resource);
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 600, 500);    //Width, Height
        stage.setTitle("Api UseRandom Adrian Lozano");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}