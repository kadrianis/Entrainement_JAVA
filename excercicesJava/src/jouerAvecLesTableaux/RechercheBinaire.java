package jouerAvecLesTableaux;

import java.util.Arrays;

public class RechercheBinaire {
    // recherche binaire/dicotomique dans un tableau
    static int RechercheBinaire_methode(int a[], int cle) {
        int deb, l, fin, mid;
        l = a.length;
        deb = 0;
        fin = l - 1;
        mid = (deb + fin) / 2;
        while (deb <= fin) {
            if (a[mid] < cle) {
                deb = mid + 1;
                mid = (deb + fin) / 2;
            } else if (a[mid] == cle) {
                break;
            } else {
                fin = mid - 1;
                mid = (deb + fin) / 2;
            }
            if (deb > fin) {
                mid = -1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] monTab = {1, 2, 4, 5, 7, 8, 6, 5, 4, 1, 2, 2, 44, 52, 5};
        Arrays.sort(monTab);
        int res = RechercheBinaire_methode(monTab, 102);
        System.out.println(monTab.length);
        System.out.println(res);
    }
}
