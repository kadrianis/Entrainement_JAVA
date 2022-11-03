package JouerAvecDesFlux;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LireFichierString {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path p = Paths.get("C:\\Users\\KADRI\\Desktop\\fic.txt");
		Reader r  = Files.newBufferedReader(p);
		char[] tab = new char[1024];  // risqu�
		StringBuilder sb = new StringBuilder();
		int n =r.read(tab);
		while(n!=-1) {
			sb.append(tab, 0, n);
			n =r.read(tab); // j'avance
		}
		System.out.println(sb.toString());
		r.close(); // garantir que la ressource que j'ai demand� pour pouvoir lire a bien �t� ferm�
	}

}
