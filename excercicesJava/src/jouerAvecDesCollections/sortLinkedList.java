package jouerAvecDesCollections;

import java.util.Iterator;
import java.util.LinkedList;

public class sortLinkedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(7);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(25);
        list.add(9);
        Iterator<Integer> it1 = list.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());

        }
        System.out.println();
        System.out.print("-------------------------------------------------------------------------");
        System.out.println();


        list.sort(null);
        Iterator<Integer> it2 = list.iterator();

        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
    }

}

