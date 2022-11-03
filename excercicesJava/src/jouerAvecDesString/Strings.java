package jouerAvecDesString;

import java.util.Scanner;

public class Strings {

    public static void SbString() {

        String str1 = "String method tutorial";
        String str2 = "compareTo method example";
        String str3 = "String method tutorial";

        int var1 = str1.compareTo(str2);
        System.out.println("str1 & str2 comparison: " + var1);

        int var2 = str1.compareTo(str3);
        System.out.println("str1 & str3 comparison: " + var2);

        int var3 = str2.compareTo("compareTo method example");
        System.out.println("str2 & string argument comparison: " + var3);
    }

    public static boolean estVoyelle(char ch) {
        return ch == 'i' || ch == 'e' || ch == 'o' || ch == 'y' || ch == 'u' || ch == 'a';
    }

    public static String doubleVoyelle(String ch) {
        // en rencontrant une voyelle il la double
        String ch1 = "";
        for (int i = 0; i < ch.length(); i++) {
            ch1 = estVoyelle(ch.charAt(i)) ? (ch1 + ch.charAt(i) + ch.charAt(i)) : (ch1 + ch.charAt(i));
        }
        return ch1;
    }

    public static void ConvertBinDec() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer un nombre a convertir en decimal et puis sa base");
        String nb = sc.next();
        String chaine = "";
        int base = sc.nextInt();
        int puissance = 1, resultat = 0;

        for (int i = nb.length() - 1; i >= 0; i--) {
            chaine = chaine + nb.charAt(i);
            // j'inverse la chaine
        }
        for (int i = 0; i < chaine.length(); i++) {
            int k = chaine.charAt(i) - '0';
            resultat = resultat + puissance * k;
            // puissance a 1 et qu'apres la premiere opération que ca change en base * puissance
            puissance = puissance * base;
        }
        System.out.println(resultat);
    }

    public static void nbOccuranceChar() {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int j = 0;
        char b = sc.next().charAt(0); // a faire avec les chaines

        for (int i = 0; i < a.length(); i++) {
            if (b == a.charAt(i) || b - 32 == a.charAt(i) || b + 32 == a.charAt(i)) {
                j += 1;
            }
        }

        System.out.print(j);
    }


    public static void SuppCharDeChaine() {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char CharaSuppr = sc.next().charAt(0);
        String c = "";

        for (int i = 0; i < input.length(); i++) {
            if (CharaSuppr != input.charAt(i) && CharaSuppr - 32 != input.charAt(i) && CharaSuppr + 32 != input.charAt(i)) {
                // tester avec toutles les conditions :: maj min
                c = c + input.charAt(i);
            }
        }
        System.out.print(c);
        sc.close();
    }

    public static void main(String[] args) {
        //SbString();
        //System.out.println(doubleVoyelle("waeiuw"));
        //ConvertBinDec();
        // nbOccuranceChar();
        SuppCharDeChaine();
    }

}
