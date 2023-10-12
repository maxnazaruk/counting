package com.example.counting;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static final String format = "-fx-font-weight: bold; -fx-font-size: 20";
    private static final String redFormat = "-fx-font-weight: bold; -fx-font-size: 20; -fx-fill: red;";
    private static final String greenFormat = "-fx-font-weight: bold; -fx-font-size: 20; -fx-fill: green;";
    private static final String adFormat = "-fx-font-size: 16; -fx-fill: green;";
    private static final String textFormat = "-fx-font-size: 20";
    private Pane root;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        root = new Pane();
        Scene scene = new Scene(root, 500, 500);

        TextField input = new TextField();
        input.setPrefWidth(150);
        input.setPrefHeight(25);
        input.setLayoutX(50);
        input.setLayoutY(25);

        Button calculate = new Button();
        calculate.setPrefWidth(120);
        calculate.setPrefHeight(25);
        calculate.setLayoutX(250);
        calculate.setLayoutY(25);
        calculate.setText("Розрахувати");

        Text priceWithoutTaxLabel = new Text();
        priceWithoutTaxLabel.setLayoutX(50);
        priceWithoutTaxLabel.setLayoutY(100);
        priceWithoutTaxLabel.setText("Сумма без ПДВ: ");
        priceWithoutTaxLabel.setStyle(textFormat);

        Text priceWithoutTax = new Text();
        priceWithoutTax.setLayoutX(210);
        priceWithoutTax.setLayoutY(100);
        priceWithoutTax.setStyle(format);

        Text taxLabel = new Text();
        taxLabel.setLayoutX(50);
        taxLabel.setLayoutY(150);
        taxLabel.setText("ПДВ: ");
        taxLabel.setStyle(textFormat);

        Text tax = new Text();
        tax.setLayoutX(110);
        tax.setLayoutY(150);
        tax.setStyle(format);

        Text resultLabel = new Text();
        resultLabel.setLayoutX(50);
        resultLabel.setLayoutY(200);
        resultLabel.setText("Контрольна сумма: ");
        resultLabel.setStyle(textFormat);

        Text result = new Text();
        result.setLayoutX(230);
        result.setLayoutY(200);
        result.setStyle(format);

        Text inputSum = new Text();
        inputSum.setLayoutX(350);
        inputSum.setLayoutY(200);

        Text advertisment = new Text();
        advertisment.setLayoutX(100);
        advertisment.setLayoutY(480);
        advertisment.setText("Купуйте насоси WILO у Івано-Франківську!!!");
        advertisment.setStyle(adFormat);

        Image logo = new Image(getClass().getResourceAsStream("/com/example/counting/wilo.jpg"));
        ImageView imageView = new ImageView(logo);
        imageView.setPreserveRatio(true);
        imageView.setLayoutX(150);
        imageView.setLayoutY(250);

        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String data = input.getText();
                input.clear();
                Double sum = Double.valueOf(data);
                Integer withoutTax = (Integer.valueOf(data) * 5) / 6;
                priceWithoutTax.setText((Integer.valueOf(data) * 5) / 6 + "");
                Integer taxResult = Integer.valueOf(data) - withoutTax;
                tax.setText(taxResult + "");

                Integer resultOff = withoutTax + taxResult;
                result.setText(resultOff.toString());
                if(sum.equals(Double.valueOf(resultOff))){
                    inputSum.setText(sum + "");
                    inputSum.setStyle(greenFormat);
                }else{
                    inputSum.setText(sum + "");
                    inputSum.setStyle(redFormat);
                }
            }
        });

        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                getHostServices().showDocument("http://mnk-if.com");
                mouseEvent.consume();
            }
        });

        stage.setTitle("Counting!");
        root.getChildren()
                .addAll(input, calculate, priceWithoutTaxLabel, priceWithoutTax, taxLabel, tax, result, resultLabel, inputSum, advertisment, imageView);
        stage.setScene(scene);
        stage.show();
    }
}