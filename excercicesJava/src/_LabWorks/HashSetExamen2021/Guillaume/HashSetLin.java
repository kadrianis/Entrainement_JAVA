package _LabWorks.HashSetExamen2021.Guillaume;

public class HashSetLin<T> {

    private EntreeAbstraite<T>[] rep;
    private int nbEntrees;

    public HashSetLin(int n) {
        // pourquoi le super est g�n�r� tout seul
        // super();
        this.nbEntrees = n;
        rep = new EntreeAbstraite[n];
        for (int i = 0; i < rep.length; i++) {
            rep[i] = EntreeLibre.getInstance();
        }
    }

    private void reHash() {
        // je m occupe que d agrandir le tableau et non pas qu il soit plein ou pas
        EntreeAbstraite<T>[] copie = new EntreeAbstraite[this.nbEntrees + (nbEntrees / 2)];
        for (int i = 0; i < rep.length; i++) {
            this.add(rep[i].get()); // renvoie null si c est un emplacement libre sinon
        }

    }

    public boolean add(T t) {
        // parcours � la recherche de t
        int indexHash = t.hashCode();
        int i, compt = 0;

        for (i = indexHash; compt != rep.length && rep[i] != EntreeLibre.getInstance(); i = (i + 1) % rep.length) {
            compt++;
            if (rep[i].equals(t)) {
                return false; // existe on ajoute pas
            }
        }
        // rep[i]==EntreeLibre.getInstance() :on est tomb� sur un entr� libre
        if (rep[i] == EntreeLibre.getInstance()) {
            rep[i] = new Entree(t);
            return true;
        } else {
            reHash();
            add(t);// ajout dans le tableau --> reprends tous car l'organisation du tableau n est
            // plus la meme
            return true;
        }
    }

    public boolean remove(T t) {
        //TODO
        return true;
    }

    public String tostring() {
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < rep.length; i++) {
            res.append(rep[i].toString() + ", ");
            // res.append(",");
        }
        res.delete(res.length() - 2, res.length());
        res.append(" ]");
        return res.toString();
    }

}
