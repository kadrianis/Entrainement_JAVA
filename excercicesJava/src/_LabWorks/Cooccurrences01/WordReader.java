package _LabWorks.Cooccurrences01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordReader extends FilterReader {
	

	private StringBuilder sb;

	public WordReader(Reader in) {
		
		super(in);
	}

	
	public String readWord() throws IOException {

		int c = in.read();

		while (((!(Character.isLetterOrDigit(c))) && c != -1)) {
			c = in.read();
		}

		if (c == -1)
			return null;

		sb = new StringBuilder();
		while (Character.isLetterOrDigit(c)) {
			sb = sb.append((char) c);
			c = in.read();

		}
		return sb.toString();

	}

	public static void main(String[] args) throws IOException {
		Path p = Paths.get("anis.txt");
		WordReader r = new WordReader(Files.newBufferedReader(p));
		// il prends un reader en paramettre, je le cr�e 
		String c = r.readWord();

		while (c != null) {
			System.out.print(c + " " );
			// System.out.println();
			c = r.readWord();
		}

	}

}
