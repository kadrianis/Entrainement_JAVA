package retirerChardeS;

import java.util.Scanner;

public class RetirerChardeS {
    public static void retirerChardeS_methode() {
    // Lire un caract�re c, puis une cha�ne de caract�res, et
    //afficher la cha�ne de caract�res lue apr�s avoir �t� de la cha�ne de caract�res toutes les occurrences du caract�re c.
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer un caract�re");
        char c = sc.next().charAt(0);
        String res = "";

        System.out.println("Entrez une chaine de caract�res");
        String s = sc.next();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                res += s.charAt(i);
            }
        }
        System.out.print(res);
    }

    public static void main(String[] args) {
        retirerChardeS_methode();
    }

}
