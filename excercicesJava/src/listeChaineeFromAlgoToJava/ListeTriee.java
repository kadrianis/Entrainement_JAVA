package listeChaineeFromAlgoToJava;

public class ListeTriee {

    // ----------------------------------------Attribut ----------------------------------------//

    private Doublet tete, queue;

    // --------------------------------------Constructeur --------------------------------------//

    public ListeTriee() {
        // �a cree une liste vide
        tete = null;
        queue = null;
    }

    // -----------------------------------------Methodes----------------------------------------//

    public void inserer(int e) {
        // ins�re e dans la liste tri�e
        Doublet k, a, p; // doublet cr��, courant, pr�c�dent
        k = new Doublet(e);
        a = tete;
        p = null;
        while ((a != null) && (a.el < e)) {
            p = a;
            a = a.suiv;
        }
        // a = null || a.el >= e : on place e avant a => apr�s p
        if (p == null) {
            k.suiv = tete;
            tete = k;
        } else {
            k.suiv = a;
            p.suiv = k;
        }
    }

    public void inserer2(int e) {
        tete = insererrec(e, tete);
    }

    private Doublet insererrec(int e, Doublet t) {
        Doublet a; // doublet cr��
        if ((t != null) && (e > t.el)) {
            t.suiv = insererrec(e, t.suiv);
        } else {
            a = new Doublet(e);
            a.suiv = t;
            t = a;
        }
        return (t);
    }

    public void afficher() {
        Doublet a = tete;
        while (a != null) {
            System.out.print(a.el + " ");
            a = a.suiv;
        }
        System.out.println();
    }

    public void ajoutQueue(int e) {
        Doublet k = new Doublet(e);
        if (tete == null) {
            tete = k;
            queue = tete;
        } else {
            queue.suiv = k;
            queue = k;
        }
    }

    private Doublet eltc; // �l�ment courant pour parcours de la liste

    public Doublet eltc() {
        return eltc;
    }

    public void demarrer() {
        eltc = tete;
    }

    public void avancer() {
        eltc = eltc.suiv;
    }

    public void intersection(ListeTriee l1, ListeTriee l2) {
        Doublet a1, a2; // el�ments courants de l1, l2
        tete = new Doublet(0); // �l�ment fictif en t�te
        queue = tete;
        a1 = l1.tete;
        a2 = l2.tete;
        while ((a1 != null) & (a2 != null)) {
            if (a1.el < a2.el) {
                a1 = a1.suiv;
            } else {
                if (a1.el > a2.el) {
                    a2 = a2.suiv;
                } else {
                    // a1.el == a2.el
                    queue.suiv = new Doublet(a1.el);
                    queue = queue.suiv;
                    a1 = a1.suiv;
                    a2 = a2.suiv;
                }
            }
        }
        // a1 == null | a2 == null
        queue.suiv = null;
        tete = tete.suiv; // �l�ment fictif supprim� et r�cup�r� par le garbage collector !
    }

    // ---------------------------Partie Anis -----------------------------------//

    // revoire les videos jma

    public void intersection2(ListeTriee l1, ListeTriee l2) {
        tete = intersection(l1.tete, l2.tete);
    }

    private Doublet intersection(Doublet t1, Doublet t2) {
        // cr�er la liste des elements communs entre t1 et t2

        Doublet t;
        Doublet a;
        if (t1 == null || t2 == null) {
            t = null; // la liste cr�e est vide
        } else {
            if (t1.el < t2.el) {
                t = intersection(t1.suiv, t2);
            } else {
                if (t1.el > t2.el) {
                    t = intersection(t1, t2.suiv);
                } else {
                    t = new Doublet(t1.el);
                    t.suiv = intersection(t1.suiv, t2.suiv);
                }
            }
        }
        return t;
    }


}
