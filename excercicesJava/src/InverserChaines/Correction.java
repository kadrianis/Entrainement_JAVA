package InverserChaines;

import java.util.Scanner;

public class Correction {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int nbLignes = input.nextInt();
        for (int iLigne = 0; iLigne < nbLignes; iLigne = iLigne + 1) {
            String ligne = input.nextLine();
            for (int iCar = ligne.length() - 1; iCar >= 0; iCar = iCar - 1) {
                System.out.print(ligne.charAt(iCar));
            }
            System.out.println("");
        }
    }
}