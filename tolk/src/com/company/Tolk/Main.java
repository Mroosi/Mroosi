package com.company.Tolk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            VBox vbox = new VBox();
            Scene loginScene = new Scene(vbox);
            primaryStage.setScene(loginScene);
            primaryStage.setTitle("ProjektTolk");
            primaryStage.show();

            Label tekstSiia = new Label("Sisesta siia oma tekst.");
            TextField textField = new TextField();
            Label votmeKoht = new Label("Sisesta siia krypteerimise/dekrypteerimise voti");
            PasswordField votmeisend = new PasswordField();
            Button krypt = new Button("Krypteeri");
            Label teade = new Label();
            teade.setText("Sisesta siia oma tekst! Tahelepanu ara sisesta teksti tapitahti ja symboleid." +
                    "Kirjavahemarkidest saab kasutada: !.?,;:. Katsu nendega hakkama saada!");


            vbox.getChildren().addAll(tekstSiia, textField, votmeKoht, votmeisend, krypt, teade);
            String sisendTekst = textField.getText();
            String voti = votmeisend.getText();

            krypt.setOnAction(event -> {
                Edasi e = new Edasi();
                e.ed();
                String v = e.ed();
                System.out.println(v);

            });

        }



}
