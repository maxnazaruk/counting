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
import java.text.DecimalFormat;
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
        input.setPrefWidth(250);
        input.setPrefHeight(25);
        input.setLayoutX(100);
        input.setLayoutY(25);
        input.setPromptText("Покупець");

        Text focus = new Text();
        focus.setLayoutX(35);
        focus.setLayoutY(42.5);
        focus.setText("Покупець:");

        TextField inputGood1 = new TextField();
        inputGood1.setPrefWidth(350);
        inputGood1.setPrefHeight(25);
        inputGood1.setLayoutX(100);
        inputGood1.setLayoutY(85);
        inputGood1.setPromptText("Найменування товару");

        Text goodTitle = new Text();
        goodTitle.setLayoutX(185);
        goodTitle.setLayoutY(80);
        goodTitle.setText("Товари (роботи, послуги)");

        Text good1 = new Text();
        good1.setLayoutX(75);
        good1.setLayoutY(102.5);
        good1.setText("№1:");

        TextField inputGoodCount1 = new TextField();
        inputGoodCount1.setPrefWidth(55);
        inputGoodCount1.setPrefHeight(25);
        inputGoodCount1.setLayoutX(480);
        inputGoodCount1.setLayoutY(85);
        inputGoodCount1.setPromptText("Кіл-сть");

        Text goodCount1 = new Text();
        goodCount1.setLayoutX(485);
        goodCount1.setLayoutY(80);
        goodCount1.setText("Кіл-сть:");

        TextField inputGoodPrice1 = new TextField();
        inputGoodPrice1.setPrefWidth(110);
        inputGoodPrice1.setPrefHeight(25);
        inputGoodPrice1.setLayoutX(550);
        inputGoodPrice1.setLayoutY(85);
        inputGoodPrice1.setPromptText("Вартість з ПДВ");

        Text goodPrice1 = new Text();
        goodPrice1.setLayoutX(550);
        goodPrice1.setLayoutY(80);
        goodPrice1.setText("Вартість 1шт. з ПДВ");


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

/*
                String data = input.getText();
                input.clear();
                Double sum = Double.valueOf(data);
                Integer withoutTax = (Integer.valueOf(data) * 5) / 6;

                Integer taxResult = Integer.valueOf(data) - withoutTax;


                Integer resultOff = withoutTax + taxResult;

  */

        calculatePump.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double dist = Double.parseDouble(distance.getText());
                double result = (150 * 2 * dist * 2.6) / 10000;
                resultOfMeasurement.setText(Double.toString(result) + " м");
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


        Button saveButton = new Button("Сформувати");
        saveButton.setLayoutX(580);
        saveButton.setLayoutY(180);

        saveButton.setOnAction(event -> {
            String buyer = input.getText();
            String goodName1 = inputGood1.getText();
            String goodCountField1 = inputGoodCount1.getText();

            double goodPriceWithTax = Double.parseDouble(inputGoodPrice1.getText());
            double singlePriceWithoutTax = goodPriceWithTax * 5 / 6;

            String singlePriceWithout = new DecimalFormat("##.##").format(singlePriceWithoutTax);

            double fullPriceWithoutTax = Double.parseDouble(goodCountField1) * singlePriceWithoutTax;
            double tax = goodPriceWithTax * Double.parseDouble(goodCountField1) - fullPriceWithoutTax;
            saveToWordWithPlaceholder(buyer, goodName1, goodCountField1, singlePriceWithout, fullPriceWithoutTax + "", tax + "");
        });

        root.getChildren()
                .addAll( focus, input, inputGood1, good1, inputGoodCount1, goodCount1, inputGoodPrice1, goodPrice1,
                        goodTitle,
                        measurements, formulaStart, formulaEnd, distance, divisionLine, divisionValue,
                        calculateResult, calculatePump, resultOfMeasurement, pressureInfo, consumption, consumptionConst,
                        equalSign, calculateConsumption, resultOfConsumption, consumptionInfo, saveButton);
        stage.setScene(scene);
        stage.show();
    }

    private void saveToWordWithPlaceholder(String buyer, String goodName, String count, String singlePrice, String fullPrice, String tax) {
        try (InputStream templateInputStream = getClass().getClassLoader().getResourceAsStream("target.docx");
             XWPFDocument document = new XWPFDocument(templateInputStream);
             FileOutputStream out = new FileOutputStream("output.docx")) {

            Map<String, String> replacements = new HashMap<>();
            replacements.put("{{buyer}}", buyer);
            replacements.put("{{goodName}}", goodName);
            replacements.put("{{count}}", count);
            replacements.put("{{singlePrice}}", singlePrice);
            replacements.put("{{fullPrice}}", fullPrice);
            replacements.put("{{tax}}", tax);
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