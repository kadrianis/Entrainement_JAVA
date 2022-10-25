package jouerAvecDesEntiers;

import java.util.Scanner;

public class nbChiffreEntier {

    public static void NbChiffreEntier() {
        Scanner sc = new Scanner(System.in);
        System.out.println("merci de donner un entier");
        int a = sc.nextInt();
        int k = 1;
        int repetition = 1;

        while (a > 0) {
            repetition = k++;
            a /= 10;

        }
        System.out.println(repetition);

    }

    public static void NbChiffreEntier_2() {
        // avec un while
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int savea = a;
        int repetition = 1;
        while (savea > 9) {
            repetition++;
            savea = savea / 10;
        }
        System.out.print(repetition);
    }


    public static void NbChiffreEntier_3() {
        // a x b , essaie de Anis
        Scanner sc = new Scanner(System.in);
        int entierDonner = sc.nextInt();
        int k = 1;
        int repetition = 1;
        while (entierDonner > 0) {
            repetition = k++;
            entierDonner = entierDonner / 10;
        }
        System.out.print(repetition);
    }


        public static void main(String[] args) {

        //NbChiffreEntier();
        NbChiffreEntier_2();
    }
}
