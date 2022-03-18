package com.adrianl.resumen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaController implements Initializable {
    @FXML
    public ListView<Personas> vista_lista;
    @FXML
    public AnchorPane detalle;

    private ObservableList<Personas> personas; //= FXCollections.observableArrayList(); //Lista observable de Personas
    @FXML
    private DetalleController detalleController;    //Si el fxml no esta anidado da fallo

    Personas p1 = new Personas("Persona1","male",25);
    Personas p2 = new Personas("Persona2","female",15);
    Personas p3 = new Personas("Persona3","male",35);
    Personas p4 = new Personas("Persona4","female",75);
    Personas p5 = new Personas("Persona5","male",45);
    Personas p6 = new Personas("Persona6","female",85);
    Personas p7 = new Personas("Persona7","male",5);
    Personas p8 = new Personas("Persona8","female",65);
    Personas p9 = new Personas("Persona9","male",23);
    Personas p10 = new Personas("Persona10","male",98);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarLista();
    }

    public void cargarLista(){
        personas = FXCollections.observableArrayList(
                p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
        //personas.addAll(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);
        vista_lista.setItems(personas);
        //vista_lista.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        vista_lista.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
                enviarDatos(newValue);
        });
    }

    public void enviarDatos(Personas persona){  //Abro la ventana anidada y le paso los datos
        detalleController.cargarDatos(persona.getNombre(), persona.getGenero(), persona.getEdad());
        detalle.setVisible(true);
    }
}
