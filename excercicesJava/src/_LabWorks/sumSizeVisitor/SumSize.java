package sumSizeVisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumSize {

	public SumSize() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// tester la longueur des arguments
		if (args.length < 1) { // peut on faire args == null ??
			System.err.println("Usage : java " + SumSize.class.getName() + " dir");
			System.exit(1); // sortie du programme
		}

		Path p = Paths.get(args[0]);
		// tester si l'argument est un dossier
		if (!Files.isDirectory(p)) {
			System.err.println(p + " Is not a diectory");
			System.exit(2);
		}
		// on instantie un objet de la classe SumSizeVisitor // visiter le repertoire p
		SumSizeFileVisitor v = new SumSizeFileVisitor();

		try {
			Files.walkFileTree(p, v);
			// System.out.println(Files.size(p));
			System.out.println("La taille de " + p + " est " + v.taille);// taille est l'attribut de la la classe
																			// SumSizeFileVisitor
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
