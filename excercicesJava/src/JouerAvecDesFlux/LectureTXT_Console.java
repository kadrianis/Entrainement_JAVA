package JouerAvecDesFlux;

import java.io.*;

public class LectureTXT_Console {
	public static void main(String args[]) {
		try {
			File file = new File("C:\\Users\\KADRI\\Desktop\\fic.txt");
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			String line;
			
			while ((line = br.readLine()) != null) {
				// ajoute la ligne au buffer
				sb.append(line);
				sb.append(" ");
			}
			
			fr.close();
			System.out.println("Contenu du fichier: ");
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}