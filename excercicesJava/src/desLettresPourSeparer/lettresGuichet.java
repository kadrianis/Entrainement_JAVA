package desLettresPourSeparer;

import java.util.Scanner;

public class lettresGuichet {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String nomEtudiant = sc.next();
        char c = nomEtudiant.charAt(0);
        if(c>'Z' || c<'A')
            throw new IllegalArgumentException("faut donner une lettre entre A ...Z");
        if (c > 'P')
                System.out.println(3);
            else if (c <= 'P' && c > 'F')
                System.out.println(2);
            else
                System.out.println(1);
        }
    }



