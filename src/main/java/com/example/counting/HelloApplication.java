package com.example.counting;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.awt.Desktop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.*;

import org.apache.poi.xwpf.usermodel.*;

public class HelloApplication extends Application {

    private static final String TEMPLATE_PATH = "/Doc1.docx";
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
        Scene scene = new Scene(root, 700, 500);

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


        Text measurements = new Text();
        measurements.setLayoutX(50);
        measurements.setLayoutY(250);
        measurements.setText("Порахувати насосик:");
        measurements.setStyle(format);

        Text formulaStart = new Text();
        formulaStart.setLayoutX(50);
        formulaStart.setLayoutY(300);
        formulaStart.setText("150 * 2 * ");
        formulaStart.setStyle(textFormat);

        Text formulaEnd = new Text();
        formulaEnd.setLayoutX(200);
        formulaEnd.setLayoutY(300);
        formulaEnd.setText(" * 2,6");
        formulaEnd.setStyle(textFormat);

        TextField distance = new TextField();
        distance.setPrefWidth(70);
        distance.setPrefHeight(25);
        distance.setLayoutX(130);
        distance.setLayoutY(280);

        Line divisionLine = new Line(50, 310, 250, 310);

        Text divisionValue = new Text();
        divisionValue.setLayoutX(130);
        divisionValue.setLayoutY(330);
        divisionValue.setText("10000");
        divisionValue.setStyle(textFormat);

        Text calculateResult = new Text();
        calculateResult.setLayoutX(250);
        calculateResult.setLayoutY(316);
        calculateResult.setText(" = ");
        calculateResult.setStyle(textFormat);

        Button calculatePump = new Button();
        calculatePump.setPrefWidth(100);
        calculatePump.setPrefHeight(25);
        calculatePump.setLayoutX(450);
        calculatePump.setLayoutY(295);
        calculatePump.setText("Роз. напір");

        Text resultOfMeasurement = new Text();
        resultOfMeasurement.setLayoutX(280);
        resultOfMeasurement.setLayoutY(316);
        resultOfMeasurement.setText("");
        resultOfMeasurement.setStyle(format);

        Button pressureInfo = new Button();
        pressureInfo.setPrefWidth(25);
        pressureInfo.setPrefHeight(25);
        pressureInfo.setLayoutX(560);
        pressureInfo.setLayoutY(295);
        pressureInfo.setText("?");

        TextField consumption = new TextField();
        consumption.setPrefWidth(70);
        consumption.setPrefHeight(25);
        consumption.setLayoutX(50);
        consumption.setLayoutY(380);

        Text consumptionConst = new Text();
        consumptionConst.setLayoutX(125);
        consumptionConst.setLayoutY(400);
        consumptionConst.setText(" * 4,3");
        consumptionConst.setStyle(textFormat);

        Text equalSign = new Text();
        equalSign.setLayoutX(170);
        equalSign.setLayoutY(400);
        equalSign.setText(" = ");
        equalSign.setStyle(textFormat);

        Button calculateConsumption = new Button();
        calculateConsumption.setPrefWidth(100);
        calculateConsumption.setPrefHeight(25);
        calculateConsumption.setLayoutX(450);
        calculateConsumption.setLayoutY(380);
        calculateConsumption.setText("Роз. витрату");

        Text resultOfConsumption = new Text();
        resultOfConsumption.setLayoutX(195);
        resultOfConsumption.setLayoutY(400);
        resultOfConsumption.setText("");
        resultOfConsumption.setStyle(format);

        Button consumptionInfo = new Button();
        consumptionInfo.setPrefWidth(25);
        consumptionInfo.setPrefHeight(25);
        consumptionInfo.setLayoutX(560);
        consumptionInfo.setLayoutY(380);
        consumptionInfo.setText("?");

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

        calculatePump.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double dist = Double.parseDouble(distance.getText());
                double result = (150 * 2 * dist * 2.6) / 10000;
                resultOfMeasurement.setText(Double.toString(result) + " м");
            }
        });

        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                getHostServices().showDocument("http://mnk-if.com");
                mouseEvent.consume();
            }
        });

        pressureInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Інформація по розрахунку напору");
                alert.setHeaderText("Для того, щоб розрахувати напір який необхідний подати для певної довжини труби ми використовуємо формулу (150 * 2L * 2.6)/10000 -\n" +
                        "де L - це довжина труби від котла до крайньої точки в одну сторону у метрах.");

                // Showing the alert
                alert.showAndWait();
            }
        });

        calculateConsumption.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double square = Double.parseDouble(consumption.getText());
                double consResult = square * 4.3;
                double consResultInLiters = consResult / 1000;
                resultOfConsumption.setText(consResult + " л (" + consResultInLiters + " м3\\год)");
            }
        });

        consumptionInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Інформація по розрахунку вмтрати");
                alert.setHeaderText("Для того, щоб розрахувати витрату, необхідно внести дані по наступній формулі:\n" +
                        "S * 4,3\n" +
                        "де S є площа на яку необіхно подату теплоносій у м2");

                // Showing the alert
                alert.showAndWait();
            }
        });
        stage.setTitle("Counting!");

        TextField textField = new TextField();
        Button saveButton = new Button("Save to Word");
        saveButton.setLayoutX(250);

        saveButton.setOnAction(event -> {
            String userInput = textField.getText();
            saveToWordWithPlaceholder(userInput, "222", "tax");
        });

        root.getChildren()
                .addAll(input, calculate, priceWithoutTaxLabel, priceWithoutTax, taxLabel, tax, result, resultLabel, inputSum,
                        measurements, formulaStart, formulaEnd, distance, divisionLine, divisionValue,
                        calculateResult, calculatePump, resultOfMeasurement, pressureInfo, consumption, consumptionConst,
                        equalSign, calculateConsumption, resultOfConsumption, consumptionInfo, textField, saveButton);
        stage.setScene(scene);
        stage.show();
    }

    private void saveToWordWithPlaceholder(String nameInput, String ageInput, String tax) {
        try (InputStream templateInputStream = getClass().getClassLoader().getResourceAsStream("target.docx");
             XWPFDocument document = new XWPFDocument(templateInputStream);
             FileOutputStream out = new FileOutputStream("output.docx")) {

            Map<String, String> replacements = new HashMap<>();
            replacements.put("{{name}}", nameInput);
            replacements.put("{{age}}", ageInput);
            //comment
            replacePlaceholdersInTable(document, replacements);

            document.write(out);
            System.out.println("Word document created successfully with multiple replacements.");

            // Open the saved Word document
            Desktop.getDesktop().open(new File("output.docx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void replacePlaceholdersInTable(XWPFDocument document, Map<String, String> replacements) {
        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            String placeholder = entry.getKey();
            String replacement = entry.getValue();

            Iterator<XWPFTable> tableIterator = document.getTablesIterator();
            while (tableIterator.hasNext()) {
                XWPFTable table = tableIterator.next();
                for (XWPFTableRow row : table.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph paragraph : cell.getParagraphs()) {
                            for (XWPFRun run : paragraph.getRuns()) {
                                String text = run.getText(0);
                                if (text != null && text.contains(placeholder)) {
                                    text = text.replace(placeholder, replacement);
                                    run.setText(text, 0);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}