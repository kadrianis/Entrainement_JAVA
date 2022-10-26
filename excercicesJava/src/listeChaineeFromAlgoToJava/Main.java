package listeChaineeFromAlgoToJava;

import java.util.Random;

public class Main {
    static      Random r = new Random();
    static ListeTriee l1 = new ListeTriee();
    static ListeTriee l2 = new ListeTriee();
    static ListeTriee l3 = new ListeTriee();
    static ListeTriee l4 = new ListeTriee();

    public static void main(String[] args) {
        int v; // valeur � ins�rer dans la liste l1 ou l2
        for (int i = 1; i <= 20; i++) {
            v = r.nextInt(101);
            l1.inserer(v);
            v = r.nextInt(101);
            l2.inserer2(v);
        }
        l1.afficher();
        l2.afficher();

        l3 = intersection(l1, l2);
        l3.afficher();

        l4.intersection(l1, l2);
        l4.afficher();
    }

    public static ListeTriee intersection(ListeTriee l1, ListeTriee l2) {
        ListeTriee li = new ListeTriee();

        l1.demarrer();
        l2.demarrer();
        while ((l1.eltc() != null) & (l2.eltc() != null)) {
            if (l1.eltc().el < l2.eltc().el) {
                l1.avancer();
            } else {
                if (l1.eltc().el > l2.eltc().el) {
                    l2.avancer();
                } else {
                    // l1.eltc().el == l2.eltc().el
                    li.ajoutQueue(l1.eltc().el);
                    l1.avancer();
                    l2.avancer();
                }
            }
        }
        // l1.eltc() != null) | (l2.eltc() != null
        return li;
    }
}

