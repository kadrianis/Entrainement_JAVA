package _LabWorks.Cooccurrences01;

import java.util.*;

public class CooccurrenceSim {

	private Map<Pair<String>, Integer> cooccurrences = new HashMap<>();
	private Map<String, Integer> occurrences = new HashMap<>();
	private int nbOccurrences = 0;
	private String previous = null;

	public void pushWord(String word) {

		nbOccurrences++;

		if (occurrences.containsKey(word)) {
			occurrences.put(word, occurrences.get(word) + 1);
		} else {
			occurrences.put(word, 1);
		}

		Pair<String> doublet = new Pair(previous, word);

		if (cooccurrences.containsKey(doublet)) {
			cooccurrences.put(doublet, cooccurrences.get(doublet) + 1);
		} else {
			cooccurrences.put(doublet, 1);
		}
		previous = word;
	}

	public double getSim(String w1, String w2) {
		return getSim(new Pair<>(w1, w2));
	}

	private double getSim(Pair<String> p) {
		if (!cooccurrences.containsKey(p)) {
			return -1;
		}
		int cooc = cooccurrences.get(p);
		int occw1 = occurrences.get(p.getE1());
		int occw2 = occurrences.get(p.getE2());
		double freq = (double) cooc / nbOccurrences;
		double pmi = Math.log(((double) (cooc * nbOccurrences)) / (occw1 * occw2));
		return pmi / -Math.log(freq);
	}

	public TreeMap<Double, Set<Pair<String>>> getSims() {

		TreeMap<Double, Set<Pair<String>>> res = new TreeMap(); // j'ai une tree map
		Set<Pair<String>> s1 = cooccurrences.keySet();
		Iterator<Pair<String>> it = s1.iterator();
		while (it.hasNext()) {
			Pair<String> value = it.next();
			Double key = getSim(value);
			if (res.containsKey(key)) {
				res.get(key).add(value); // j'ajoute dans le set qui est dans la map
			} else {

				res.put(key, new HashSet<Pair<String>>());
				res.get(key).add(value);
			}

		}

		return res;

		// parcourir la map
		// verifier si la set correspondant a la valeur retourn�e par getsim appliqu� a
		// la cooccurrences existe sinon je cr�e
		// pour parcourir les cl�s d'une hashmap il faut soit : recup�rer la keyset et
		// la parcourir avec l'iterator
		// car besoin de parcourir que les pairs et non leurs occurences

	}

}
