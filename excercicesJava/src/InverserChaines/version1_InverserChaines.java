package InverserChaines;

import java.util.Scanner;

public class version1_InverserChaines {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int nbLinges = sc.nextInt();
        String[] tableauInput = new String[nbLinges];

        for (int i = 0; i < nbLinges; i++) {
            tableauInput[i] = sc.nextLine();
        }

        for (int i = 0; i < nbLinges; i++) {
            String temp="";
            int longueurString = tableauInput[i].length();

            for (int j = longueurString - 1; j >= 0; j--) {

                temp += tableauInput[i].charAt(j);
            }
            tableauInput[i] = temp;
        }
        for (String sas : tableauInput) {
            System.out.println(sas);
        }
    }
}