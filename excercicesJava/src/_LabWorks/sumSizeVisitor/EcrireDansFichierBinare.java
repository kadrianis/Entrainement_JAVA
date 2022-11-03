package _LabWorks.sumSizeVisitor;

import java.io.*;
import java.nio.file.*;

public class EcrireDansFichierBinare {

	public EcrireDansFichierBinare() {
// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		if (args.length < 1) { // peut on faire args == null ??

			System.err.println("Usage : java " + EcrireDansFichierBinare.class.getName() + " fichier texte");

			System.exit(1); // sortie du programme

		}

// 2eme condition

		Path p = Paths.get(args[0]);

// tester si l'argument est un dossier

		if (!Files.exists(p)) {

			System.err.println(p + " already exists, i will not erase it");

			System.exit(2);
		}
		try (OutputStream dos = new DataOutputStream(Files.newOutputStream(p))) {
			for (int i = 0; i < 100; i++) {
				dos.write(1000000);
				((DataOutputStream) dos).writeBoolean(false);
				dos.write('e');
				((DataOutputStream) dos).writeUTF(null);

			}
		}

	}

}