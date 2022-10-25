package puissanceAb;

import java.util.Scanner;

public class PuissanceAb_v2 {
    public static void puissance_v2() {
        // Lire une chaine de caracteres qui contient un nombre entier en notation
        // binaire,
        // calculer et afficher sa valeur en notation décimale.

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer un nombre en base b � convertir en d�cimal");
        String b = sc.next(), chaine = "";
        System.out.println("Entrer la base");
        int base = sc.nextInt();
        int puissance = 1, decimale = 0;
        // int vesionInt = Integer.parseInt(b);

        for (int i = b.length() - 1; i >= 0; i--) {
            chaine = chaine + b.charAt(i);
        }

        b = chaine;

        for (int i = 0; i < b.length(); i++) {

            int k = b.charAt(i) - '0';
            decimale = decimale + puissance * k;
            puissance = puissance * base;

            // int total = k;
            // total = total * 2 +i;//10101011101
        }
        System.out.println(decimale);
        sc.close();


    }

    public static void main(String[] args) {
        puissance_v2();
    }
}

