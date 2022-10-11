package desLettresEtDesMots;

import java.util.Scanner;
import java.util.*;

public class Version1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String nbLigneNbMot = sc.nextLine();
        String[] nbLigneNbMot2 = nbLigneNbMot.split(" ");
        int nbLigne = Integer.parseInt(nbLigneNbMot2[0]);
        //int nbMot = Integer.parseInt(nbLigneNbMot2[1]); --> j'utilise pas le deuxieme parametre
        int[] tableauDesTailles = new int[101];
        List<String> listDesLignes = new ArrayList<>();


        for (int i = 0; i < nbLigne; i++) {
            // mettre les lignes ecrite dans un tableau
            listDesLignes.add(sc.nextLine());
        }


        for (int j = 0; j < nbLigne; j++) {
            String[] lesMotsDePhrase = listDesLignes.get(j).split(" ");
            for (int k = 0; k < lesMotsDePhrase.length; k++) {
                tableauDesTailles[lesMotsDePhrase[k].length()] += 1;
            }
        }

        for (int e = 0; e < tableauDesTailles.length; e++) {
            if (tableauDesTailles[e] != 0)
                System.out.println(e + " : " + tableauDesTailles[e]);
        }


    }
}
