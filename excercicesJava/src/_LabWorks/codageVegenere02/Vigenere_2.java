package _LabWorks.codageVegenere02;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


class VigenereWriter extends FilterWriter {

	private String key;
	private int idx;
	
	protected VigenereWriter(Writer out, String key) {
		super(out);
		this.key=key;
		idx=0;
	}

	@Override
	public void write(int c) throws IOException {
		this.write(new char[] {(char) c},0,1);
	}
	
	/**
	 * PRE CONDITION : c doit etre un caractere entre a et z ou A et Z
	 * @param c
	 * @return
	 */
	private char encode(char c) {
		char a = 'a';
		if (Character.isUpperCase(c)) {
			a='A';
		}
		char res = (char) ((( (c-a) + (key.charAt(idx)-a)) % 26 ) +a);
		
		idx = (idx +1) % key.length();
		return res;
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		for (int i=off ; i<off+len ; i++) {
			// encode mon caractère
			if ( (cbuf[i]>='a' && cbuf[i]<='z') || (cbuf[i]>='A' && cbuf[i]<='Z')) {
				cbuf[i]=encode(cbuf[i]);
			}
			
		}
		super.write(cbuf, off, len);
	}

	@Override
	public void write(String str, int off, int len) throws IOException {
		this.write(str.toCharArray(), off, len);
	}
}

class VigenereReader extends FilterReader {

	private String key;
	private int idx;
	
	protected VigenereReader(Reader in, String key) {
		super(in);
		this.key=key;
		idx=0;
	}
	
	/**
	 * PRE CONDITION : c doit etre un caractere entre a et z ou A et Z
	 * @param c
	 * @return
	 */
	private char decode(char c) {
		char a = 'a';
		if (Character.isUpperCase(c)) {
			a='A';
		}
		char res = (char) ((( (c-a) - (key.charAt(idx)-a) + 26) % 26 ) +a);
		
		idx = (idx +1) % key.length();
		return res;
	}

	@Override
	public int read() throws IOException {
		int c = super.read();
		if (c>-1) {
			if ( (c>='a' && c<='z') || (c>='A' && c<='Z')) {
				return decode((char) c);
			}
		}
		return c;
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int nb = super.read(cbuf, off, len);
		
		for (int i=off ; i<off+nb ; i++) {
			// encode mon caractère
			if ( (cbuf[i]>='a' && cbuf[i]<='z') || (cbuf[i]>='A' && cbuf[i]<='Z')) {
				cbuf[i]=decode(cbuf[i]);
			}
			
		}
		return nb; 
	}
	
	
	
}

public class Vigenere_2 {

	/**
	 * java ...Vigenere  [-e | -d] passphrase file.txt result.txt
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		if (args.length != 4) {
			System.err.println("Usage: java " + Vigenere_2.class.getName() + " [-e | -d] passphrase file.txt result.txt");
			System.exit(1);
		}
		if (!("-e".equals(args[0]) || "-d".equals(args[0]))) {
			System.err.println("Usage: java " + Vigenere_2.class.getName() + " [-e | -d] passphrase file.txt result.txt");
			System.exit(2);
		}
		
		
		for (int i=0 ; i<args[1].length() ; i++) {
			if (!( (args[1].charAt(i)>='a' && args[1].charAt(i)<='z') || (args[1].charAt(i)>='A' && args[1].charAt(i)<='Z'))) {
				System.err.println("The passphrase must contains only letter (without accents): "+args[1]);
				System.exit(5);
			}
		}
		
		String passphrase = args[1];

		Path input = Paths.get(args[2]);
		
		if (!Files.exists(input)) {
			System.err.println("Error: "+input+" does not exist");
			System.exit(3);
		}
		
		if (!Files.isRegularFile(input)) {
			System.err.println("Error: "+input+" is not a regular file");
			System.exit(4);
		}
		
		
		Path output = Paths.get(args[3]);
		Reader r=null;
		Writer w=null;
		try {
			r = Files.newBufferedReader(input);
			w = Files.newBufferedWriter(output);
			if ("-e".equals(args[0])) {
				w = new VigenereWriter(w,passphrase);
			} else {
				r = new VigenereReader(r,passphrase);
			}
			
			Scanner sc = new Scanner(r);
			PrintWriter pw = new PrintWriter(w);
			
			while (sc.hasNext()) {
				pw.println(sc.nextLine());
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (r!=null) {
				r.close();
			}
			if (w!=null) {
				w.close();
			}
		}
		
		

	}

}
