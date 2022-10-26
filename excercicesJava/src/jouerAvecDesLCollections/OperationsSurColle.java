package jouerAvecDesLCollections;

import java.util.*;

public class OperationsSurColle {
    public static void main(String[] args) {

        Collection c1 = new ArrayList();
        c1.add("une chaine de caracteres");
        c1.add(new Date());
        c1.add(3);

        /*
         * On peut interroger l'etat de la collection
         */

        System.out.println("contenu de c1 : " + c1); // affiche tous les �l�ments: juste en la mettant dans le syso
        System.out.println("c1 est elle vide ? " + c1.isEmpty());
        System.out.println("La taille de la collection c1 : " + c1.size());
        System.out.println("c1 contient elle l'entier 3 : " + c1.contains(3));
        System.out.println("c1 contient elle le double 3.0 : " + c1.contains(3.0));

        /*
         * on peut enlever des elements
         */

        c1.remove(3);
        System.out.println("apres avoir enleve 3 : " + c1);
        c1.clear();
        System.out.println("apres avoir tout enleve : " + c1);
    }
}