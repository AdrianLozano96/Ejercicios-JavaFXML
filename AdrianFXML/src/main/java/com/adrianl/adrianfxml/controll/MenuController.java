package com.adrianl.adrianfxml.controll;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private VBox mi_menu;   //Padre
    @FXML
    private VBox principio; //Vista anidada que sera del tipo de su padre   (transalete X/Y/Z = 20000) setTranslateX(200)
    @FXML
    private AnchorPane lista;   //Lista personas
    @FXML
    public AnchorPane graficas; //Vista gráficas


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {    //Como quiero que esten los elementoos al ejecutar el programa
        mi_menu.setTranslateX(-500);    //Menú escondido
    }

    @FXML
    public void ventanaPersonas(ActionEvent actionEvent) {
        mi_menu.setTranslateX(-500);
        lista.setVisible(true);
    }

    @FXML
    public void ventanaGrafica(ActionEvent actionEvent) {
        mi_menu.setTranslateX(-500);
        graficas.setVisible(true);
    }

    @FXML
    public void ventanaInfo(ActionEvent actionEvent) {
        mi_menu.setTranslateX(-500);//Esconde el menú
        principio.setVisible(true); //Muestro la vista que quiero
    }

    @FXML
    public void salirPrograma(ActionEvent actionEvent) {    //Como hacer alertas (vale para los cuatro tipos)
        Alert alertaSalir = new Alert(Alert.AlertType.CONFIRMATION);    //Creo una alerta con su tipo
        alertaSalir.setTitle("Ventana de Salir");  //Titulo de la alerta
        alertaSalir.setHeaderText("Desea Salir del programa?");    //Texto con el simbolo de la alerta escogida
        alertaSalir.setContentText("Si acepta se cerrara el programa");    //Texto en la parte de los botones
        alertaSalir.showAndWait();
        if (alertaSalir.getResult() == ButtonType.OK) { //Para el boton Ok, el cancel no hace falta
            System.exit(0); //Acción a realizar, sino se pone nada pues no hace nada
        }
    }

    @FXML
    public void mostrarMenu(ActionEvent actionEvent) {
        mi_menu.setTranslateX(0);   //Saca el menú
    }


}
