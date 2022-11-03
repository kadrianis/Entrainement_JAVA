package _LabWorks.cheminsSommetsGraph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Sommet {

    private String nom;
    private Map<Sommet, Integer> voisins;


    public Sommet(String nom) {
        if (nom == null) throw new NullPointerException();
        this.nom = nom;
        voisins = new HashMap<>();
    }

    public void ajouterVoisin(Sommet voisin, int distance) {
        voisins.put(voisin, distance);
        voisin.voisins.put(this, distance);

        // attention cette ligne n'est pas correcte car elle crée une recursion infinie
        //voisin.ajouterVoisin(this, distance);
    }

    public int distance(Sommet s) {
		/*if (voisins.containsKey(s)) {
			return voisins.get(s);
		}*/

		/*Integer res = voisins.get(s);
		if (res==null) {
			return -1;
		}
		return res;*/
        return voisins.getOrDefault(s, -1);


    }

    public Iterator<Sommet> voisins() {
        return voisins.keySet().iterator();
    }

    public String getNom() {
        return nom;
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Sommet) {
            return this.nom.equals(((Sommet) obj).nom);
        }
        return false;
    }

    public String toString() {
        return nom;
    }


}
