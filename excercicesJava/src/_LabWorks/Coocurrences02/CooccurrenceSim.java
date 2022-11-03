package _LabWorks.Coocurrences02;

import java.util.*;
public class CooccurrenceSim {

	
	
	/* Permet d'associer � chaque paire de mots, son nombre de cooccurrences*/

	private Map<Pair<String>, Integer> cooccurrences = new HashMap <>() ;

	
	/* Permet d'associer � chaque mot, son nombre d'occurrences */

	private Map<String, Integer> occurrences = new HashMap <>()  ;

	
	
	private int nbOccurrences = 0;
	private String previous = null;
	
	
	public void pushWord(String word) {
		/**
		 * Permet d'ajouter un mot. Les dictionnaires occurrences 
		 * et cooccurrences sont mis � jour ainsi que nbOccurrences et previous
		 */
		if (occurrences.containsKey(word))
		occurrences.put(word,occurrences.get(word)+1);
		else 
			occurrences.put(word,1);
		
		Pair<String> p = new Pair<>(word,previous);
		
		if (cooccurrences.containsKey(p))
			cooccurrences.put(p,cooccurrences.get(p)+1);
		else cooccurrences.put(p,1);

		nbOccurrences++;	
		
	}

	
	
	public double getSim(String w1, String w2) {	
	/* calcule l'association entre deux mots */

		return getSim(new Pair<>(w1, w2));	
	}
	
	
	
	private double getSim(Pair<String> p) {
	/* calcule l'association entre deux mots */

	if (!cooccurrences.containsKey(p)) {
	return -1;
	}
	int cooc = cooccurrences.get(p);
	int occw1 = occurrences.get(p.getE1());
	int occw2 = occurrences.get(p.getE2());
	double freq = (double) cooc / nbOccurrences;
	double pmi = Math.log(((double) (cooc * nbOccurrences)) 
	/ (occw1 * occw2));
	return pmi/-Math.log(freq); //  c'est quoi �a ??
	}
	
	
	
	
	
	public TreeMap<Double,Set<Pair<String>>> getSims() {
	/* Retourne un dictionnaire qui indexe les cooccurrences en fonction
	* de leur valeur d'association (i.e. la valeur retourn�e par getSim */
		
		
		// TODO a faire
				return null;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
