package com.adrianl.resumen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class DetalleController {
    @FXML
    public AnchorPane padre_detalle;
    @FXML
    private Label l_nombre;
    @FXML
    private Label l_genero;
    @FXML
    private Label l_edad;

    public void cargarDatos(String nombre, String genero, int edad){
        l_nombre.setText(nombre);
        l_genero.setText(genero);
        l_edad.setText(""+edad);
    }

    public void cerrarAction(ActionEvent actionEvent) {
        padre_detalle.setVisible(false);
    }

}
