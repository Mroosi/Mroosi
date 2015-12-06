package com.company.Tolk;

import java.util.HashMap;


public class Edasi {

    public String[] tahestik = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "R", "S", "Z", "T", "U", "V", "W", "X", "Y", "Q", " ", "1", "2", "3", "4", "5", "6",
            "7", "8", "9", "0", ".", "!", "?", ",", ";", ":", "(", ")"};


    public String ed() {
        String vastus = "";
        System.out.println(vastus);
        int v = 1;                        /*Siia peaks tulema võti kasutaja sisendist*/
        String tekst = "abc";          /*Siia peaks tulema tekst kasutaja sisendist*/
        int pikkus = tekst.length();
        HashMap<String, String> t2hestik = new HashMap<String, String>();
        for (int i = 0; i <tahestik.length; i++) {
            int t = i+v;
            while (t>=tahestik.length){
                t=t-tahestik.length;
            }
            t2hestik.put(tahestik[i],tahestik[t]);
        }
        for (int i = 0; i < pikkus; i++) {
            char m = tekst.charAt(i);
            String t = Character.toString(m);
            String su = t.toUpperCase();
            String g = t2hestik.get(su);
            vastus = vastus + g;
            System.out.println(vastus);

        }
        return vastus;
    }


}
