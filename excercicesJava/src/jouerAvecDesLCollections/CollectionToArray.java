package jouerAvecDesLCollections;

import java.util.*;

public class CollectionToArray {

    public static void main(String[] args) {
        List c = new LinkedList();

        c.add("chose");
        c.add("chouette");
        Iterator it = c.iterator();
        ListIterator lit = c.listIterator();


        Object[] tab = c.toArray();
        System.out.println(Arrays.deepToString(tab));


        String[] tab2 = new String[10];
        c.toArray(tab2);
        System.out.println(Arrays.deepToString(tab2));

        String[] tab3 = new String[1];
        String[] tab4 = (String[]) c.toArray(tab3);
        System.out.println(Arrays.deepToString(tab3));
        System.out.println(tab4.getClass() + "  -  " + Arrays.deepToString(tab4));
    }
}

