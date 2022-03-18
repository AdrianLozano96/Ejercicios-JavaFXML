package com.adrianl.resumen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class TablaController implements Initializable {
    @FXML
    public AnchorPane detalle;
    @FXML
    public TableView<Personas> tabla;   //Tiene que tener el tipo
    @FXML
    public TableColumn<Personas,String>columna1;    //Si es editable
    @FXML
    public TableColumn<?,?> columna2;
    @FXML
    public TableColumn<?,?> columna3;
    @FXML
    private DetalleController detalleController;    //Lama al método no hace falta instanciar
    private ObservableList<Personas> personas;  //Se instancia despues con = FXCollections.observableArrayList(valores)

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
        cargarTabla();
    }

    public void cargarTabla(){
        tabla.setEditable(true);    //Inicializo la tabla e indico que sea editable
        //Se da título a cada columna
        columna1.setCellValueFactory(new PropertyValueFactory<Personas, String>("Nombre")); //El nombre debe ser igual al puesto en la clase
        columna2.setCellValueFactory(new PropertyValueFactory<>("Genero"));
        columna3.setCellValueFactory(new PropertyValueFactory<>("Edad"));
        personas = FXCollections.observableArrayList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
        tabla.setItems(personas); //Añado los datos a la tabla
        columna1.setCellFactory(TextFieldTableCell.<Personas>forTableColumn());
        columna1.setOnEditCommit(data -> {  //Para cambiar el valor por uno nuevo al editar el campo
            Personas per = data.getRowValue();
            per.setNombre(data.getNewValue()); });  //El campo cambiado
        tabla.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                enviarDatos(newValue);
            }
        });
    }

    public void enviarDatos(Personas persona){  //Abro la ventana anidada y le paso los datos
        detalleController.cargarDatos(persona.getNombre(), persona.getGenero(), persona.getEdad());
        detalle.setVisible(true);
    }

}
