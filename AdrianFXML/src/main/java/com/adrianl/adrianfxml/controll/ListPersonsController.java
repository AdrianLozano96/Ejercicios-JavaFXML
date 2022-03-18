package com.adrianl.adrianfxml.controll;

import com.adrianl.adrianfxml.model.Persona;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

public class ListPersonsController implements Initializable {
//Elementos del FXML
    @FXML
    public ImageView i_imagen;
    @FXML
    public Label i_nombre;
    @FXML
    public Label i_genero;
    @FXML
    public Label i_lugar;
    @FXML
    public Label i_correo;
    @FXML
    public Label i_movil;
    @FXML
    private AnchorPane ventanaLista;    //Padre
    @FXML
    private ListView<Persona> listaPersonas;    //Lista FXML
    
    @FXML
    public void volverAtras(ActionEvent actionEvent) {
        ventanaLista.setVisible(false);
    }   //En vez de poner el boton pongo su método asociado en el FXML

    private ObservableList<Persona> personas = FXCollections.observableArrayList(); //Lista observable de Personas

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {    //Lo primero en ejecutar
        try {
            myPersons();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void myPersons() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://randomuser.me/api/?results=100"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Platform.runLater(() -> listaPersonas.getItems().removeAll(personas));//Elimino elementos de la lista para así actualizar valores
        JSONArray dataArray = new JSONArray(response.body().substring(11, response.body().length()-1)); //12 elementos de Result
        int count_male = 0;
        int count_female = 0;
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject row = dataArray.getJSONObject(i);
            Platform.runLater(() -> personas.add(new Persona( //Agrego elementos a la lista
                    //Nombre fila Result . su String ( Esto si el string se encuentra en otra clase)
                    row.getJSONObject("picture").getString("large"),
                    row.getJSONObject("name").getString("first") + " " + row.getJSONObject("name").getString("last"),
                    row.getString("gender"), //Si el String esta en esa clase solo poner el nombre del campo
                    row.getJSONObject("location").getString("city") + " " + row.getJSONObject("location").getString("country"),
                    row.getString("email"),
                    row.getString("phone"))));

            if (row.getString("gender").equals("male")) {
                count_male++;
            } else {
                count_female++;
            }
        }
        Platform.runLater(() -> {   //Agrego la lista Observable a la que he ido añadiendo elementos a la lista del fxml
            listaPersonas.setItems(personas);
            listaPersonas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)-> {//Acción de la selección
                if (newValue != null) {
                    Persona p1 = listaPersonas.getSelectionModel().getSelectedItem();//Añodo a cada elemento el valor seleccionado
                    i_imagen.setImage(new Image(p1.getPicture()));
                    i_nombre.setText(p1.getName());
                    i_genero.setText(p1.getGender());
                    i_lugar.setText(p1.getLocation());
                    i_correo.setText(p1.getEmail());
                    i_movil.setText(p1.getPhone());
                }
            });
        });
    }

}