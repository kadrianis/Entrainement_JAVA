package jouerAvecLesTableaux;

public class InverserTab {

    public static void inverser(int[] tab) {
        // inverser l'ordre d'un tableau de int;
        int temp = 0;
        for (int i = 0; i < tab.length / 2; i++) {
            temp = tab[i];
            tab[i] = tab[tab.length - 1 - i];
            tab[tab.length - 1 - i] = temp;
            System.out.print(tab[i]+ " ");
        }
        for (int i = tab.length / 2; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
    }

    public static void main(String[] args) {
        int [] a = {1,4,7,8,5,2,3,6,9};
        inverser(a);
    }
}
