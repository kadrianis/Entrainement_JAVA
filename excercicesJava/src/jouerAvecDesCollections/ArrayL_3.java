package jouerAvecDesCollections;
import java.util.*;

public class ArrayL_3 {
    public static void main(String[] args) {

        Collection c = new ArrayList();

        c.add("une chaine de caracteres ABC");
        c.add(new Date());
        c.add(3);
        c.add(4);
        c.add(3.4);

        System.out.println("Ma collection contient : ");
        for (Object o : c) {
            System.out.println("Un objet de type " + o.getClass() + " : " + o);
        }

        System.out.println();
        System.out.println("Ma collection contient : ");
        Iterator i = c.iterator();
        while (i.hasNext()) {
            Object o = i.next();
            System.out.println("Un objet de type " + o.getClass() + " : " + o);
        }
    }
}
