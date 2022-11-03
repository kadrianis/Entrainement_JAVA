package _LabWorks.Cooccurrences01;

import java.io.IOException;
import java.nio.file.*;
import java.util.Set;
import java.util.TreeMap;

public class AnalyseTexte {

	public static void main(String[] args) throws IOException {
		Path p = Paths.get(args[0]);

		if (!Files.exists(p)) {
			System.err.println("Le fichier " + p + " n'existe pas");
			System.exit(0);
		}

		try (WordReader wr = new WordReader(Files.newBufferedReader(p))) {
			CooccurrenceSim cs = new CooccurrenceSim();
			String mot = wr.readWord();
			while (mot != null) {
				cs.pushWord(mot);
				mot = wr.readWord();
				
			}
			
			TreeMap<Double,Set<Pair<String>>> res = cs.getSims();
			
			while (!(res.isEmpty())) {
				Double cle = res.lastKey();
				for(Pair x : res.get(cle)) {
					//je parcours les pair de la set 
					System.out.println(" "+ x + " "); 
				}
				res.remove(cle);
			}

			
		}
	}
}
