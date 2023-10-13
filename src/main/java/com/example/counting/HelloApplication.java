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
        Scene scene = new Scene(root, 1000, 800);

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

        TextField invoice = new TextField();
        invoice.setPrefWidth(250);
        invoice.setPrefHeight(25);
        invoice.setLayoutX(500);
        invoice.setLayoutY(25);
        invoice.setPromptText("Рахунок №");

        Text invoiceTitle = new Text();
        invoiceTitle.setLayoutX(375);
        invoiceTitle.setLayoutY(42.5);
        invoiceTitle.setText("Рахунок на оплату №:");

        Text goodTitle = new Text();
        goodTitle.setLayoutX(185);
        goodTitle.setLayoutY(80);
        goodTitle.setText("Товари (роботи, послуги)");

        Text goodCount1 = new Text();
        goodCount1.setLayoutX(485);
        goodCount1.setLayoutY(80);
        goodCount1.setText("Кіл-сть:");

        Text goodPrice1 = new Text();
        goodPrice1.setLayoutX(550);
        goodPrice1.setLayoutY(80);
        goodPrice1.setText("Вартість 1шт. з ПДВ");
        //----------------------------------------------------------------------------------------
        Text good1 = new Text();
        good1.setLayoutX(75);
        good1.setLayoutY(102.5);
        good1.setText("№1:");

        TextField inputGood1 = new TextField();
        inputGood1.setPrefWidth(350);
        inputGood1.setPrefHeight(25);
        inputGood1.setLayoutX(100);
        inputGood1.setLayoutY(85);
        inputGood1.setPromptText("Найменування товару");

        TextField inputGoodCount1 = new TextField();
        inputGoodCount1.setPrefWidth(55);
        inputGoodCount1.setPrefHeight(25);
        inputGoodCount1.setLayoutX(480);
        inputGoodCount1.setLayoutY(85);
        inputGoodCount1.setPromptText("Кіл-сть");

        TextField inputGoodPrice1 = new TextField();
        inputGoodPrice1.setPrefWidth(110);
        inputGoodPrice1.setPrefHeight(25);
        inputGoodPrice1.setLayoutX(550);
        inputGoodPrice1.setLayoutY(85);
        inputGoodPrice1.setPromptText("Вартість з ПДВ");

        //----------------------------------------------------------------------------------------
        Text good2 = new Text();
        good2.setLayoutX(75);
        good2.setLayoutY(137.5);
        good2.setText("№2:");

        TextField inputGood2 = new TextField();
        inputGood2.setPrefWidth(350);
        inputGood2.setPrefHeight(25);
        inputGood2.setLayoutX(100);
        inputGood2.setLayoutY(120);
        inputGood2.setPromptText("Найменування товару");

        TextField inputGoodCount2 = new TextField();
        inputGoodCount2.setPrefWidth(55);
        inputGoodCount2.setPrefHeight(25);
        inputGoodCount2.setLayoutX(480);
        inputGoodCount2.setLayoutY(120);
        inputGoodCount2.setPromptText("Кіл-сть");

        TextField inputGoodPrice2 = new TextField();
        inputGoodPrice2.setPrefWidth(110);
        inputGoodPrice2.setPrefHeight(25);
        inputGoodPrice2.setLayoutX(550);
        inputGoodPrice2.setLayoutY(120);
        inputGoodPrice2.setPromptText("Вартість з ПДВ");
        //----------------------------------------------------------------------------------------

        //----------------------------------------------------------------------------------------
        Text good3 = new Text();
        good3.setLayoutX(75);
        good3.setLayoutY(172.5);
        good3.setText("№3:");

        TextField inputGood3 = new TextField();
        inputGood3.setPrefWidth(350);
        inputGood3.setPrefHeight(25);
        inputGood3.setLayoutX(100);
        inputGood3.setLayoutY(155);
        inputGood3.setPromptText("Найменування товару");

        TextField inputGoodCount3 = new TextField();
        inputGoodCount3.setPrefWidth(55);
        inputGoodCount3.setPrefHeight(25);
        inputGoodCount3.setLayoutX(480);
        inputGoodCount3.setLayoutY(155);
        inputGoodCount3.setPromptText("Кіл-сть");

        TextField inputGoodPrice3 = new TextField();
        inputGoodPrice3.setPrefWidth(110);
        inputGoodPrice3.setPrefHeight(25);
        inputGoodPrice3.setLayoutX(550);
        inputGoodPrice3.setLayoutY(155);
        inputGoodPrice3.setPromptText("Вартість з ПДВ");
        //----------------------------------------------------------------------------------------


        Text measurements = new Text();
        measurements.setLayoutX(50);
        measurements.setLayoutY(550);
        measurements.setText("Порахувати насосик:");
        measurements.setStyle(format);

        Text formulaStart = new Text();
        formulaStart.setLayoutX(50);
        formulaStart.setLayoutY(600);
        formulaStart.setText("150 * 2 * ");
        formulaStart.setStyle(textFormat);

        Text formulaEnd = new Text();
        formulaEnd.setLayoutX(200);
        formulaEnd.setLayoutY(600);
        formulaEnd.setText(" * 2,6");
        formulaEnd.setStyle(textFormat);

        TextField distance = new TextField();
        distance.setPrefWidth(70);
        distance.setPrefHeight(25);
        distance.setLayoutX(130);
        distance.setLayoutY(580);

        Line divisionLine = new Line(50, 610, 250, 610);

        Text divisionValue = new Text();
        divisionValue.setLayoutX(130);
        divisionValue.setLayoutY(630);
        divisionValue.setText("10000");
        divisionValue.setStyle(textFormat);

        Text calculateResult = new Text();
        calculateResult.setLayoutX(250);
        calculateResult.setLayoutY(616);
        calculateResult.setText(" = ");
        calculateResult.setStyle(textFormat);

        Button calculatePump = new Button();
        calculatePump.setPrefWidth(100);
        calculatePump.setPrefHeight(25);
        calculatePump.setLayoutX(450);
        calculatePump.setLayoutY(595);
        calculatePump.setText("Роз. напір");

        Text resultOfMeasurement = new Text();
        resultOfMeasurement.setLayoutX(280);
        resultOfMeasurement.setLayoutY(616);
        resultOfMeasurement.setText("");
        resultOfMeasurement.setStyle(format);

        Button pressureInfo = new Button();
        pressureInfo.setPrefWidth(25);
        pressureInfo.setPrefHeight(25);
        pressureInfo.setLayoutX(560);
        pressureInfo.setLayoutY(595);
        pressureInfo.setText("?");

        TextField consumption = new TextField();
        consumption.setPrefWidth(70);
        consumption.setPrefHeight(25);
        consumption.setLayoutX(50);
        consumption.setLayoutY(680);

        Text consumptionConst = new Text();
        consumptionConst.setLayoutX(125);
        consumptionConst.setLayoutY(700);
        consumptionConst.setText(" * 4,3");
        consumptionConst.setStyle(textFormat);

        Text equalSign = new Text();
        equalSign.setLayoutX(170);
        equalSign.setLayoutY(700);
        equalSign.setText(" = ");
        equalSign.setStyle(textFormat);

        Button calculateConsumption = new Button();
        calculateConsumption.setPrefWidth(100);
        calculateConsumption.setPrefHeight(25);
        calculateConsumption.setLayoutX(450);
        calculateConsumption.setLayoutY(680);
        calculateConsumption.setText("Роз. витрату");

        Text resultOfConsumption = new Text();
        resultOfConsumption.setLayoutX(195);
        resultOfConsumption.setLayoutY(700);
        resultOfConsumption.setText("");
        resultOfConsumption.setStyle(format);

        Button consumptionInfo = new Button();
        consumptionInfo.setPrefWidth(25);
        consumptionInfo.setPrefHeight(25);
        consumptionInfo.setLayoutX(560);
        consumptionInfo.setLayoutY(680);
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
        saveButton.setLayoutX(700);
        saveButton.setLayoutY(300);

        saveButton.setOnAction(event -> {
            String buyer = input.getText();
            String goodName1 = inputGood1.getText();
            String goodCountField1 = inputGoodCount1.getText();
            String invoiceText = invoice.getText();

            double goodPriceWithTax = Double.parseDouble(inputGoodPrice1.getText());
            double singlePriceWithoutTax = goodPriceWithTax * 5 / 6;
            double fullPriceWithoutTax = Double.parseDouble(goodCountField1) * singlePriceWithoutTax;
            double tax = goodPriceWithTax * Double.parseDouble(goodCountField1) - fullPriceWithoutTax;

            String singlePriceWithout = new DecimalFormat("##.##").format(singlePriceWithoutTax);
            String fullPriceWithoutTaxing = new DecimalFormat("##.##").format(fullPriceWithoutTax);
            String stringTax = new DecimalFormat("##.##").format(tax);
            String fullPriceBottom = new DecimalFormat("##.##").format(fullPriceWithoutTax);
            double totalPrice = tax + fullPriceWithoutTax;
            String total = new DecimalFormat("##.##").format(totalPrice);


            saveToWordWithPlaceholder(buyer, invoiceText, goodName1, goodCountField1, singlePriceWithout, fullPriceWithoutTaxing, stringTax, fullPriceBottom, total);
        });

        root.getChildren()
                .addAll( focus, input, inputGood1, good1, inputGoodCount1, goodCount1, inputGoodPrice1, goodPrice1,
                        goodTitle,
                        measurements, formulaStart, formulaEnd, distance, divisionLine, divisionValue,
                        calculateResult, calculatePump, resultOfMeasurement, pressureInfo, consumption, consumptionConst,
                        equalSign, calculateConsumption, resultOfConsumption, consumptionInfo, saveButton,
                        invoice, invoiceTitle,

                        good2, inputGood2, inputGoodCount2, inputGoodPrice2,
                        good3, inputGood3, inputGoodCount3, inputGoodPrice3);
        stage.setScene(scene);
        stage.show();
    }

    private void saveToWordWithPlaceholder(String buyer, String invoiceNumber, String goodName, String count, String singlePrice, String fullPrice, String tax, String fullPriceBottom, String total) {
        try (InputStream templateInputStream = getClass().getClassLoader().getResourceAsStream("target.docx");
             XWPFDocument document = new XWPFDocument(templateInputStream);
             FileOutputStream out = new FileOutputStream("output.docx")) {

            Map<String, String> replacements = new HashMap<>();
            replacements.put("{{buyer}}", buyer);
            replacements.put("{{invoice}}", invoiceNumber);
            replacements.put("{{goodName}}", goodName);
            replacements.put("{{count}}", count);
            replacements.put("{{singlePrice}}", singlePrice);
            replacements.put("{{fullPrice}}", fullPrice);
            replacements.put("{{tax}}", tax);
            replacements.put("{{fullPriceBottom}}", fullPriceBottom);
            replacements.put("{{total}}", total);
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