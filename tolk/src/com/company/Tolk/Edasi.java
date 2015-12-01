package com.company.Tolk;

import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Madis on 21.11.2015.
 */
public class Edasi {

    public String ed() {
        String tekst = ("sisendTekst");
        String vastus = "";
        HashMap<String, String> t2hestik = new HashMap<String, String>();
        t2hestik.put("A", "P");
        t2hestik.put("B", "C");
        t2hestik.put("C", "Q");
        t2hestik.put("D", "K");
        t2hestik.put("E", "V");
        t2hestik.put("F", "E");
        t2hestik.put("G", "S");
        t2hestik.put("H", "Y");
        t2hestik.put("I", "R");
        t2hestik.put("J", "I");
        t2hestik.put("K", "B");
        t2hestik.put("L", "T");
        t2hestik.put("M", "Z");
        t2hestik.put("N", "U");
        t2hestik.put("O", "@");
        t2hestik.put("P", "G");
        t2hestik.put("R", "J");
        t2hestik.put("S", "F");
        t2hestik.put("Z", "W");
        t2hestik.put("T", "X");
        t2hestik.put("U", "N");
        t2hestik.put("V", "L");
        t2hestik.put("W", "A");
        t2hestik.put("X", "M");
        t2hestik.put("Y", "H");
        t2hestik.put("Q", "D");
        t2hestik.put(" ", "O");
        t2hestik.put("1", "=");
        t2hestik.put("2", "(");
        t2hestik.put("3", "*");
        t2hestik.put("4", "/");
        t2hestik.put("5", "&");
        t2hestik.put("6", ")");
        t2hestik.put("7", "_");
        t2hestik.put("8", "}");
        t2hestik.put("9", "]");
        t2hestik.put("0", "%");
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
            vastus = t2hestik.get(su);
            return vastus;

        }
        return vastus;
    }



}
