package com.company.Tolk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main extends Application {
    String salvestis = "";
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
        ToggleButton krypteeri = new ToggleButton("     Krypteeri     ");
        ToggleButton dekrypteeri = new ToggleButton("   Dekrypteeri   ");
        ToggleButton save = new ToggleButton("        Save         ");
        ToggleButton info = new ToggleButton("         Info          ");
        ToggleButton exit = new ToggleButton("         Exit          ");
        ToggleButton puhasta = new ToggleButton(" Puhasta valjad ");
        krypteeri.setToggleGroup(grupp);
        dekrypteeri.setToggleGroup(grupp);
        exit.setToggleGroup(grupp);
        puhasta.setToggleGroup(grupp);
        info.setToggleGroup(grupp);
        save.setToggleGroup(grupp);
        Label teade = new Label();

        vbox.getChildren().addAll(votmeLabel, votmeSisend, sisendTekst, kasutajaSisend, valjundTekst, valjund, krypteeri, dekrypteeri, save, puhasta,  info, exit, teade);

        krypteeri.setOnAction(event -> {
            int kryptVoti = 0;
            String sisse = kasutajaSisend.getText();
            String voti = votmeSisend.getText();
            try {
                kryptVoti = Integer.parseInt(voti);
            } catch (Exception e) {
                teade.setText("Sisesta krypteerimise voti numbrites");
            }
            int vot = kryptVoti;
            String siss = sisse;
            System.out.println(vot);
            System.out.println(siss);
            Edasi k = new Edasi(vot, siss);
            k.ed();
            String vastus = k.ed();
            valjund.setText(vastus);
            salvestis = vastus;
        });
        dekrypteeri.setOnAction(event -> {
            int kryptVoti = 0;
            String sisse = kasutajaSisend.getText();
            String voti = votmeSisend.getText();
            try {
                kryptVoti = Integer.parseInt(voti);
            } catch (Exception e) {
                teade.setText("Sisesta krypteerimise voti numbrites");
            }
            int vot = kryptVoti;
            String siss = sisse;
            System.out.println(vot);
            System.out.println(siss);
            Tagasi t = new Tagasi(vot, siss);
            t.tag();
            String vastuTagasi = t.tag();
            valjund.setText(vastuTagasi);
        });
        save.setOnAction(event -> {

            try
            {
                File file = new File("SKM");
                FileWriter fw = new FileWriter( file.getAbsoluteFile( ) );
                BufferedWriter bw = new BufferedWriter( fw );
                bw.write(salvestis);
                bw.close( );
                teade.setText("Salvestatud: " + (file.getAbsolutePath()));
            }
            catch( IOException e )
            {
                System.out.println("Error: " + e);
                e.printStackTrace( );
                teade.setText("Errrrrrrr");
            }

        });
        puhasta.setOnAction(event -> {
            teade.setText("");
            valjund.setText("");
            votmeSisend.setText("");
            kasutajaSisend.setText("");
        });
        info.setOnAction(event -> {
            teade.setText("Siia tuleb info programmi kohta ja kasutusjuhend");
        });
        exit.setOnAction(event -> {
            System.exit(0);
        });

    }


}
