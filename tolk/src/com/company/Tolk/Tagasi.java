package com.company.Tolk;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Madis on 21.11.2015.
 */
public class Tagasi {
    int vot;
    String siss;

    public Tagasi(int myVot, String mySiss) {
        vot = myVot;
        siss = mySiss;
    }

    public String[] tahestik = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "R", "S", "Z", "T", "U", "V", "W", "X", "Y", "Q", " ", "1", "2", "3", "4", "5", "6",
            "7", "8", "9", "0", ".", "!", "?", ",", ";", ":", "(", ")"};

    public String tag() {
        String vastusTagasi = "";
        int v = vot;
        String tekst = siss;
        int pikkus = tekst.length();
        HashMap<String, String> t2hestik = new HashMap<String, String>();
        for (int i = 0; i <tahestik.length; i++) {
            int t = i-v;
            while (t<0){
                t=t+tahestik.length;
            }
            t2hestik.put(tahestik[i],tahestik[t]);
            for (int indeks = 0; indeks < pikkus; indeks++) {
                char U = tekst.charAt(indeks);
                String kontroll = Character.toString(U);
                String su = kontroll.toUpperCase();
                if (!t2hestik.containsKey(su)) {
                    t2hestik.put(su,su);
                }
            }
        }
        for (int i = 0; i < tekst.length(); i++) {
            char m = tekst.charAt(i);
            String t = Character.toString(m);
            String su = t.toUpperCase();
            String g = t2hestik.get(su);
            vastusTagasi = vastusTagasi + g;
        }
        return vastusTagasi;
    }

}

