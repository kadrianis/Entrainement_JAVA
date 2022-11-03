package _LabWorks.cheminsSommetsGraph;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Graphe {

    private Map<String, Sommet> index;

    public Graphe() {
        index = new HashMap<>();
    }

    private Sommet getOrCreate(String nomSommet) {
        /*
         * Sommet res = index.get(nomSommet); if (res==null) { res = new
         * Sommet(nomSommet); index.put(nomSommet, res); } return res;
         */

        return index.computeIfAbsent(nomSommet, x -> new Sommet(x)); // TODO comprendre :: lambda expression

    }

    public void ajouterArete(String nomSommet1, String nomSommet2, int distance) {
        getOrCreate(nomSommet1).ajouterVoisin(getOrCreate(nomSommet2), distance);
    }

    public Chemin plusCoursChemin(String nomSommetDebut, String nomSommetFin) {
        Sommet debut = getOrCreate(nomSommetDebut);
        Sommet fin = getOrCreate(nomSommetFin);

        TreeSet<Chemin> s = new TreeSet<>();
        s.add(new Chemin(debut));

        while (s.size() > 0) {
            Chemin lelu = s.pollFirst();
            if (lelu.arrivee().equals(fin)) {
                return lelu;
            }
            s.addAll(lelu.etendre());
        }
        return null;

    }

    public static void main(String[] args) {
        Graphe g = new Graphe();
        g.ajouterArete("A", "B", 85);
        g.ajouterArete("A", "C", 217);
        g.ajouterArete("A", "E", 173);

        g.ajouterArete("B", "F", 80);
        g.ajouterArete("C", "G", 186);
        g.ajouterArete("C", "H", 103);
        g.ajouterArete("D", "H", 183);

        g.ajouterArete("E", "J", 502);
        g.ajouterArete("H", "J", 167);

        g.ajouterArete("F", "I", 250);

        g.ajouterArete("I", "J", 84);

        System.out.println(g.plusCoursChemin("A", "H"));

    }
}

