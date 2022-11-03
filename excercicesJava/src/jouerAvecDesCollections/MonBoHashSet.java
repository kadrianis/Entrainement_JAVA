package jouerAvecDesCollections;

import java.util.*;

public class MonBoHashSet<E> extends AbstractSet<E> {
        // TODO comprendre / reprendre le code  !!!
    private static class BoIterator<E> implements Iterator<E> {

        E nextElem;
        int currentIdx;
        Iterator<E> currentIt;
        List<E>[] tab;

        BoIterator(List<E>[] tab) {
            this.tab = tab;
            currentIdx = -1;
            searchNext();

        }

        @Override
        public boolean hasNext() {
            return nextElem != null;
        }

        private void searchNext() {
            if (currentIt != null && currentIt.hasNext()) {
                nextElem = currentIt.next();
            } else if (currentIt == null || !currentIt.hasNext()) {
                for (currentIdx += 1; currentIdx < tab.length
                        && (tab[currentIdx] == null || tab[currentIdx].isEmpty()); currentIdx++) {
                    // je ne fais rien
                }

                if (currentIdx == tab.length || tab[currentIdx].isEmpty()) {
                    nextElem = null;
                } else {
                    currentIt = tab[currentIdx].iterator();
                    nextElem = currentIt.next();
                }
            }
        }

        @Override
        public E next() {
            E res = nextElem;
            if (nextElem == null)
                throw new NoSuchElementException();
            // rechercher le suivant...
            searchNext();
            return res;
        }

    }

    private List<E>[] tab;
    private int size;
    private double loadFactor;
    private int incrementSize;

    public MonBoHashSet() {
        this(10, 10, 0.75);
    }

    public MonBoHashSet(int initialSize, int incrementSize, double loadFactor) {
        tab = new List[initialSize];
        size = 0;
        this.loadFactor = loadFactor;
        this.incrementSize = incrementSize;
    }

    private int indexOf(Object elem) {
        return Math.abs(elem.hashCode()) % tab.length;
    }

    public boolean contains(Object o) {
        int idx = indexOf(o);
        if (tab[idx] == null) {
            return false;
        }
        return tab[idx].contains(o);
    }

    private void resizeAndRehash() {
        if (size >= loadFactor * tab.length) {
            List<E>[] oldTab = tab;
            tab = new List[tab.length + incrementSize];
            size = 0;
            Iterator<E> it = new BoIterator(oldTab);
            while (it.hasNext()) {
                add(it.next());
            }

        }
    }

    public boolean add(E e) {
        resizeAndRehash();
        int idx = indexOf(e);
        if (tab[idx] == null) {
            tab[idx] = new LinkedList<>();
        }
        if (!tab[idx].contains(e)) {
            tab[idx].add(e);
            size += 1;
            return true;
        }
        return false;
    }

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


    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new BoIterator<>(tab);
    }


}

