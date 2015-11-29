package com.company.Tolk;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Madis on 21.11.2015.
 */
public class Tagasi {
    public void tag() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sisesta siia oma tekst! Tahelepanu ara sisesta teksti tapitahti ja symboleid");
        System.out.println("Kirjavahemarkidest saab kasutada: !.?,;:. Katsu nendega hakkama saada!");
        String tekst = sc.nextLine();
        HashMap<String, String> t2hestik = new HashMap<String, String>();
        t2hestik.put("P", "A");
        t2hestik.put("C", "B");
        t2hestik.put("Q", "C");
        t2hestik.put("K", "D");
        t2hestik.put("V", "E");
        t2hestik.put("E", "F");
        t2hestik.put("S", "G");
        t2hestik.put("Y", "H");
        t2hestik.put("R", "I");
        t2hestik.put("I", "J");
        t2hestik.put("B", "K");
        t2hestik.put("T", "L");
        t2hestik.put("Z", "M");
        t2hestik.put("U", "N");
        t2hestik.put("@", "O");
        t2hestik.put("G", "P");
        t2hestik.put("J", "R");
        t2hestik.put("F", "S");
        t2hestik.put("W", "Z");
        t2hestik.put("X", "T");
        t2hestik.put("N", "U");
        t2hestik.put("L", "V");
        t2hestik.put("A", "W");
        t2hestik.put("M", "X");
        t2hestik.put("H", "Y");
        t2hestik.put("D", "Q");
        t2hestik.put("O", " ");
        t2hestik.put("=", "1");
        t2hestik.put("(", "2");
        t2hestik.put("*", "3");
        t2hestik.put("/", "4");
        t2hestik.put("&", "5");
        t2hestik.put(")", "6");
        t2hestik.put("_", "7");
        t2hestik.put("}", "8");
        t2hestik.put("}", "9");
        t2hestik.put("%", "0");
        t2hestik.put(".", ".");
        t2hestik.put("!", "!");
        t2hestik.put("?", "?");
        t2hestik.put(",", ",");
        t2hestik.put(";", ";");
        t2hestik.put(":", ":");
        for (int index = 0; index < tekst.length(); index++) {
            char m = tekst.charAt(index);
            String t = Character.toString(m);
            String su = t.toUpperCase();
            String g = t2hestik.get(su);
            System.out.print(g);

        }
    }

}
