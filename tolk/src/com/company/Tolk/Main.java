package com.company.Tolk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vbox = new VBox();
        Scene loginScene = new Scene(vbox);
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("SalaKirjutusMasin");
        primaryStage.show();

        Label sisendTekst = new Label("Sisesta tekst");
        TextField kasutajaSisend = new TextField();
        Label valjundTekst = new Label("Vastus");
        TextField valjund = new TextField();
        Label votmeLabel = new Label("Sisesta krypteerimise voti numbrites");
        PasswordField votmeSisend = new PasswordField();
        ToggleGroup grupp = new ToggleGroup();
        ToggleButton krypteeri = new ToggleButton("Krypteeri    ");
        ToggleButton dekrypteeri = new ToggleButton("Dekrypteeri");
        ToggleButton info = new ToggleButton("   Info   ");
        ToggleButton exit = new ToggleButton("Exit");
        krypteeri.setToggleGroup(grupp);
        dekrypteeri.setToggleGroup(grupp);
        exit.setToggleGroup(grupp);
        info.setToggleGroup(grupp);
        Label teade = new Label();
        /*TextArea*/

        vbox.getChildren().addAll(votmeLabel, votmeSisend, sisendTekst, kasutajaSisend, valjundTekst, valjund, krypteeri, dekrypteeri, info,  exit,teade);

        krypteeri.setOnAction(event -> {
            int kryptVoti = 0;

            String sisse = kasutajaSisend.getText();  /*Tahaks siit saada need väärtused ja kasutada neid Edasi klassis*/
            String voti = votmeSisend.getText();
            try {
                kryptVoti = Integer.parseInt(voti);
            } catch (Exception e) {
                teade.setText("Sisesta krypteerimise voti numbrites");
            }

            Edasi k = new Edasi();
            k.ed();
            String vastus = k.ed();
            valjund.setText(vastus);


        });
        dekrypteeri.setOnAction(event -> {
            int kryptVoti = 0;

            String sisse = kasutajaSisend.getText();  /*Tahaks siit saada need väärtused ja kasutada neid Edasi klassis*/
            String voti = votmeSisend.getText();
            try {
                kryptVoti = Integer.parseInt(voti);
            } catch (Exception e) {
                teade.setText("Sisesta krypteerimise voti numbrites");
            }

            Tagasi t = new Tagasi();
            t.tag();
            String vastuTagasi = t.tag();
            valjund.setText(vastuTagasi);


        });
        info.setOnAction(event -> {
            teade.setText("Siia tuleb info programmi kohta ja kasutusjuhend");
        });
        exit.setOnAction(event -> {
            System.exit(0);
        });
    }


}
