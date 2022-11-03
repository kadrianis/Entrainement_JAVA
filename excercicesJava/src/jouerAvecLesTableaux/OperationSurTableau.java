package jouerAvecLesTableaux;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OperationSurTableau {


    public static void coursBadou() {
        int[] tab = new int[5];
        System.out.println(Arrays.toString(tab));
//        for (int i = 0; i < tab.length; i++)
//            tab[i] = new int[i + 1];
//        tab[3][2] = 4;
//        System.out.println(tab[3][2]);
    }


    public static int[][] iniTab2d(int nbl, int nbc) {
        // initier un tableau a deux dimensions avec des random
        int[][] tab = new int[nbl][nbc];
        int max = nbl * nbc;
        for (int i = 0; i <nbl ; i++) {
            for (int j = 0; j < nbc; j++) {
                int hasard = (int) ((Math.random() * max + 1));
                tab[i][j] = hasard;
            }

        }
        return tab;
    }



    public static void main(String[] args) {
        //coursBadou();
        int[][] tabRes=  iniTab2d(24,25);
        System.out.println(tabRes.length);

        for (int i=0; i<tabRes.length;i++){
            System.out.println(Arrays.toString(tabRes[i]));
        }
    }

}
