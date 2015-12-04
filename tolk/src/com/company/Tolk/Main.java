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
    public String sisendT = "abc";
    public int vot = 1;


    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vbox = new VBox();
        Scene loginScene = new Scene(vbox);
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("SalaKirjutusMasin");
        primaryStage.show();

        Label sisendTekst = new Label("Sisesta tekst");
        TextField kasutajaSisend = new TextField();
        Button krypt = new Button("Krypteeri");
        Label votmeLabel = new Label("Sisesta krypteerimise voti numbrites");
        PasswordField votmeSisend = new PasswordField();
        Label teade = new Label();

        vbox.getChildren().addAll(sisendTekst, kasutajaSisend, votmeLabel, votmeSisend, krypt, teade);

        krypt.setOnAction(event -> {
            int kryptVoti = 0;

            String sisse = kasutajaSisend.getText();  /*Tahaks siit saada need v‰‰rtused ja kasutada neid Edasi klassis*/
            String voti = votmeSisend.getText();
            try {
                kryptVoti = Integer.parseInt(voti);
            } catch (Exception e) {
                teade.setText("Sisesta krypteerimise voti numbrites");
            }
            sisendT = sisse;
            vot = kryptVoti;
            Edasi k = new Edasi();
            k.ed();
            String v = k.ed();
            teade.setText(String.valueOf(v));


        });
    }

    public int KVoti(){
        int v = vot;
        return v;

    }
    public String Jutt(){
        String j = sisendT;
        return j;
    }

}
