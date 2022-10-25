package jouerAvecDesEntiers;

import java.util.Scanner;

public class SommeChiffreEntier {
    public static void SommeChiffreEntier_methode() {
        // Calcule la somme des chiffres d'un nombre entier positif saisi au clavier

        Scanner sc = new Scanner(System.in);
        int somme, res, n;
        somme = 0;
        n = sc.nextInt();
        while (n / 10 > 9) {
            somme = somme + n % 10;
            n = n / 10;
        }
        somme = somme + n / 10 + n % 10;
        System.out.println("La somme d'un chiffre d'un nombre entier positif est : " + somme);
    }

    public static void main(String[] args) {
        SommeChiffreEntier_methode();
    }
}
