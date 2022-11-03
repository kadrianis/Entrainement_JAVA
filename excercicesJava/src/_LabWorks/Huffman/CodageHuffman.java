package _LabWorks.Huffman;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class CodageHuffman<E> implements Serializable {
	private List<E> elems;
	private NoeudAbstrait<E> tree;

	private CodageHuffman() {
	}

	public CodageHuffman(List<E> list) {
		// minimum 2 elements differents  et non vide
		elems = list;
		Map<E, Integer> occ = compteOccurrences();
		buildTree(occ);
		// taille de occ est au moins deux
	}

private Map<E, Integer> compteOccurrences() {
	// creer une Map et la renvoyer comme resultat 
	return null;}

private void buildTree(Map<E, Integer> occ) {
	ListeTriee <NoeudAbstrait<E>> l = new ListeTriee<>();
	for(Map.Entry<E, Integer> ent : occ.entrySet()) {
		l.add(new Feuille <E>(ent.getKey(),ent.getValue()));}
	while (l.size()>1) { // j'ai au moins deux elements
		NoeudAbstrait<E> m1 = l.removeFirst();
		NoeudAbstrait<E> m2 = l.removeFirst();
		l.add(new NoeudBinaire <E>(m1,m2));
	}
	tree = l.removeFirst();
	// au final reste que l'arbre
}

	public List<E> getDecodedElements() {
		return elems;
	}

private void writeObject(ObjectOutputStream out) throws IOException {

// utiliser la m�thode ecrireChaineBinaire pour ecrire un element encod�
// n�cessaire pour vider le buffer � la fin
	
	// TODO
videEtPadding(out);
}

	private transient StringBuffer buffer;

	public void ecrireChaineBinaire(String s, ObjectOutputStream out) throws IOException {
		if (!s.matches("^[0-1]*$"))
			new IOException("La chaine est invalide");
		if (buffer == null)
			buffer = new StringBuffer();
		buffer.append(s);
		while (buffer.length() > 7) {
			int b = Integer.parseInt(buffer.substring(0, 8), 2);
			out.write(b);
			buffer.delete(0, 8);
		}
	}

	public void videEtPadding(ObjectOutputStream out) throws IOException {
		if (buffer != null && buffer.length() > 0) {
			for (int i = buffer.length(); i < 8; i++)
				buffer.append('0');
			int b = Integer.parseInt(buffer.substring(0, 8), 2);
			out.write(b);
			buffer = null;
		}
	}

private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
// TODO
}

	private final class HuffmanIterator implements Iterator<Boolean> {
		private byte current;
		private byte readed = 8;
		private InputStream is;

		HuffmanIterator(InputStream is) {
			this.is = is;
		}

		public boolean hasNext() {
			if (readed == 8) {
				int lu = -1;
				try {
					if ((lu = is.read()) == -1)
						return false;
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
				current = (byte) lu;
				readed = 0;
			}
			return true;
		}

		public Boolean next() {
			hasNext();
			boolean b;
			if ((current & 128) == 128)
				b = true;
			else
				b = false;
			current <<= 1;
			readed++;
			return b;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
