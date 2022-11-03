package jouerAvecDesCollections;


import java.util.*;
import java.util.HashSet;

public class HashS {
    public static void main(String args[]) {
        // Create a HashSet object and initialize it
        Set<String> villes = new HashSet<String>();

        villes.add("Alger");
        villes.add("Paris");
        villes.add("Madrid");
        villes.add("Tunis");

        // Print the set contents
        System.out.println("Hashset " + villes);

        System.out.println("\n--------------------------------------------------------");

        // Create an iterator for the villes
        Iterator iter = villes.iterator();


        // print the set contents using iterator
        System.out.println("\n en utilisant l'Itérateur: ");
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }


        System.out.println("\n--------------------------------------------------------");
        System.out.println("\n Avec la loop forEach :");
        // print the set contents using forEach loop
        for (String val : villes) {
            System.out.print(val + " ");
        }
    }
}