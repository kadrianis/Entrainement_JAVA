package InverserChaines;

import java.util.Arrays;
import java.util.Scanner;

public class version1_InverserChaines {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int nbLinges = sc.nextInt();
        String[] tableauInput = new String[nbLinges];
        for (int i = 0; i < nbLinges; i++) {
            tableauInput[i] = sc.next();
        }
        for (int j = 0; j < nbLinges; j++) {
            String temp = "";
            int longueurString = tableauInput[j].length();
            for (int k = longueurString - 1; k >= 0; k--) {
                temp += tableauInput[j].charAt(k);
            }
            tableauInput[j] = temp;
        }
        System.out.println(Arrays.toString(tableauInput));
        for (String s : tableauInput) {
            System.out.println(s);
            //Arrays.toString(tableauInput);

        }
    }
}