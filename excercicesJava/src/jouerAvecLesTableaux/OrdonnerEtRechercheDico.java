package jouerAvecLesTableaux;

import java.util.Scanner;

import static jouerAvecLesTableaux.OrdonnerUnTableau.OdronnerTab;
import static jouerAvecLesTableaux.RechercheBinaire.RechercheBinaire_methode;

public class OrdonnerEtRechercheDico {
    public static void main(String[] args) {
        int i, n, b[], key, c;
        System.out.print("Enter size of array: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int a[] = new int[n];

        // ---------Enter values to array-------------

        for (i = 0; i < n; i++) {
            System.out.print(i + 1 + " element : ");
            a[i] = sc.nextInt();
        }
        System.out.print("");

        // -----------------Sort the array--------------------

        b = OdronnerTab(a);
        for (i = 0; i < n; i++) {
            System.out.println(i + 1 + " element : " + b[i]);
        }

        // ---------------Enter search key u want to find-----------

        System.out.println("Enter the number u want to search: ");

        key = sc.nextInt();

        c = RechercheBinaire_methode(b, key);

        if (c == -1) {
            System.out.println("Pardon,int n'existe pas dans le tableau");
        } else {
            System.out.println("Position est : " + (c + 1));
        }

    }
}

