package com.adrianl.adrianfxml.controll;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
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

public class GraphPersons implements Initializable {
    @FXML
    public AnchorPane vistaGrafica;
    @FXML
    private PieChart g_genero;
    @FXML
    public PieChart g_pais;

    private ObservableList<PieChart.Data> graficaGenero;
    private ObservableList<PieChart.Data> graficaPais;

    int count_male = 0;
    int count_female = 0;
    int spain, australia, united_Kingdom, new_Zealand, ireland, germany, canada, france, denmark, brazil, norway, turkey,
            netherlands, united_States, finland;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            myPersons();
        } catch (IOException | InterruptedException e) {
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
        JSONArray dataArray = new JSONArray(response.body().substring(11, response.body().length()-1)); //12 elementos de Result

        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject row = dataArray.getJSONObject(i);

            if (row.getString("gender").equals("male")) {
                count_male++;
            } else {
                count_female++;
            }

            datos_pises(row);
        }
        Platform.runLater(() -> {   //Agrego los elementos a la gráfica

            graficaGenero = FXCollections.observableArrayList(
                    new PieChart.Data("Male: "+count_male, count_male),
                    new PieChart.Data("Female: "+count_female, count_female));
            g_genero.setData(graficaGenero);
            g_genero.setClockwise(false);
            g_genero.setTitle("Gráfico de Géneros");

            graficaPais = FXCollections.observableArrayList(
                    new PieChart.Data("Spain", spain),
                    new PieChart.Data("Australia", australia),
                    new PieChart.Data("United_Kingdom", united_Kingdom),
                    new PieChart.Data("New_Zealand", new_Zealand),
                    new PieChart.Data("Ireland", ireland),
                    new PieChart.Data("Germany", germany),
                    new PieChart.Data("Canada", canada),
                    new PieChart.Data("France", france),
                    new PieChart.Data("Denmark", denmark),
                    new PieChart.Data("Brazil", brazil),
                    new PieChart.Data("Norway", norway),
                    new PieChart.Data("Turkey", turkey),
                    new PieChart.Data("Netherlands", netherlands),
                    new PieChart.Data("United_States", united_States),
                    new PieChart.Data("Finland", finland));
            g_pais.setData(graficaPais);
            g_genero.setClockwise(false);
            g_pais.setTitle("Gráfico de Pises");
        });
    }

    private void datos_pises(JSONObject row) {
        if (row.getJSONObject("location").getString("country").equals("Spain")) {
            spain++;
        }
        if(row.getJSONObject("location").getString("country").equals("Australia")){
            australia++;
        }
        if(row.getJSONObject("location").getString("country").equals("United Kingdom")){
            united_Kingdom++;
        }
        if(row.getJSONObject("location").getString("country").equals("New Zealand")){
            new_Zealand++;
        }
        if(row.getJSONObject("location").getString("country").equals("Ireland")){
            ireland++;
        }
        if(row.getJSONObject("location").getString("country").equals("Germany")){
            germany++;
        }
        if(row.getJSONObject("location").getString("country").equals("Canada")){
            canada++;
        }
        if(row.getJSONObject("location").getString("country").equals("France")){
            france++;
        }
        if(row.getJSONObject("location").getString("country").equals("Denmark")){
            denmark++;
        }
        if(row.getJSONObject("location").getString("country").equals("Brazil")){
            brazil++;
        }
        if(row.getJSONObject("location").getString("country").equals("Norway")){
            norway++;
        }
        if(row.getJSONObject("location").getString("country").equals("Turkey")){
            turkey++;
        }
        if(row.getJSONObject("location").getString("country").equals("Netherlands")){
            netherlands++;
        }
        if(row.getJSONObject("location").getString("country").equals("United States")){
            united_States++;
        }
        if(row.getJSONObject("location").getString("country").equals("Finland")){
            finland++;
        }
    }

    public void volver(ActionEvent actionEvent) {
        vistaGrafica.setVisible(false);
    }
}

/*
new PieChart.Data("Spain: "+spain, spain*100/6.6),
                    new PieChart.Data("Australia: "+australia, australia),
                    new PieChart.Data("United_Kingdom: "+united_Kingdom, united_Kingdom),
                    new PieChart.Data("New_Zealand: "+new_Zealand, new_Zealand),
                    new PieChart.Data("Ireland: "+ireland, ireland),
                    new PieChart.Data("Germany: "+germany, germany),
                    new PieChart.Data("Canada: "+canada, canada),
                    new PieChart.Data("France: "+france, france),
                    new PieChart.Data("Denmark: "+denmark, denmark),
                    new PieChart.Data("Brazil: "+brazil, brazil),
                    new PieChart.Data("Norway: "+norway, norway),
                    new PieChart.Data("Turkey: "+turkey, turkey),
                    new PieChart.Data("Netherlands: "+netherlands, netherlands),
                    new PieChart.Data("United_States: "+united_States, united_States),
                    new PieChart.Data("Finland: "+finland, finland));
 */
