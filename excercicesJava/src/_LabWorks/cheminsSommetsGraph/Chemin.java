package _LabWorks.cheminsSommetsGraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Chemin implements Comparable<Chemin>, Iterable<Sommet> {

    private int distanceTot;
    private List<Sommet> sommets;

    public Chemin(Sommet debut) {
        distanceTot = 0;
        sommets = new ArrayList<>();
        sommets.add(debut);
    }

    protected Chemin(Chemin debut, Sommet suite) {
        int d = debut.sommets.get(debut.sommets.size() - 1).distance(suite);
        if (d == -1) {
            throw new RuntimeException(
                    "Le sommet " + suite + " n'est pas vosin de " + debut.sommets.get(debut.sommets.size() - 1));
        }
        sommets = new ArrayList<>();
        sommets.addAll(debut.sommets);
        sommets.add(suite);

        this.distanceTot = debut.distanceTot + d;
    }

    public Sommet arrivee() {
        return sommets.get(sommets.size() - 1);

        /*
         * Iterator<Sommet> it = sommets.iterator(); Sommet courant = it.next(); while
         * (it.hasNext()) { courant = it.next(); } return courant;
         */
    }

    public Collection<Chemin> etendre() {
        Collection<Chemin> res = new ArrayList<>();

        Iterator<Sommet> it = arrivee().voisins();
        while (it.hasNext()) {
            Sommet a = it.next();
            if (!sommets.contains(a)) {
                res.add(new Chemin(this, a));
            }
        }
        return res;
    }

    @Override
    public Iterator<Sommet> iterator() {
        return sommets.iterator();
    }

    @Override
    public int compareTo(Chemin o) {
        int res = this.distanceTot - o.distanceTot;
        if (res == 0) {
            res = sommets.size() - o.sommets.size();
            if (res == 0) {
                Iterator<Sommet> i1 = this.iterator();
                Iterator<Sommet> i2 = o.iterator();
                while (i1.hasNext()) {
                    res = i1.next().getNom().compareTo(i2.next().getNom());
                    if (res != 0) {
                        return res;
                    }
                }
            }
        }
        return res;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{[");
        for (Sommet s : sommets) {
            sb.append(s);
            sb.append(',');
        }
        sb.setCharAt(sb.length() - 1, ']');
        sb.append(", d=");
        sb.append(distanceTot);
        sb.append('}');
        return sb.toString();
    }

}

