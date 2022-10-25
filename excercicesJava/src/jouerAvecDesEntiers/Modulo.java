package jouerAvecDesEntiers;

import java.util.Scanner;

public class Modulo {
    public static void Modulo_methode() {
        /*
         * En supposant que les op�rateurs cit�s n'existent pas, calculer, pour 2
         * entiers a et b saisis au clavier : a % b faut comprendre apres
         */
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int saveA = a;
        while (a >= b) {
            a -= b;
        }
        System.out.print(" a % b donne " + a);
    }

    public static void Modulo_methode_2() {
        // a modulo de b ; essaie anis seul
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int savea = a;
        for (int i = 0; (savea - b) > 0; i++)
            savea = savea - b;
        System.out.print(" le modulo est " + savea);
    }
    public static void main(String[] args) {
        Modulo_methode();
    }
}
