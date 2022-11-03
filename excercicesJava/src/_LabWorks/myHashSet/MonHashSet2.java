package monHashSet;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class MonHashSet2<E> implements Set<E> {

	// classe privé
	private static class BoIterator<E> implements Iterator<E> {

		// ------------------------------------attributs-----------------------------------------//
		E nextElem;
		int currentidx;
		Iterator<E> currentit;
		List<E>[] tab;
		// ------------------------------------constrcteurs-----------------------------------------//
		/*
		 * BoIterator() { currentidx = 0; for (int currentidx = 0; currentidx <
		 * tab.length && tab[currentidx] == null || tab[currentidx].isEmpty();
		 * currentidx++) { if (currentidx != tab.length && !tab[currentidx].isEmpty()) {
		 * currentit = tab[currentidx].iterator(); nextElem = currentit.next(); } } }
		 */

		BoIterator(List<E>[] tab) {
			currentidx = -1;
			searchNext();
		}

		private void searchNext() {
			if (currentit != null && currentit.hasNext()) {
				nextElem = currentit.next();
				// le for avec le ; pour juste chercher
			} else if (currentit == null || !currentit.hasNext())
				; // sur le dernier element de la liste chainée
			// chercher la prochaine case de mon tableau avec une liste chainée non vide
			for (currentidx += 1; currentidx < tab.length
					&& (tab[currentidx] == null || tab[currentidx].isEmpty()); currentidx++)
				;
			if (currentidx == tab.length || tab[currentidx].isEmpty()) {
				nextElem = null; // pas de prochaien element
			} else { // je donne un prochain element
				currentit = tab[currentidx].iterator();
				nextElem = currentit.next();
			}

		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return nextElem != null;
		}

		@Override
		public E next() {
			if (nextElem == null)
				throw new NoSuchElementException();
			E res = nextElem;
			// rechercher le suivant ...
			/*
			 * if (currentit != null && currentit.hasNext()) { nextElem = currentit.next();
			 * } else if (currentit != null && !currentit.hasNext()) { for (int currentidx =
			 * 0; currentidx < tab.length && tab[currentidx] == null ||
			 * tab[currentidx].isEmpty(); currentidx++) { if (currentidx != tab.length &&
			 * !tab[currentidx].isEmpty()) { nextElem = null; }
			 * 
			 * else { currentit = tab[currentidx].iterator(); nextElem = currentit.next(); }
			 * } }
			 */
			searchNext();
			return res;

		}

	}

	private List<E>[] tab;
	private int size;
	private double loadFactor;
	private int incrementSize;
//------------------------------------constrcteurs -------------------------------------//

	public MonHashSet2(int initialSize, int incrementSize, double loadFactor) {
		// TODO Auto-generated constructor stub
		tab = new List[initialSize];
		size = 0;
		this.loadFactor = loadFactor;
		this.incrementSize = incrementSize;
	}

	public MonHashSet2() {
		this(10, 10, 0.75);
	}

	// ------------------------------------Methodes-----------------------------------------//

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	private int indexOf(Object elem) {
		return Math.abs(elem.hashCode()) % tab.length;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		int idx = indexOf(o);
		if (tab[idx] == null) {
			return false;
		}
		return tab[idx].contains(o);
	}

	@Override

	// TODO a revoir a partir du code du prof

	public boolean add(E e) {
		resizeAndRehash();
		int idx = indexOf(e);
		if (tab[idx] == null) {
			tab[idx] = new LinkedList<>();
		}
		if (!tab[idx].contains(e)) {
			tab[idx].add(e);
			size++;
			return true;
		}

		return false;

	}


	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new BoIterator<>(tab);
	}

	@Override
	public boolean remove(Object o) {
		int idx = indexOf(o);
		if (tab[idx] == null) {
			return false;
		}

		if (tab[idx].remove(o)) {
			size -= 1;
			return true;
		}

		return false;
	}

	private void resizeAndRehash() {
		if (size >= loadFactor * tab.length) {
			List<E>[] oldTab = tab;
			tab = new List[tab.length + incrementSize];
			size=0;
			Iterator<E> it = new BoIterator(oldTab);
			while (it.hasNext()) {
				add(it.next());
			}
		}
	}

	// ------------------------------------fin methodes definies ----------------------------------------- //

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
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
