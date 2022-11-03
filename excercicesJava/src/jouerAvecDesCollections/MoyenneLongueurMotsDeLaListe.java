package jouerAvecDesCollections;

import java.util.*;

public class MoyenneLongueurMotsDeLaListe {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("toto"); // c est des object et non pas consid�r� commee des string
        c.add("bibule");
        c.add("chouetteg");
        int sumLength = 0;
        Iterator<String> i = c.iterator(); // it�rateur que le cot� gauche
        while (i.hasNext()) {
            String s = i.next();
            sumLength += s.length();
            System.out.println(sumLength);
        }
        System.out.println(((double) sumLength) / c.size());
    }
}
