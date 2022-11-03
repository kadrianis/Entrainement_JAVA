package _LabWorks.HashSetExamen2021.Anis;

public class HashSetLin<T> {

    private EntreeAbstraite<T>[] rep;
    private int nbEntrees;

    public HashSetLin() {
        // j'ai rajout� de ma tete
        super();
        this.nbEntrees = nbEntrees;
    }

    public HashSetLin(int n) {
        super();
        this.nbEntrees = n;
        rep = new EntreeAbstraite[n];
        for (int i = 0; i < rep.length; i++) {
            rep[i] = EntreeLibre.getInstance();
            // Attention : constructeur non visible et le static m'aide beaucoups
        }
    }

    private void reHash() {
        // j'agrandis et je rajoute de nouveau
        EntreeAbstraite<T>[] newRep = new EntreeAbstraite[(rep.length * 3) / 2];
        // tout est entier, j'ai agrandi ; ou bien (this.nbEntrees + nbEntrees/2) ou
        // meme n
        // attention les getters et les static
        for (int i = 0; i < rep.length; i++) {
            this.add(rep[i].get());
            // que quand il est full donc l'appel get concernera toujours l'entree
        }
        this.rep = newRep;
    }

    public String tostring() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < rep.length; i++) {
            sb.append(rep[i] + ", ");
        }
        sb.delete(rep.length - 2, rep.length);
        sb.append("]");
        return sb.toString();
    }

    private boolean estPresent(T t) {
        for (int i = 0; i < rep.length; i++) {
            if (rep[i].equals(t))
                return true;
        }
        return false;
    }

    private boolean estFull(EntreeAbstraite[] t) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] == EntreeLibre.getInstance())
                return false;
        }
        return true;
    }

    public boolean add(T t) {
        int index = (t.hashCode()) % rep.length;
        boolean capaciy = estFull(rep);
        boolean presence = estPresent(t);
        if (!(capaciy || presence)) {
            if (rep[index] == EntreeLibre.getInstance()) {
                rep[index] = new Entree(t);
            }
            return true;
        }

        if (!estPresent(t)) {
            if (estFull(rep)) {
                reHash();
                if (rep[index] != EntreeLibre.getInstance()) {
                    int count = 0;
                    int i;
                    for (i = index; count < rep.length; i = (i + 1) % rep.length) {
                        count++;
                        if (rep[i] == EntreeLibre.getInstance())
                            break;
                    }
                    rep[i] = new Entree(t);
                } else {
                    rep[index] = new Entree(t);
                }
            } else {
                add(t);
            }

        }
        boolean res;

        return false;
    }
}



