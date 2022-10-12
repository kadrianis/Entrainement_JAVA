package chiffrePlusProcheDuZero;

import java.util.ArrayList;
import java.util.Collections;

public class Version2 {
    // si les chiffres était négatif et positif
    public static int valeurPlusPorcheDuZero(ArrayList<Integer> valeurs) {
        // initialiser un indice de comparaison au max du tableau
        Collections.sort(valeurs);
        //System.out.println(valeurs) --> je confirme que le tableau est oronné mtn
        int minAbs= valeurs.get(valeurs.size()-1) >0 ? valeurs.get(valeurs.size()-1) : Math.abs(valeurs.get(valeurs.size()-1)) ;
        //System.out.println(minAbs) --> je prends le maximum
        for (Integer valeur : valeurs) {
            if (valeur < minAbs)
                minAbs = valeur;
        }
        return minAbs;
    }



}
