package puissanceAb;

import java.util.Scanner;

public class PuissanceAb {
    public static void puisssance() {
        // a elev� 'a' la puissace de 'b' , Correction du prof
        Scanner sc = new Scanner(System.in);
        System.out.println("merci d'indiquer deux valeurs");
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        int puissance = 1;
        int produit = 0;
        int vaA = a < 0 ? -a : a;
        int vaB = b < 0 ? -b : b;

        for (int j = 0; j < vaB; j++) {
            produit = 0;
            for (int i = 0; i < vaA; i++)
                produit += puissance;
            if (a < 0)
                produit = -produit;
            puissance = produit;
        }

        double res = b < 0 ? 1. / puissance : puissance;
        System.out.println(res);
    }

    public static void main(String[] args) {
        puisssance();
    }


}
