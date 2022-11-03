package _LabWorks.Huffman;

import java.io.Serializable;
import java.util.*;

public abstract class NoeudAbstrait<E> implements Comparable<NoeudAbstrait<E>>, Serializable {
	private int nbOcc;
	
// --------------------------Constructeur--------------------------// 

	
public NoeudAbstrait(int nbOcc) {
	// TODO
}

// --------------------------Methodes--------------------------// 


public int getNbOcc() {
	// TODO

	return 0;
}

public int compareTo(NoeudAbstrait<E> o) {
	// TODO

	return 0;
}

protected abstract void getDictionnaire(Map<E, String> dict, StringBuffer buf);
// a implementer ailleurs
	
// ---------------------------Methode donn�e--------------------------// 
	
	public Map<E, String> getDictionnaire() {
		Map<E, String> dict = new HashMap<E, String>();
		getDictionnaire(dict, new StringBuffer());
		return dict;
	}

	public abstract E decode(Iterator<Boolean> elemsCodes);
	// a implementer ailleurs
}