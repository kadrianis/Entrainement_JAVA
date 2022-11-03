package jouerAvecDesCollections;

import java.util.*;

public class ArrayL_2 {
    public static void main(String[] args) {

        Collection c1 = new ArrayList();
        Collection c2 = new ArrayList();
        Collection c3 = new ArrayList();

        // 3 collections

        c1.add("truc");
        c1.add("bidule");
        c2.add("truc");
        c3.add("bidule");

        System.out.println("c1 contient c2 ? " + c1.containsAll(c2));
        System.out.println("c2 contient c1 ? " + c2.containsAll(c1));

        // j'ajoute tous les �l�ments de c1 dans c2
        // attention le comportement de cette m�thode
        // diff�re selon les impl�mentations (Set vs List)
        c2.addAll(c1);
        System.out.println(c2);
        // j'enl�ve tous les �l�ments de c1 dans c2
        c2.removeAll(c1);
        System.out.println(c2);
        // je ne retiens dans c1 que les �l�ments qui sont aussi dans c3
        c1.retainAll(c3);
        System.out.println(c1);
    }
}

