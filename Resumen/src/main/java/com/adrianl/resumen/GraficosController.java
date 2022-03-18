package com.adrianl.resumen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class GraficosController implements Initializable {
    @FXML
    public PieChart grafica_circular;
    @FXML
    public LineChart<String, Double> grafica_lineal;

    private ObservableList<PieChart.Data> graficaPaises;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarGraficaCircular();
        cargarGraficaLineal();
    }

    public void cargarGraficaCircular(){

        graficaPaises = FXCollections.observableArrayList(
                new PieChart.Data("Spain", 50),
                new PieChart.Data("United_Kingdom", 30),
                new PieChart.Data("New_Zealand", 60),
                new PieChart.Data("Ireland", 10),
                new PieChart.Data("Germany", 78),
                new PieChart.Data("Canada", 43),
                new PieChart.Data("France", 32),
                new PieChart.Data("Netherlands", 20),
                new PieChart.Data("United_States", 80) );
        grafica_circular.setData(graficaPaises);
        grafica_circular.setClockwise(true);
        grafica_circular.setTitle("Gráfico de Pises");

    }

    public void cargarGraficaLineal(){
        grafica_lineal.setTitle("Ranking Octubre TIOBE");
        XYChart.Series serieC = new XYChart.Series();
        serieC.setName("C");
        serieC.getData().add(new XYChart.Data("2015", 0.9));
        serieC.getData().add(new XYChart.Data("2016", 0.9));
        serieC.getData().add(new XYChart.Data("2017", 0.9));
        serieC.getData().add(new XYChart.Data("2018", 0.9));
        serieC.getData().add(new XYChart.Data("2019", 0.9));
        serieC.getData().add(new XYChart.Data("2020", 1));
        XYChart.Series serieJava = new XYChart.Series();
        serieJava.setName("Java");
        serieJava.getData().add(new XYChart.Data("2015", 1));
        serieJava.getData().add(new XYChart.Data("2016", 1));
        serieJava.getData().add(new XYChart.Data("2017", 1));
        serieJava.getData().add(new XYChart.Data("2018", 1));
        serieJava.getData().add(new XYChart.Data("2019", 1));
        serieJava.getData().add(new XYChart.Data("2020", 0.9));
        XYChart.Series seriePython = new XYChart.Series();
        seriePython.setName("Python");
        seriePython.getData().add(new XYChart.Data("2015", 0.6));
        seriePython.getData().add(new XYChart.Data("2016", 0.6));
        seriePython.getData().add(new XYChart.Data("2017", 0.6));
        seriePython.getData().add(new XYChart.Data("2018", 0.7));
        seriePython.getData().add(new XYChart.Data("2019", 0.8));
        seriePython.getData().add(new XYChart.Data("2020", 0.8));
        grafica_lineal.getData().addAll(serieC, serieJava, seriePython);
    }



}
