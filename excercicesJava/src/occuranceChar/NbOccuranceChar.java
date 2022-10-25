package occuranceChar;

import java.util.Scanner;

public class NbOccuranceChar {

    public static void nbOccuranceChar() {
        //TODO a revoir
        //Lire un caractére, puis une chaine de caractéres, et afficher le nombre
        //d'occurrences du caractére dans la chaine de caractéres.
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer un caractére");
        char c = sc.next().charAt(0); // premier char ?? comment limiter le input a un seul char ??
        System.out.println("Entrez une chaine de caractéres");
        String s = "";
        while(sc.hasNext()){
            s+=sc.next();
            System.out.println(s);
        }

        sc.close();
        int j = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == c) {
                j = j + 1;
            }
        System.out.print(j);
    }






    public static void main(String[] args) {
        nbOccuranceChar();
    }
}
