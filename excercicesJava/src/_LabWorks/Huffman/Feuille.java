package _LabWorks.Huffman;

import java.util.Iterator;
import java.util.Map;

public class Feuille<E> extends NoeudAbstrait<E> {

	// --------------------Attributs ------------------------//

	private E element;

	// --------------------Constructeurs ------------------------//

	public Feuille(E elem, int nbOcc) {
		super(nbOcc);

	}

	// --------------------Methodes ------------------------//

	protected void getDictionnaire(Map<E, String> dict, StringBuffer buf) {

	}

	public E decode(Iterator<Boolean> elemsCodes) {

		return null;
	}

}
