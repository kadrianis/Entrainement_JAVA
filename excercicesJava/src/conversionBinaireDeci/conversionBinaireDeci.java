package conversionBinaireDeci;

import java.util.Scanner;

public class conversionBinaireDeci {

    public static void binaire() {
        Scanner sc = new Scanner(System.in);
        int base = 1;
        int somme = 0;
        System.out.println("merci de donner votre chiffre binaire");
        String b = "";
        String a = sc.nextLine();
        sc.close();
        for (int i = a.length() - 1; i >= 0; i--) {
            b += a.charAt(i);
        }
        //System.out.println(b);
        a = b; // inverser la chaine
        for (int i = 0; i < a.length(); i++) {
            somme += (a.charAt(i) - '0') * base;
            base *= 2;
        }

        System.out.println(somme);

    }

    public static void main(String[] args) {
        binaire();
    }
}
