package _LabWorks.Skiplist.Skiplist01;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SkipList<T extends Comparable<T>> extends AbstractSet<T> {
	private int max;
	private int taille;
	private ChainonDebut<T> debut;

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}


	// -------------------------------------------constructeurs-------------------------------------//

	/*public SkipList() {
		this(5);
	}*/

	/*

	public SkipList(int max) {
		if (max < 1)
			throw new IllegalArgumentException("max doit etre");
		debut = new ChainonDebut<T>(max);
		this.max = max;
		this.taille = 0;
		this.debut = new ChainonDebut<T>(max);

	}

	// -------------------------------------------Methodes-------------------------------------//

	private static int tailleAlea(int max) {
		int i = 0;
		for (i = 1; i < max - 1 || Math.random() < 0.5; i++)
			;
		return i;

	}

	public int size() {
		return taille;
	}

	public boolean add(T e) {
// création d'un nouveau chaînon
		Chainon<T> nouveau = new Chainon<>(tailleAlea(max), e);
// tableau pour la mise à jour des références suivants
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
				return false;// la valeur a est déjà présente dans la liste
			maj[i] = courant;
		}
// chaînage du nouveau chaînon
		for (int i = 0; i < nouveau.suivants.length; i++) {
			nouveau.suivants[i] = maj[i].suivants[i];
			maj[i].suivants[i] = nouveau;
		}
		taille += 1;
		return true;
	}

	public Iterator<T> iterator() {
		return new Iterator<T>() {
			ChainonAbstrait<T> current = debut.suivants[0];

			public boolean hasNext() {
				return current != ChainonFin.getInstance();
				// pas d'exception
			}

			public T next() {
				if (current instanceof ChainonFin)
					throw new NoSuchElementException();
				T result = ((Chainon<T>) current).element;
				current = ((Chainon<T>) current).suivants[0];
				return result;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

//-----------------------a faire--------------------------------------------//

	public boolean contains(Object o) {
		ChainonDebut<T> courant = debut; // commence au debut
		for (int i = courant.suivants.length - 1; i >= 0; i--) {
			int r = 1;
			if (courant.suivants[i] != ChainonFin.getInstance()) {
				r = ((Chainon<T>) courant.suivants[i]).element.compareTo((T) o);
			} else {
				r = 1;
			}

		}

		if (r == 0)
			return true;

		return false;
	}


//-------------------------------------------------------------------//

	public T last() {
		ChainonDebut<T> courant = debut; // commence au debut
		for (int i = courant.suivants.length - 1; i >= 0; i--) {
			if (courant.suivants[0] == ChainonFin.getInstance()) {
				if (courant instanceof Chainon) {
					return ((Chainon<T>) courant).element;
				} else {
					return null;
				}
			}
			return null;

		}
		return null;
	}
	if(courant.suivants[i]!=ChainonFin.getInstance())

	{
		courant = (Chainon<T>) courant.suivants[i];
	}

}



// question cours
// 1 n ettends pas comparable  
//2 droit de le faire -- ineteger est comparable
// 3 on a le droit -- implement set
//4 -  n implement pas list
//5 set est une collection on peut faire ca -- skiplist set et set est une collection
// 6 ensembre ordonnée et elle ettend abstract set mais  malgré ça on a pas skiplist etends abstract set et non pas 


// une implementation complete est une treeset

*/
}


