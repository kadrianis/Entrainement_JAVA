package _LabWorks.jouerAvecLesPiles;

public class ElementPile {

    private int valeur;

    public ElementPile() {
        this.valeur = 0;
    }

    public ElementPile(int valeur) {
        this.valeur = valeur;
    }

    public int getValue() {
        return valeur;
    }

    public void afficheEl() {
        System.out.print(" " + valeur);
    }

    public static void main(String[] args) {

        ElementPile e1 = new ElementPile(5);
        ElementPile e2 = new ElementPile(2);
        ElementPile e3 = new ElementPile(9);
        ElementPile e4 = new ElementPile(10);

    }

}

