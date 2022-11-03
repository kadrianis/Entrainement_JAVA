package jouerAvecDesCollections;

import java.util.*;

public class LinkedL {
    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        l.add("anis");
        l.add("safa");
        l.add("jalel");
        l.addFirst("mama");
        ArrayList arraylist= new ArrayList();
        arraylist.add("123");
        arraylist.add("456");
        l.addAll(arraylist);
        Iterator Iterator = l.iterator();
        while (Iterator.hasNext()) {
            System.out.println(Iterator.next());
        }
    }
}
