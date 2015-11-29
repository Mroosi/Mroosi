package com.company.Tolk;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int p = 0;
        while (p <= 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println( );
            System.out.println("Kas tahad teksti krypteerida v6i dekrypteerida?");
            System.out.println("Krypteerimiseks vajuta K ja dekrypteerimiseks D");
            System.out.println("V2ljumiseks E");
            String vastus = sc.nextLine();
            String v = vastus.toUpperCase();
            if (v.equals("K")) {
                Edasi e = new Edasi();
                e.ed();
            } else if (v.equals("D")) {
                Tagasi t = new Tagasi();
                t.tag();
            } else if (v.equals("E")) {
                p = p++;
                System.exit(0);
            } else {
                System.out.println("K v D v E?");
            }


        }
    }
}