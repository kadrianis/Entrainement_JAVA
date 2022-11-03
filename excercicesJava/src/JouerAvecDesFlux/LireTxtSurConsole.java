package JouerAvecDesFlux;
// �a marche heureusement , une lecture a partir d'un fichier , des char lu et des char affich�
import java.io.*;
import java.util.Scanner;

public class LireTxtSurConsole {

	public static void main(String[] args) {
		try (FileReader fw = new FileReader("C:\\Users\\KADRI\\Desktop\\fic.txt")) {
			Scanner sc = new Scanner(fw);
			while (sc.hasNextLine()) {
				String lu = sc.nextLine();
				System.out.println("Lu:" + lu);
			}
			sc.close();
		} catch (Exception e) {
			System.err.println("probleme");
		}
	}
}
