package jouerAvecDesEntiers;

import java.util.Scanner;

public class division {
    public static void Division_methode() {
        // En supposant que les opérateurs cités n'existent pas, calculer, pour 2
        // entiers a et b saisis au clavier :a/b
        // avec des chiffres négatif ça renvoie un chiffre bizzard
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int saveA = a;
        int z = 0;

        while (a >= b) {
            a -= b;
            z += 1;
        }
        System.out.print("le resultat de a/b est  " + z);
    }


    public static void Division_methode_2() {
        // essaie le avec des valeurs negatives

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        int savea = a;
        int saveb = b > 0 ? b : -b;

        int j = 0;
        int repetition = 0;
        if (saveb != 0) {
            for (int i = 0; savea >= saveb; i++) {
                savea = savea - saveb;
                repetition += 1;
            }
            System.out.print("le resultat de la division est " + repetition);
        }

        else
            System.out.print("impossible");
    }

    public static void main(String[] args) {
        //Division_methode();
        Division_methode_2();

    }
}
