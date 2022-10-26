package jouerAvecDesLCollections;

import java.util.*;

class Etudiant implements Comparable<Etudiant> {
    private String ine;
    private String nom;
    private String prenom;

    public Etudiant(String ine, String nom, String prenom) {
        this.ine = ine;
        this.nom = nom;
        this.prenom = prenom;
    }

    public boolean equals(Object o) {
        if (o instanceof Etudiant) {
            Etudiant e = (Etudiant) o;
            return this == e || ine.equals(e.ine);
        }
        return false;
    }

    public int hashCode() {
        return ine.hashCode();
    }

    public String toString() {
        return "Etudiant n�" + ine + " (" + prenom + "," + nom + ")";
    }

    public int compareTo(Etudiant o) {
        int comp = nom.compareTo(o.nom);
        if (comp == 0) {
            comp = prenom.compareTo(o.prenom);
            if (comp == 0) {
                comp = ine.compareTo(o.ine);
            }
        }
        return comp;
    }
}

public class OpeationHashSet {
    public static void main(String[] args) {
        Etudiant e1 = new Etudiant("45677", "aa", "vv");
        Etudiant e2 = new Etudiant("12345", "Basile", "Durand");
        Etudiant e3 = new Etudiant("7777", "uuu", "zzzz");
        Etudiant e4 = new Etudiant("88888", "ttt", "xxxx");

        // deux objet different mais le equals renvoie true car c est le meme ine
        Set<Etudiant> promoDciss = new HashSet<Etudiant>();
        promoDciss.add(e1);
        promoDciss.add(e2);
        promoDciss.add(e3);
        promoDciss.add(e4);

        SortedSet<Etudiant> sortedSet3 = new TreeSet<>(promoDciss);
        System.out.println(sortedSet3);

    }
}