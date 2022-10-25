package jouerAvecDesEntiers;

import java.util.Scanner;

public class Multiplication {
    public static void Multiplication_methode() {
        // calcul de a*b sans les operateurs
        Scanner sc = new Scanner(System.in);
        System.out.println("merci d'indiquer a et b");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int multiplication = 0;
        int valb = b > 0 ? b : -b;
//		int vala=a>0 ?a:-a;
        for (int i = 0; i < valb; i++) {
            multiplication += a;
        }
        if (b < 0)
            multiplication = -multiplication;
        System.out.println(multiplication);
    }




    public static void main(String[] args) {
        //Multiplication_methode();
    }

}
