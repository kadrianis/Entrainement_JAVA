package occuranceChar;
import java.util.Scanner;

public class NbOccuranceChar_2 {

    public static void NbOccuranceChar_2_methode() {
        //Lire un caractére, puis une chaine de caractéres, et afficher le nombre
        //d'occurrences du caractére dans la chaine de caractéres.
        // TODO a revoir aussi

        Scanner sc = new Scanner(System.in);
        System.out.println("entrer un caract�re");
        char c = sc.next().charAt(0);

        System.out.println("Entrez une chaine de caract�res");
        String s = sc.next();
        int j = 0;

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == c) {
                j = j + 1;
            }
        System.out.print(j);
    }

    public static void main(String[] args) {
        NbOccuranceChar_2_methode();
    }
}
