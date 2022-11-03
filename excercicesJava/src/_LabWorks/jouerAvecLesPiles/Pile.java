package _LabWorks.jouerAvecLesPiles;

public class Pile {
    private int pos;
    // position dans le tableau
    private ElementPile[] p;

    public Pile() { // creation d�une pile vide de taille 10
        p = new ElementPile[10];
        pos = 0;
    }

    public Pile(int taille) { // creation d�un pile vide de taille donnee
        p = new ElementPile[taille];
        pos = 0;

    }

    public void empile(ElementPile e) {
        //verifier s'il y a de l'espace puis ajouter 'e' dans la pile
        if (pos == p.length) {
            ElementPile[] tmp = new ElementPile[p.length + 10];
            for (int i = 0; i < p.length; i++)
                tmp[i] = p[i];
            p = tmp;
        }
        p[pos++] = e;
    }

    public ElementPile depile() {
        if (estVide()) {
            return null;
        }
        return p[--pos];
    }

    public ElementPile sommet() {
        if (!estVide()) {
            return p[pos - 1];
        }
        return null;
    }

    public boolean estVide() {
        return pos == 0;
    }

    public void affiche() {
        System.out.print("Pile: [");
        for (int i = 0; i < pos; i++)
            p[i].afficheEl();
        System.out.println(" ]");

    }

    public static void main(String[] args) {

        Pile premeire = new Pile(10);
        //for (int i = 0; i < 10; i++)
        //premeire.p[i] = new ElementPile(i);
        ElementPile e1 = new ElementPile(1);
        ElementPile e2 = new ElementPile(2);
        ElementPile e3 = new ElementPile(3);
        ElementPile e4 = new ElementPile(55);

        premeire.empile(e1);
        premeire.empile(e2);
        premeire.empile(e3);
        premeire.empile(e4);
        premeire.affiche();
        premeire.depile();
        premeire.affiche();


    }
}

