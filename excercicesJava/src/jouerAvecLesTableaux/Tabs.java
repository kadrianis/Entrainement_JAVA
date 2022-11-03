package jouerAvecLesTableaux;

public class Tabs {
    public static void tab2dim() {

        int tab[] = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        int n = 8;
        n = tab[tab[n] / 2]; // n = tab[tab[8] / 2] -- n = tab[tab[4]]
        System.out.println(tab[n] / 2); //
    }


    public static void main(String[] args) {

        int tab1[] = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int tab2[] =  { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        System.out.println(tab1.equals(tab2));


        //tab2dim();
    }
}
