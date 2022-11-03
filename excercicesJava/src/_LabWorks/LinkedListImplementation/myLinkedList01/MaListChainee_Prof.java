package listeChainee;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Liste Chainée (non complète). Version du 03/03/2022
 * 
 * @author jerome david
 *
 * @param <E>
 */
public class MaListChainee_Prof<E> implements List<E> {

	private class Chainon {
		E elem;
		Chainon precedent;
		Chainon suivant;

		public Chainon() {
			elem = null;
			precedent = this;
			suivant = this;
		}

		public Chainon(E elem, Chainon precedent, Chainon suivant) {
			this.elem = elem;
			this.precedent = precedent;
			this.suivant = suivant;
		}
	}

	private class MonIterateurChaine implements ListIterator<E> {

		Chainon lastReturned; // chainon du dernier element retoiurné par next
		Chainon next;
		int nextIdx;
		boolean canModify;

		MonIterateurChaine(int index) {
			lastReturned = tete;
			if (index == nbElem) {
				next = tete;
			} else {
				next = getChainon(index);
			}
			nextIdx = index;
			canModify = false;
		}

		@Override
		public boolean hasNext() {
			return nextIdx < nbElem;
		}

		@Override
		public E next() {
			if (nextIdx >= nbElem)
				throw new NoSuchElementException();
			lastReturned = next;
			next = next.suivant;
			nextIdx += 1;
			canModify = true;
			return lastReturned.elem;
		}

		@Override
		public boolean hasPrevious() {
			return nextIdx > 0;
		}

		@Override
		public E previous() {
			if (nextIdx <= 0)
				throw new NoSuchElementException();
			// E result = lastReturned.elem;
			lastReturned = next.precedent;
			next = next.precedent;
			nextIdx -= 1;
			canModify = true;
			return lastReturned.elem;
		}

		@Override
		public int nextIndex() {
			return nextIdx;
		}

		@Override
		public int previousIndex() {
			return nextIdx - 1;
		}

		@Override
		public void remove() {
			if (!canModify) {
				throw new IllegalStateException();
			}
			MaListChainee_Prof.this.remove(lastReturned);
			nextIdx -= 1;
			canModify = false;
		}

		@Override
		public void add(E e) {
			MaListChainee_Prof.this.addBefore(e, next);
			nextIdx += 1;
			canModify = false;

		}

		@Override
		public void set(E e) {
			if (!canModify) {
				throw new IllegalStateException();
			}
			lastReturned.elem = e;
		}
	}

	private Chainon tete;
	private int nbElem;

	public MaListChainee_Prof() {
		tete = new Chainon();
		nbElem = 0;
	}

	/* METHODES UTILITAIRES */

	private E remove(Chainon c) {
		if (c == tete) {
			throw new NoSuchElementException();
		}
		E result = c.elem;
		c.precedent.suivant = c.suivant;
		c.suivant.precedent = c.precedent;
		nbElem -= 1;
		return result;
	}

	private Chainon getChainon(int idx) {
		if (idx < 0 || idx >= nbElem) {
			throw new NoSuchElementException();
		}
		if (idx < nbElem / 2) {
			Chainon c = tete.suivant;
			for (int i = 0; i < idx; i++) {
				c = c.suivant;
			}
			return c;
		} else {
			Chainon c = tete.precedent;
			for (int i = nbElem - 1; i > idx; i--) {
				c = c.precedent;
			}
			return c;
		}
	}

	private Chainon addBefore(E elem, Chainon c) {
		Chainon nouv = new Chainon(elem, c.precedent, c);
		c.precedent.suivant = nouv;
		c.precedent = nouv;
		nbElem += 1;
		return nouv;
	}

	private Chainon addAfter(E elem, Chainon c) {
		Chainon nouv = new Chainon(elem, c, c.suivant);
		c.suivant.precedent = nouv;
		c.suivant = nouv;
		nbElem += 1;
		return nouv;
	}

	/* METHODES PUBLIQUES */

	@Override
	public int size() {
		return nbElem;
	}

	@Override
	public boolean isEmpty() {
		return nbElem == 0;
	}

	@Override
	public boolean contains(Object o) {
		for (Chainon courant = tete.suivant; courant != tete; courant = courant.suivant) {
			if ((o == null && o == courant.elem) || o.equals(courant.elem)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean add(E e) {
		addBefore(e, tete);
		return true;
	}

	@Override
	public E get(int index) {
		return getChainon(index).elem;
	}

	@Override
	public E remove(int index) {
		return remove(getChainon(index));
	}

	@Override
	public void add(int index, E element) {
		addBefore(element, getChainon(index));

	}

	@Override
	public int indexOf(Object o) {
		Chainon c = tete.suivant;
		for (int i = 0; i < nbElem; i++) {
			if ((o == null && c.elem == null) || o.equals(c.elem)) {
				return i;
			}
			c = c.suivant;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		Chainon c = tete.precedent;
		for (int i = nbElem - 1; i >= 0; i--) {
			if ((o == null && c.elem == null) || o.equals(c.elem)) {
				return i;
			}
			c = c.precedent;
		}
		return -1;
	}

	@Override
	public boolean remove(Object o) {
		int idx = indexOf(o);
		if (idx == -1) {
			return false;
		}
		remove(idx);
		return true;
	}

	@Override
	public E set(int index, E element) {
		Chainon c = getChainon(index);
		E result = c.elem;
		c.elem = element;
		return result;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return new MonIterateurChaine(index);
	}

	@Override
	public Iterator<E> iterator() {
		return listIterator();
	}

	@Override
	public ListIterator<E> listIterator() {
		return listIterator(0);
	}

	/* A FAIRE EN EXERCICE A LA MAISON */

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		tete.suivant = tete;
		tete.precedent = tete;
		nbElem = 0;

	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}