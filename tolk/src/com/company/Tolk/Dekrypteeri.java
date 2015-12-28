package com.company.Tolk;

import java.util.HashMap;

public class Dekrypteeri {
    int voti;
    String sisseTulevTekst;

    public Dekrypteeri(int myVot, String myTekstSisse) {
        voti = myVot;
        sisseTulevTekst = myTekstSisse;
    }

    public String[] tahestik = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "R", "S", "Z", "T", "U", "V", "W", "X", "Y", "Q", " ", "1", "2", "3", "4", "5", "6",
            "7", "8", "9", "0", ".", "!", "?", ",", ";", ":", "(", ")"};

    public String dekrypteeri() {
        String dekryptVastus = "";
        int kryptVoti = voti;
        String tekst = sisseTulevTekst;
        HashMap<String, String> t2hestik = new HashMap<>();
        for (int i = 0; i <tahestik.length; i++) {
            int lugeja = i-kryptVoti;
            while (lugeja<0){
                lugeja=lugeja+tahestik.length;
            }
            t2hestik.put(tahestik[i],tahestik[lugeja]);
            for (int indeks = 0; indeks < tekst.length(); indeks++) {
                char taht = tekst.charAt(indeks);
                String kontroll = Character.toString(taht);
                String symbol = kontroll.toUpperCase();
                if (!t2hestik.containsKey(symbol)) {
                    t2hestik.put(symbol,symbol);
                }
            }
        }
        for (int i = 0; i < tekst.length(); i++) {
            char taht = tekst.charAt(i);
            String tahtTaht = Character.toString(taht);
            String symbol = tahtTaht.toUpperCase();
            String osaVastus = t2hestik.get(symbol);
            dekryptVastus = dekryptVastus + osaVastus;
        }
        return dekryptVastus;
    }

}

