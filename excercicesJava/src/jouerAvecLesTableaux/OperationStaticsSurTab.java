package jouerAvecLesTableaux;

import java.util.Arrays;
import java.util.Scanner;

public class OperationStaticsSurTab {

    public static void remplirTableauAvecDesRandom() {
        // tab de taille 20 avec des random sans qu'il y ait de doublet
        int[] random = new int[20];
        int i = 0;
        boolean equals;
        while (i != 20) {
            random[i] = (int) (Math.random() * 20);
            // affecter des valeurs au differentes case
            equals = false;
            // si la valeur que je viens d'affecter existe, alors faut en tirer une nouvelle
            for (int j = 0; j != i; j++) {
                if (random[j] == random[i]) {
                    equals = true;
                }
            }
            if (!equals) {
                i++;
            }
        }
        System.out.println(Arrays.toString(random));
    }

    public static void incrementation() {
        Scanner sc = new Scanner(System.in);
        int a, b = 0;
        a = 10;
        while (b < 15) {
            b = a++;
            System.out.println(b);
        }

    }

    public static void main(String[] args) {
        //remplirTableauAvecDesRandom();
        incrementation();
    }

}
