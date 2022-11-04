package jouerAvecDesCollections;
import java.util.*;

public class MapsOuCollection {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Map<Integer, String> dico;
        dico = new HashMap<Integer, String>();
        for (int i = 0; i < 1000; i++) {
            int v = (int) (Math.random() * 1000000);
            dico.put(v, String.valueOf(v));
        }

        System.out.println(dico);
        StringBuffer res = new StringBuffer();

        // je peux pas ittirer sur la map car ce n'est pas une collection mais je peux
        // demander quel est ton keyset

		/*for (Integer k : dico.keySet()) {
			res.append(", " + k + "=\"" + dico.get(k) + "\"");
		}

		res.replace(0, 2, "{");
		System.out.println(res.toString());*/

        //---------------------autre maniere avec l'entree set ---------------------------------//

        for (Map.Entry<Integer, String> e : dico.entrySet()) {
            res.append(", " + e.getKey() + "=\"" + e.getValue() + "\"");
        }
        res.replace(0, 2, "{").append("}");
        System.out.println(res.toString());
        // a revoire

        //---------------------comparer les entryset et le keyset ---------------------------------//
        // Entryset est meilleur


        //---------------------Passer par le treeMap ---------------------------------//
        // treeMap :  il est ordonné
        Map<Integer, String> dico2;
        dico2 = new TreeMap<Integer, String>();
        for (int i = 0; i < 1000; i++) {
            int v = (int) (Math.random() * 1000000);
            dico2.put(v, String.valueOf(v));
        }

        // methodes map et methodes collection
        // values keyset treeset


        //---------------------demonstration ---------------------------------//
        Set<Integer> s = dico.keySet();
        for (Integer k : s) {
            res.append(", " + k + "=\"" + dico.get(k) + "\"");
            s.remove(k);
            // en vidant le keyset je vide directement la map ( avec un removeall)

        }


    }

}

