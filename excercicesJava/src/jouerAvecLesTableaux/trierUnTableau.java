package jouerAvecLesTableaux;

public class trierUnTableau {



    public static boolean estTrie_2(int[] tab) {
        // return "vrai" si et seulement si les elements du tab sont triés dans l'ordre croissant
        // todo : a faire s'ils sont triés mais dans l'ordre décroissant

        int a = 0;
        for (int i = 0; (a >= 0) && (i < tab.length - 1); i++) {
            a = tab[i + 1] - tab[i];
        }
        return a>=0;
    }



    public static void main(String[] args) {
        int[]tab = { 1,4,5,7};
        //System.out.println(estTrie(tab));
        System.out.println(estTrie_2(tab));
    }
}
