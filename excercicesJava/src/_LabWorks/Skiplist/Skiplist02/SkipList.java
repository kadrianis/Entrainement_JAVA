package _LabWorks.Skiplist;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SkipList<T extends Comparable<T>> extends AbstractSet<T> {

	// --------------------------------------------attributs	// ----------------------//
	private int max;
	private int taille;
	private ChainonDebut<T> debut;
	// --------------------------------------------constructeurs	// ----------------------//

	public SkipList() {
		this(5);
	}

	public SkipList(int max) {
		if (max < 1)
			throw new IllegalArgumentException("max > 1");
		this.max = max;
		this.debut = new ChainonDebut<T>(max);
	}

	// --------------------------------------------methodes ----------------------//

	private static int tailleAlea(int max) {
		Double mr = Math.random();
		int compt = 1;
		while (mr < 0.5) {
			compt++;
			mr = Math.random();
		}

		compt++;

		return (compt > max ? max : compt);

	}

	public int size() {
		return taille;
	}

	public boolean add(T e) {
		// cr�ation d'un nouveau cha�non
		Chainon<T> nouveau = new Chainon<>(tailleAlea(max), e);
		// tableau pour la mise � jour des r�f�rences suivants
		ChainonDebut<T>[] maj = new ChainonDebut[max];
		// recherche de courant tel que courant.suivant >= nouveau
		ChainonDebut<T> courant = debut;

		for (int i = courant.suivants.length - 1; i >= 0; i--) {
			int r = courant.suivants[i].compareTo(nouveau);
			while (r < 0) {
				courant = (ChainonDebut<T>) courant.suivants[i];
				r = courant.suivants[i].compareTo(nouveau);
			}
			if (r == 0)
				return false;// la valeur a est d�j� pr�sente dans la liste
			maj[i] = courant;
		}
		// cha�nage du nouveau cha�non
		for (int i = 0; i < nouveau.suivants.length; i++) {
			nouveau.suivants[i] = maj[i].suivants[i];
			maj[i].suivants[i] = nouveau;
		}
		taille += 1;
		return true;
	}

	public boolean contains(Object o) {
		return false;
	}

	public Iterator<T> iterator() {

		return new Iterator<T>() {// classe que tu definie au meme temps que tu l instancie
			// garder une trace ----- previous
			ChainonAbstrait<T> current = debut.suivants[0];

			public boolean hasNext() {
				// si le prochaine n'est pas null
				return false; // TODO
			}

			public T next() {
				// retourne l'�lement courant
				if (current instanceof ChainonFin)
					throw new NoSuchElementException();
				else {
					T resultat = (((Chainon<T>) current).element);
					current = ((Chainon<T>) current).suivants[0];

					return resultat;
				}
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public T last() {
		return null;
	}

}
