package com.adrianl.resumen;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class HelloController {
    @FXML
    public AnchorPane principal;
    @FXML
    public AnchorPane tabla;
    @FXML
    public AnchorPane graficos;
    @FXML
    private VBox vbox_menu;
    @FXML
    private AnchorPane vistas_anidadas;
    @FXML
    public AnchorPane lista;

    TranslateTransition animation;
    private boolean escondido = false;
    private boolean nuevoFondo = false;

    @FXML
    public void menuAction(ActionEvent actionEvent) {
        if(!escondido){ //Escondo Menu
            animation = new TranslateTransition(Duration.millis(2500), vbox_menu); //Elemento o vista a animar
            animation.setFromX(0);
            animation.setToX(-100);
            animation.play();
            escondido = true;
        }else{  //Muestro Menu
            animation = new TranslateTransition(Duration.millis(2500), vbox_menu); //Elemento o vista a animar
            animation.setFromX(-100);
            animation.setToX(0);
            animation.play();
            escondido = false;
        }
    }

    @FXML
    public void listaAction(ActionEvent actionEvent) {
        lista.setVisible(true);
        tabla.setVisible(false);
        graficos.setVisible(false);
    }

    @FXML
    public void tablaAction(ActionEvent actionEvent) {
        tabla.setVisible(true);
        lista.setVisible(false);
        graficos.setVisible(false);
    }

    @FXML
    public void graficosAction(ActionEvent actionEvent) {
        graficos.setVisible(true);
        lista.setVisible(false);
        tabla.setVisible(false);
    }

    @FXML
    public void fondoAction(ActionEvent actionEvent) {
        if(!nuevoFondo) {
            principal.setBackground(new Background(new BackgroundFill(Color.VIOLET, CornerRadii.EMPTY, Insets.EMPTY)));
            nuevoFondo = true;
        }else{
            principal.setBackground(new Background(new BackgroundFill(Color.TOMATO, CornerRadii.EMPTY, Insets.EMPTY)));
            nuevoFondo = false;
        }
    }

    @FXML
    public void salirAction(ActionEvent actionEvent) {  //SALIR
        Alert alertaSalir = new Alert(Alert.AlertType.CONFIRMATION);    //Creo una alerta con su tipo
        alertaSalir.setTitle("Ventana de Salir");  //Titulo de la alerta
        alertaSalir.setHeaderText("Desea Salir del programa?");    //Texto con el simbolo de la alerta escogida
        alertaSalir.setContentText("Si acepta se cerrara el programa");    //Texto en la parte de los botones
        alertaSalir.showAndWait();
        if (alertaSalir.getResult() == ButtonType.OK) { //Para el boton Ok, el cancel no hace falta
            System.exit(0); //Acción a realizar, sino se pone nada pues no hace nada
        }
    }

}