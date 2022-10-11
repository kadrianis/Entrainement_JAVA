package chiffrePlusProcheDuZero;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Version1 {

    public static int valeurPlusPorcheDuZero(ArrayList<Integer> valeurs) {
        // initialiser un indice de comparaison au max du tableau
        Collections.sort(valeurs);
        //System.out.println(valeurs) --> je confirme que le tableau est oronné mtn
        int minAbs=valeurs.get(valeurs.size()-1);
        //System.out.println(minAbs) --> je prends le maximum
        for (Integer valeur : valeurs) {
            if (valeur < minAbs)
                minAbs = valeur;
        }
        return minAbs;
    }

    public static void main(String[] args) {

        ArrayList<Integer> valeurs = new ArrayList<>(10);
        for (int i=0; i<10;i++) {
            valeurs.add((int)(Math.random() * 100+5));
        }
        //System.out.println(valeurs.size())--> verifier l'ajout
        System.out.println(valeurPlusPorcheDuZero(valeurs));
    }


}
