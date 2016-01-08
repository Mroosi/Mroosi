package com.company.Tolk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;



public class Main extends Application {
    String salvestis;
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vbox = new VBox();
        Scene SalaKirjutusMasin = new Scene(vbox, 600, 400);
        primaryStage.setScene(SalaKirjutusMasin);
        primaryStage.setTitle("SalaKirjutusMasin");
        primaryStage.show();

        Label sisendTekst = new Label("Sisesta tekst");
        TextField kasutajaSisend = new TextField();
        Label valjundTekst = new Label("Vastus");
        TextField valjund = new TextField();
        Label votmeLabel = new Label("Sisesta krypteerimise voti numbrites");
        PasswordField votmeSisend = new PasswordField();
        ToggleGroup grupp = new ToggleGroup();
        ToggleButton krypteeri = new ToggleButton("Krypteeri");
        krypteeri.setPrefWidth(100.0);
        ToggleButton dekrypteeri = new ToggleButton("Dekrypteeri");
        dekrypteeri.setPrefWidth(100.0);
        ToggleButton salvesta = new ToggleButton("Save");
        salvesta.setPrefWidth(100.0);
        ToggleButton info = new ToggleButton("Info");
        info.setPrefWidth(100.0);
        ToggleButton exit = new ToggleButton("Exit");
        exit.setPrefWidth(100.0);
        ToggleButton puhastaValjad = new ToggleButton("Puhasta valjad");
        puhastaValjad.setPrefWidth(100.0);

        krypteeri.setToggleGroup(grupp);
        dekrypteeri.setToggleGroup(grupp);
        exit.setToggleGroup(grupp);
        puhastaValjad.setToggleGroup(grupp);
        info.setToggleGroup(grupp);
        salvesta.setToggleGroup(grupp);
        Label teade = new Label();
        Label teineTeade = new Label();
        Label kolmasTeade = new Label();
        vbox.getChildren().addAll(votmeLabel, votmeSisend, sisendTekst, kasutajaSisend, valjundTekst, valjund, krypteeri,
                dekrypteeri, salvesta, puhastaValjad,  info, exit, teade, teineTeade, kolmasTeade);

        krypteeri.setOnAction(event -> {
            teade.setText("");
            teineTeade.setText("");
            kolmasTeade.setText("");
            int kryptVoti = 0;
            String tekstSisse = kasutajaSisend.getText();
            String voti = votmeSisend.getText();
            try {
                kryptVoti = Integer.parseInt(voti);
            } catch (Exception e) {
                teade.setText("Sisesta krypteerimise voti numbrites");
            }
            int vot = kryptVoti;
            Krypteeri k = new Krypteeri(vot, tekstSisse);
            k.krypteeri();
            String kryptVastus = k.krypteeri();
            valjund.setText(kryptVastus);
            salvestis = kryptVastus;
        });
        dekrypteeri.setOnAction(event -> {
            teade.setText("");
            teineTeade.setText("");
            kolmasTeade.setText("");
            int kryptVoti = 0;
            String tekstSisse = kasutajaSisend.getText();
            String voti = votmeSisend.getText();
            try {
                kryptVoti = Integer.parseInt(voti);
            } catch (Exception e) {
                teade.setText("Sisesta krypteerimise voti numbrites");
            }
            int vot = kryptVoti;
            Dekrypteeri d = new Dekrypteeri(vot, tekstSisse);
            d.dekrypteeri();
            String dekryptVastus = d.dekrypteeri();
            valjund.setText(dekryptVastus);
            salvestis = dekryptVastus;
        });
        salvesta.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("(*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            fileChooser.setTitle("Salvesta");
            fileChooser.setInitialFileName("Nimetu");
            File salvestaja = fileChooser.showSaveDialog(primaryStage);
            if (salvestaja != null) {
                try {
                    FileWriter fw = new FileWriter(salvestaja.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(this.salvestis);
                    bw.close();
                    teade.setText("Salvestatud: " + (salvestaja.getAbsolutePath()));
                } catch (IOException e) {
                    System.out.println("Error: " + e);
                    teade.setText("Errrrrrrr");
                }
            } else {
                teade.setText("Salvestamine katkestatud");
            }
        });
        puhastaValjad.setOnAction(event -> {
            teade.setText("");
            valjund.setText("");
            votmeSisend.setText("");
            kasutajaSisend.setText("");
            teineTeade.setText("");
            kolmasTeade.setText("");
        });
        info.setOnAction(event -> {
            teade.setText("SalaKirjutusMasin krypteerib ja dekrypteerib etteantud teksti vastavalt sisestatud votmele. Saadud tulemus");
            teineTeade.setText("kuvatakse vastuse lahtrisse ning tulemust on voimalik ka salvestada.");
            kolmasTeade.setText("A:Mroosi-2015");
        });
        exit.setOnAction(event -> System.exit(0));
    }


}
