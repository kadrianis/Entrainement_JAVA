package jouerAvecDesEntiers;

import java.util.Scanner;

public class trierEntier {
    public static void trierEntier_methode() {

        Scanner sc = new Scanner(System.in);
        int a, b, c, g, m, p;
        System.out.println("merci de donner 3 entiers kho");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        if ((a >= b) && (a >= c) && (b >= c))
            g = a;
        m = b;
        p = c;

        if ((a >= b) && (a >= c) && (c >= b)) {
            g = a;
            m = c;
            p = b;
            System.out.println(g + " " + m + " " + p);

        }
        if ((b >= a) && (b >= c) && (a >= c)) {
            g = b;
            m = a;
            p = c;
            System.out.println(g + " " + m + " " + p);

        }
        if ((b >= b) && (b >= c) && (c >= a)) {
            g = b;
            m = c;
            p = b;
            System.out.println(g + " " + m + " " + p);

        }
        if ((c >= a) && (c >= b) && (b >= a)) {
            g = c;
            m = b;
            p = a;
            System.out.println(g + " " + m + " " + p);

        }
        if ((c >= b) && (c >= a) && (a >= b)) {
            g = c;
            m = a;
            p = b;
            System.out.println(g + " " + m + " " + p);
        }

    }

    public static void main(String[] args) {
        trierEntier_methode();
    }

}
