package jouerAvecLesTableaux;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OrdonnerUnTableau {
    // on parcours  ::  le nom de l'algorithme
    static int[] OdronnerTab(int arr[]) {
        int l, max, temp;
        l = arr.length;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    public static boolean estOrdonne(int[] tab) {
        // attention au tab.length-1 et non pas tab.length
        int i = 0;
        for (i = 0; i < tab.length - 1; i++) {
            if (tab[i] >= tab[i + 1])
                break;
        }
        if (i != tab.length - 1)
            return true;
        return false;
    }


    public static void main(String[] args) {
        int[] monTab = {1, 5, 7, 8, 4, 1, 2, 3, 6, 1, 1, 1, 2, 5, 4, 8, 9, 7, 4};
        int[]monTabOrdonne= OdronnerTab(monTab);
        System.out.println(Arrays.toString(monTabOrdonne));
        System.out.println(estOrdonne(monTabOrdonne));

    }
}