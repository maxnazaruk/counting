package com.example.counting;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.poi.xwpf.usermodel.*;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

public class HelloApplication extends Application {

    private static final String TEMPLATE_PATH = "/Doc1.docx";
    private static final String format = "-fx-font-weight: bold; -fx-font-size: 20";
    private static final String redFormat = "-fx-font-weight: bold; -fx-font-size: 20; -fx-fill: red;";
    private static final String greenFormat = "-fx-font-weight: bold; -fx-font-size: 20; -fx-fill: green;";
    private static final String adFormat = "-fx-font-size: 16; -fx-fill: green;";
    private static final String textFormat = "-fx-font-size: 20";

    private static String goodName2;
    private static String goodCountField2;
    private static String singlePriceWithout2;
    private static String fullPriceWithoutTaxing2;
    private static double fullPriceWithTax2;

    private static String goodName1;
    private static String goodCountField1;
    private static String singlePriceWithout;
    private static String fullPriceWithoutTaxing;

    private static double fullPriceWithTax1;

    private static String goodName3;
    private static String goodCountField3;
    private static String singlePriceWithout3;
    private static String fullPriceWithoutTaxing3;
    private static double fullPriceWithTax3;

    private static String goodName4;
    private static String goodCountField4;
    private static String singlePriceWithout4;
    private static String fullPriceWithoutTaxing4;
    private static double fullPriceWithTax4;

    private static String goodName5;
    private static String goodCountField5;
    private static String singlePriceWithout5;
    private static String fullPriceWithoutTaxing5;
    private static double fullPriceWithTax5;

    private static String goodName6;
    private static String goodCountField6;
    private static String singlePriceWithout6;
    private static String fullPriceWithoutTaxing6;
    private static double fullPriceWithTax6;

    private static double totalPriceWithoutTax = 0;

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
        //----------------------------------------------------------------------------------------
        Text good4 = new Text();
        good4.setLayoutX(75);
        good4.setLayoutY(172.5 + 35);
        good4.setText("№4:");

        TextField inputGood4 = new TextField();
        inputGood4.setPrefWidth(350);
        inputGood4.setPrefHeight(25);
        inputGood4.setLayoutX(100);
        inputGood4.setLayoutY(155 + 35);
        inputGood4.setPromptText("Найменування товару");

        TextField inputGoodCount4 = new TextField();
        inputGoodCount4.setPrefWidth(55);
        inputGoodCount4.setPrefHeight(25);
        inputGoodCount4.setLayoutX(480);
        inputGoodCount4.setLayoutY(155 + 35);
        inputGoodCount4.setPromptText("Кіл-сть");

        TextField inputGoodPrice4 = new TextField();
        inputGoodPrice4.setPrefWidth(110);
        inputGoodPrice4.setPrefHeight(25);
        inputGoodPrice4.setLayoutX(550);
        inputGoodPrice4.setLayoutY(155 + 35);
        inputGoodPrice4.setPromptText("Вартість з ПДВ");
        //----------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------
        Text good5 = new Text();
        good5.setLayoutX(75);
        good5.setLayoutY(172.5 + 35 * 2);
        good5.setText("№5:");

        TextField inputGood5 = new TextField();
        inputGood5.setPrefWidth(350);
        inputGood5.setPrefHeight(25);
        inputGood5.setLayoutX(100);
        inputGood5.setLayoutY(155 + 35 * 2);
        inputGood5.setPromptText("Найменування товару");

        TextField inputGoodCount5 = new TextField();
        inputGoodCount5.setPrefWidth(55);
        inputGoodCount5.setPrefHeight(25);
        inputGoodCount5.setLayoutX(480);
        inputGoodCount5.setLayoutY(155 + 35 * 2);
        inputGoodCount5.setPromptText("Кіл-сть");

        TextField inputGoodPrice5 = new TextField();
        inputGoodPrice5.setPrefWidth(110);
        inputGoodPrice5.setPrefHeight(25);
        inputGoodPrice5.setLayoutX(550);
        inputGoodPrice5.setLayoutY(155 + 35 * 2);
        inputGoodPrice5.setPromptText("Вартість з ПДВ");
        //----------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------
        Text good6 = new Text();
        good6.setLayoutX(75);
        good6.setLayoutY(172.5 + 35 * 3);
        good6.setText("№6:");

        TextField inputGood6 = new TextField();
        inputGood6.setPrefWidth(350);
        inputGood6.setPrefHeight(25);
        inputGood6.setLayoutX(100);
        inputGood6.setLayoutY(155 + 35 * 3);
        inputGood6.setPromptText("Найменування товару");

        TextField inputGoodCount6 = new TextField();
        inputGoodCount6.setPrefWidth(55);
        inputGoodCount6.setPrefHeight(25);
        inputGoodCount6.setLayoutX(480);
        inputGoodCount6.setLayoutY(155 + 35 * 3);
        inputGoodCount6.setPromptText("Кіл-сть");

        TextField inputGoodPrice6 = new TextField();
        inputGoodPrice6.setPrefWidth(110);
        inputGoodPrice6.setPrefHeight(25);
        inputGoodPrice6.setLayoutX(550);
        inputGoodPrice6.setLayoutY(155 + 35 * 3);
        inputGoodPrice6.setPromptText("Вартість з ПДВ");
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
                resultOfMeasurement.setText(result + " м");
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
            String invoiceText = invoice.getText();

            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            //--------------------------------------------------------------------------------------
            goodName1 = inputGood1.getText();
            goodCountField1 = inputGoodCount1.getText();
            double goodPriceWithTax = Double.parseDouble(inputGoodPrice1.getText());
            double singlePriceWithoutTax = goodPriceWithTax * 5 / 6;
            double fullPriceWithoutTax = Double.parseDouble(goodCountField1) * singlePriceWithoutTax;

            singlePriceWithout = String.format("%.2f", singlePriceWithoutTax);
            fullPriceWithoutTaxing = String.format("%.2f", fullPriceWithoutTax);
            fullPriceWithTax1 = Double.parseDouble(goodCountField1) * goodPriceWithTax;
            //--------------------------------------------------------------------------------------
            try {
                goodName2 = inputGood2.getText();
                goodCountField2 = inputGoodCount2.getText();
                double goodPriceWithTax2 = Double.parseDouble(inputGoodPrice2.getText());
                double singlePriceWithoutTax2 = goodPriceWithTax2 * 5 / 6;
                double fullPriceWithoutTax2 = Double.parseDouble(goodCountField2) * singlePriceWithoutTax2;

                singlePriceWithout2 = String.format("%.2f", singlePriceWithoutTax2);
                fullPriceWithoutTaxing2 = String.format("%.2f", fullPriceWithoutTax2);
                fullPriceWithTax2 = Double.parseDouble(goodCountField2) * goodPriceWithTax2;
            }catch (NumberFormatException ex){
                goodName2 = "";
                goodCountField2 = "";
                double goodPriceWithTax2 = 0;
                double singlePriceWithoutTax2 = 0;
                double fullPriceWithoutTax2 = 0;

                singlePriceWithout2 = "";
                fullPriceWithoutTaxing2 = "";
                fullPriceWithTax2 = 0;
            }
            //--------------------------------------------------------------------------------------
            //--------------------------------------------------------------------------------------
            try {
                goodName3 = inputGood3.getText();
                goodCountField3 = inputGoodCount3.getText();
                double goodPriceWithTax3 = Double.parseDouble(inputGoodPrice3.getText());
                double singlePriceWithoutTax3 = goodPriceWithTax3 * 5 / 6;
                double fullPriceWithoutTax3 = Double.parseDouble(goodCountField3) * singlePriceWithoutTax3;

                singlePriceWithout3 = String.format("%.2f", singlePriceWithoutTax3);
                fullPriceWithoutTaxing3 = String.format("%.2f", fullPriceWithoutTax3);
                fullPriceWithTax3 = Double.parseDouble(goodCountField3) * goodPriceWithTax3;
            }catch (NumberFormatException ex){
                goodName3 = "";
                goodCountField3 = "";
                double goodPriceWithTax3 = 0;
                double singlePriceWithoutTax3 = 0;
                double fullPriceWithoutTax3 = 0;

                singlePriceWithout3 = "";
                fullPriceWithoutTaxing3 = "";
                fullPriceWithTax3 = 0;
            }
            //--------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            try {
                goodName4 = inputGood4.getText();
                goodCountField4 = inputGoodCount4.getText();
                double goodPriceWithTax4 = Double.parseDouble(inputGoodPrice4.getText());
                double singlePriceWithoutTax4 = goodPriceWithTax4 * 5 / 6;
                double fullPriceWithoutTax4 = Double.parseDouble(goodCountField4) * singlePriceWithoutTax4;

                singlePriceWithout4 = String.format("%.2f", singlePriceWithoutTax4);
                fullPriceWithoutTaxing4 = String.format("%.2f", fullPriceWithoutTax4);
                fullPriceWithTax4 = Double.parseDouble(goodCountField4) * goodPriceWithTax4;
            }catch (NumberFormatException ex){
                goodName4 = "";
                goodCountField4 = "";
                double goodPriceWithTax4 = 0;
                double singlePriceWithoutTax4 = 0;
                double fullPriceWithoutTax4 = 0;

                singlePriceWithout4 = "";
                fullPriceWithoutTaxing4 = "";
                fullPriceWithTax4 = 0;
            }
            //--------------------------------------------------------------------------------------
            //--------------------------------------------------------------------------------------
            try {
                goodName5 = inputGood5.getText();
                goodCountField5 = inputGoodCount5.getText();
                double goodPriceWithTax5 = Double.parseDouble(inputGoodPrice5.getText());
                double singlePriceWithoutTax5 = goodPriceWithTax5 * 5 / 6;
                double fullPriceWithoutTax5 = Double.parseDouble(goodCountField5) * singlePriceWithoutTax5;

                singlePriceWithout5 = String.format("%.2f", singlePriceWithoutTax5);
                fullPriceWithoutTaxing5 = String.format("%.2f", fullPriceWithoutTax5);
                fullPriceWithTax5 = Double.parseDouble(goodCountField5) * goodPriceWithTax5;
            }catch (NumberFormatException ex){
                goodName5 = "";
                goodCountField5 = "";
                double goodPriceWithTax5 = 0;
                double singlePriceWithoutTax5 = 0;
                double fullPriceWithoutTax5 = 0;

                singlePriceWithout5 = "";
                fullPriceWithoutTaxing5 = "";
                fullPriceWithTax5 = 0;
            }
            //--------------------------------------------------------------------------------------
            //--------------------------------------------------------------------------------------
            try {
                goodName6 = inputGood6.getText();
                goodCountField6 = inputGoodCount6.getText();
                double goodPriceWithTax6 = Double.parseDouble(inputGoodPrice6.getText());
                double singlePriceWithoutTax6 = goodPriceWithTax6 * 5 / 6;
                double fullPriceWithoutTax6 = Double.parseDouble(goodCountField6) * singlePriceWithoutTax6;

                singlePriceWithout6 = String.format("%.2f", singlePriceWithoutTax6);
                fullPriceWithoutTaxing6 = String.format("%.2f", fullPriceWithoutTax6);
                fullPriceWithTax6 = Double.parseDouble(goodCountField6) * goodPriceWithTax6;
            }catch (NumberFormatException ex){
                goodName6 = "";
                goodCountField6 = "";
                double goodPriceWithTax6 = 0;
                double singlePriceWithoutTax6 = 0;
                double fullPriceWithoutTax6 = 0;

                singlePriceWithout6 = "";
                fullPriceWithoutTaxing6 = "";
                fullPriceWithTax6 = 0;
            }
            //--------------------------------------------------------------------------------------
            //double totalPrice = tax + fullPriceWithoutTax;
            List<String> fullList = Arrays.asList(fullPriceWithoutTaxing, fullPriceWithoutTaxing2, fullPriceWithoutTaxing3, fullPriceWithoutTaxing4, fullPriceWithoutTaxing5, fullPriceWithoutTaxing6);
            for (String s : fullList) {
                try{
                    if(s.equals("")){
                        continue;
                    }
                    totalPriceWithoutTax += Double.parseDouble(s.replaceAll(",","\\."));
                }catch (Exception ex){
                    continue;
                }
            }

            List<Double> fullWithTaxList = Arrays.asList(fullPriceWithTax1, fullPriceWithTax2, fullPriceWithTax3, fullPriceWithTax4, fullPriceWithTax5, fullPriceWithTax6);
            double totalPriceWithTax = 0;
            for (Double v : fullWithTaxList) {
                totalPriceWithTax += v;
            }

            List<String> names = Arrays.asList(goodName1, goodName2, goodName3, goodName4, goodName5, goodName6);
            Integer number = 0;
            for (String name : names) {
                if(!name.equals("")){
                    number++;
                }
            }
            String fullPriceBottom = String.format("%.2f", totalPriceWithoutTax);
            String stringTax = String.format("%.2f",totalPriceWithTax - totalPriceWithoutTax);
           String total = String.format("%.2f", totalPriceWithTax);
           String totalDuplicate = String.format("%.2f", totalPriceWithTax);
           Double tax1 = totalPriceWithTax - totalPriceWithoutTax;

            long beforeDecimal = (long)(totalPriceWithTax - totalPriceWithoutTax);  // Cast to long to remove decimal part
            long afterDecimal = Math.round((totalPriceWithTax - totalPriceWithoutTax - beforeDecimal) * 100);

            String fullTaxDuplication = Long.toString(beforeDecimal);
            String coins = Long.toString(afterDecimal);

            int currentYear = LocalDate.now().getYear();

            LocalDate currentDate = LocalDate.now();

            // Get the current day of the month
            int dayOfMonth = currentDate.getDayOfMonth();

            // Get the current month
            Month month = currentDate.getMonth();

            // Specify the desired locale (Ukrainian in this case)
            Locale ukrainianLocale = new Locale("uk", "UA");

            // Format the month name using the specified locale
            String monthNameInUkrainian = month.getDisplayName(TextStyle.FULL, ukrainianLocale);

            String date = Integer.toString(dayOfMonth) +" "+ monthNameInUkrainian;

            Map<String, String> replacements = new HashMap<>();
            replacements.put("{{buyer}}", buyer);
            replacements.put("{{invoice}}", invoiceText);

            replacements.put("{{goodName}}", goodName1);
            replacements.put("{{count}}", goodCountField1);
            replacements.put("{{check}}", singlePriceWithout);
            replacements.put("{{cost}}", fullPriceWithoutTaxing);

            replacements.put("{{goodName2}}", goodName2);
            replacements.put("{{count2}}", goodCountField2);
            replacements.put("{{singlePrice2}}", singlePriceWithout2);
            replacements.put("{{fullPrice2}}", fullPriceWithoutTaxing2);

            replacements.put("{{goodName3}}", goodName3);
            replacements.put("{{count3}}", goodCountField3);
            replacements.put("{{singlePrice3}}", singlePriceWithout3);
            replacements.put("{{fullPrice3}}", fullPriceWithoutTaxing3);

            replacements.put("{{goodName4}}", goodName4);
            replacements.put("{{count4}}", goodCountField4);
            replacements.put("{{singlePrice4}}", singlePriceWithout4);
            replacements.put("{{fullPrice4}}", fullPriceWithoutTaxing4);

            replacements.put("{{goodName5}}", goodName5);
            replacements.put("{{count5}}", goodCountField5);
            replacements.put("{{singlePrice5}}", singlePriceWithout5);
            replacements.put("{{fullPrice5}}", fullPriceWithoutTaxing5);

            replacements.put("{{goodName6}}", goodName6);
            replacements.put("{{count6}}", goodCountField6);
            replacements.put("{{singlePrice6}}", singlePriceWithout6);
            replacements.put("{{fullPrice6}}", fullPriceWithoutTaxing6);

            replacements.put("{{tax}}", stringTax);
            replacements.put("{{fullPriceBottom}}", fullPriceBottom);
            replacements.put("{{total}}", total);
            replacements.put("{{itemCount}}", number.toString());
            replacements.put("{{totalDuplicate}}", totalDuplicate);
            replacements.put("{{taxDuplicate}}", fullTaxDuplication);
            replacements.put("{{taxDuplicateCoins}}", coins);
            replacements.put("{{year}}", Integer.toString(currentYear));
            replacements.put("{{dayAndMonth}}", date);

            saveToWordWithPlaceholder(replacements);
        });

        root.getChildren()
                .addAll(focus, input, inputGood1, good1, inputGoodCount1, goodCount1, inputGoodPrice1, goodPrice1,
                        goodTitle,
                        measurements, formulaStart, formulaEnd, distance, divisionLine, divisionValue,
                        calculateResult, calculatePump, resultOfMeasurement, pressureInfo, consumption, consumptionConst,
                        equalSign, calculateConsumption, resultOfConsumption, consumptionInfo, saveButton,
                        invoice, invoiceTitle,

                        good2, inputGood2, inputGoodCount2, inputGoodPrice2,
                        good3, inputGood3, inputGoodCount3, inputGoodPrice3,
                        good4, inputGood4, inputGoodCount4, inputGoodPrice4,
                        good5, inputGood5, inputGoodCount5, inputGoodPrice5,
                        good6, inputGood6, inputGoodCount6, inputGoodPrice6
                        );
        stage.setScene(scene);
        stage.show();
    }

    private void saveToWordWithPlaceholder(Map<String, String> replacements) {
        try (InputStream templateInputStream = getClass().getClassLoader().getResourceAsStream("target.docx");
             XWPFDocument document = new XWPFDocument(templateInputStream);
             FileOutputStream out = new FileOutputStream("output.docx")) {

            //comment
            replacePlaceholdersInTable(document, replacements);

            document.write(out);
            System.out.println("Word document created successfully with multiple replacements.");

                Desktop.getDesktop().open(new File("output.docx"));
            // Open the saved Word document

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