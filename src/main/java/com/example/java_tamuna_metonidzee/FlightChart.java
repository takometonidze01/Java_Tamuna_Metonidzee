package com.example.java_tamuna_metonidzee;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.sql.SQLException;
import java.util.List;


public class FlightChart extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws SQLException {
        // Create a grid pane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Add labels and text fields to the grid
        Label month = new Label("Month");
        Label numberOfFlights = new Label("Number Of Flights");
        grid.add(month, 0, 0);
        grid.add(numberOfFlights, 0, 1);

        // Create the scene and set the stage

        FlightsDao flightsDao = new FlightsDao();
        List<Flights> flights = flightsDao.flighs("us");

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");
        yAxis.setLabel("Number of Flights");
        final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Flight Dynamics by City");
        XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
        series1.setName("New York");
        series1.getData().add(new XYChart.Data<String, Number>("Jan", 23));
        series1.getData().add(new XYChart.Data<String, Number>("Feb", 14));
        series1.getData().add(new XYChart.Data<String, Number>("Mar", 15));
        XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
        series2.setName("Chicago");
        series2.getData().add(new XYChart.Data<String, Number>("Jan", 33));
        series2.getData().add(new XYChart.Data<String, Number>("Feb", 34));
        series2.getData().add(new XYChart.Data<String, Number>("Mar", 25));
        XYChart.Series<String, Number> series3 = new XYChart.Series<String, Number>();
        series3.setName("San Francisco");
        series3.getData().add(new XYChart.Data<String, Number>("Jan", 44));
        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series1);
        lineChart.getData().add(series2);
        lineChart.getData().add(series3);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}