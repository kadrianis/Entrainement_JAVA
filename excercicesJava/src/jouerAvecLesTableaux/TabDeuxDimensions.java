package jouerAvecLesTableaux;

import java.util.Arrays;

public class TabDeuxDimensions {

    public static int[] sommeLignes(int[][] t) {
        // input :: tableau de tableau
        // output:: un tableau des sommes des element de chaque tableau a chaque indice

        int nLignes = t.length;
        int [] res = new int [nLignes];

        for (int i = 0; i < nLignes; i++) {
            res[i] = 0;
            for (int j = 0; j < t[i].length; j++)
                res[i] += t[i][j];
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 1, 2, 4}, {1, 5, 8, 7, 6,}, {1, 5, 8,6}, {1, 5, 8, 7}};
        sommeLignes(a);
    }

}
