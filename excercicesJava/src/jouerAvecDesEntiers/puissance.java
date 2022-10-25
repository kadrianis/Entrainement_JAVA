package jouerAvecDesEntiers;

import java.util.Scanner;

public class puissance {

    public static void Puissance_methode() {
        /*
         * faire la puissance d'un nombre a et b
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("merci de donner a et b");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int puissance = 1;
        int produit = 0;

        int valB = b < 0 ? -b : b;
        int valA = a < 0 ? -a : a;

        for (int i = 0; i < valB; i++) {
            produit = 0;
            for (int j = 0; j < valA; j++)
                produit += puissance;
            if (a < 0)
                produit = -produit;
            puissance = produit;
        }

        System.out.print(" la puissance de a et b c'est " + puissance);

    }

    public static void main(String[] args) {
        Puissance_methode();
    }
}
