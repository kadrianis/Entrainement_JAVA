package jouerAvecLesTableaux;

public class TriParInsertion {
    // Tri par insertion

    public static void trierParIns(int[] tableau) {
        int i, j, cle;

        for (i = 1; i < tableau.length; i++) {
            cle = tableau[i];
            j = i;
            while ((j >= 1) && (tableau[j - 1] > cle)) {
                tableau[j]  = tableau[j - 1] ;
                j = j - 1;
            }
            tableau[j] = cle;
        }
    }



    public static void afficher(int[] tableau) {
        for (int valeur : tableau) System.out.print(valeur + " ");
        System.out.println();
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] tableau = new int[10];
        tableau[0] = 20;
        tableau[1] = 5;
        tableau[2] = 3;
        tableau[3] = -7;
        tableau[4] = 0;
        tableau[5] = 14;
        tableau[6] = 56;
        tableau[7] = 8;
        tableau[8] = 19;
        tableau[9] = 15;

        TriParInsertion.afficher(tableau);
        TriParInsertion.trierParIns(tableau);
        TriParInsertion.afficher(tableau);
    }
}


