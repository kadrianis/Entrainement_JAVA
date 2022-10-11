package desLettresEtDesMots;

import java.util.Scanner;
import java.util.*;

public class Version1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String nbLigneNbMot = sc.nextLine();
        String[] nbLigneNbMot2 = nbLigneNbMot.split(" ");
        int nbLigne = Integer.parseInt(nbLigneNbMot2[0]);
        //int nbMot = Integer.parseInt(nbLigneNbMot2[1]);
        int[] tableauDesTailles = new int[101];
        List<String> listDesLignes = new ArrayList<>();


        for (int i = 0; i < nbLigne; i++) {
            // je stocke les lignes ajoutées dans un tableau
            // je stocke car j'ai besoin de les rajouter toutes --> apres je les traite
            listDesLignes.add(sc.nextLine());
        }


        for (int j = 0; j < nbLigne; j++) {
            // mettres les mots d'une phrase dans un tableau .. ne peut etre visible de l'exterieur
            String[] lesMotsDePhrase = listDesLignes.get(j).split(" ");
            for (int k = 0; k < lesMotsDePhrase.length; k++) {
                // lesMotsDePhrase.length == nb mots
                // rajout au tableau des statistiques :: resultat
                tableauDesTailles[lesMotsDePhrase[k].length()] = tableauDesTailles[lesMotsDePhrase[k].length()] + 1;
            }
        }

        for (int e = 0; e < tableauDesTailles.length; e++) {
            if (tableauDesTailles[e] != 0)
                System.out.println(e + " : " + tableauDesTailles[e]);
        }


    }
}
