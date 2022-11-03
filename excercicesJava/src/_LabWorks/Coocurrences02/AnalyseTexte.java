package _LabWorks.Coocurrences02;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;

public class AnalyseTexte {
	
	// Elle ouvre et lit fichier texte donn� en param�tre et affiche ensuite le dictionnaire des valeurs
	// d'association et les cooccurrences associ�es dans l'ordre d�croissant des valeurs

	public static void main(String[] args) {
		Path p = Paths.get(args[0]);

		if (!Files.exists(p)) {
			System.err.println("Le fichier "+p+" n'existe pas");
			System.exit(0);}

		try (WordReader wr = new WordReader(Files.newBufferedReader(p))){
			
		}
			
		catch (IOException e) {
			System.err.println("Une erreurs s'est produite"+ " lors de la lecture du fichier");
			e.printStackTrace();
					}
	}
}
