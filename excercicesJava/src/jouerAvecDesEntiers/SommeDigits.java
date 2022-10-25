package jouerAvecDesEntiers;

import java.util.Scanner;

public class SommeDigits {
    public static void SommeDigits() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int savea = a;
        int somme = 0;
        while (savea > 0) {
            somme += savea % 10;
            savea = savea / 10;
        }
        System.out.print(somme);
    }

    public static void main(String[] args) {
        SommeDigits();
    }
}
