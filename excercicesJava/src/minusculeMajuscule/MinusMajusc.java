package minusculeMajuscule;

import java.util.Scanner;

public class MinusMajusc {

    public static void minusMajusc() {
        // Lire une chaine de caractères, et changer toutes les lettres qu'elle contient de telle sorte que l'on obtienne
        // une alternance de minuscules et de majuscules comme dans cet "ExEmPlE".
        // TODO a revoir
        Scanner sc = new Scanner(System.in);
        String ch = sc.next(); // saisie par l'utilisateur
        String ch1 = "";
        int j = 97;
        int res;
        for (int i = 0; i < ch.length(); i++) {
            if ((int) ch.charAt(i) >= j && (int) ch.charAt(i) <= 122)
                res = (int) (ch.charAt(i)) - 32;
            else
                res = (int) (ch.charAt(i));
            System.out.print((char) (res));
        }
    }

    public static void main(String[] args) {
        minusMajusc();
    }
}
