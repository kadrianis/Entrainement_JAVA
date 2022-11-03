package JouerAvecDesArbres;

import java.util.SortedMap;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class ArbreBinaire<K extends Comparable<K>, V> implements SortedMap<K, V> {

    private NoeudBinaire<K, V> root;
    private int size;

    public ArbreBinaire() {
        root = null;
        size = 0;
    }

    private NoeudBinaire<K, V> search(K key) {
        NoeudBinaire<K, V> previous = null;
        NoeudBinaire<K, V> courant = root;
        while (courant != null) {
            int cmp = courant.key.compareTo(key);
            if (cmp == 0) {
                return courant;
            } else if (cmp < 0) {
                previous = courant;
                courant = courant.right;
            } else {
                previous = courant;
                courant = courant.left;
            }
        }
        return previous;
    }

    public V get(Object key) {
        try {
            NoeudBinaire<K, V> res = search((K) key);
            if (res != null && res.key.equals(key)) {
                return res.value;
            }
        } catch (ClassCastException e) {
        }
        return null;

    }

    public boolean containsKey(Object key) {
        try {
            NoeudBinaire<K, V> res = search((K) key);
            return (res != null && res.key.equals(key));
        } catch (ClassCastException e) {
            return false;
        }
    }

    public V put(K key, V value) {
        // cas où l'arbre est vide
        if (root == null) {
            root = new NoeudBinaire<>(key, value);
            size = 1;
            return null;
        }
        NoeudBinaire<K, V> res = search((K) key);
        // je suis sur que res ne sera pas null car traité avant
        int cmp = res.key.compareTo(key);

        if (cmp == 0) {
            V result = res.value;
            res.value = value;
            return result;
        } else if (cmp < 0) {
            res.right = new NoeudBinaire<>(key, value);
        } else {
            res.left = new NoeudBinaire<>(key, value);
        }
        size += 1;
        return null;
    }

    public V remove(Object key) {
        try {
            NoeudBinaire<K, V> previous = null;
            NoeudBinaire<K, V> courant = root;
            while (courant != null) {
                int cmp = courant.key.compareTo((K) key);
                if (cmp == 0) {
                    // return courant;
                    break;
                } else if (cmp < 0) {
                    previous = courant;
                    courant = courant.right;
                } else {
                    previous = courant;
                    courant = courant.left;
                }
            }
            // courant == null -> key n'est pas dans l'arbre...
            if (courant == null) {
                return null;
            }
            // courant -> noeud � supprimer
            // previous -> c'est le père du noeud � supprimer.

            if (courant.left == null || courant.right == null) {
                NoeudBinaire<K, V> remplacant = courant.left;
                if (courant.left == null) {
                    remplacant = courant.right;
                }
                if (previous == null)
                    root = remplacant;
                else if (previous.left == courant)
                    previous.left = remplacant;
                else
                    previous.right = remplacant;
                size--;
                return courant.value;
            } // aucun des sous arbres n'est vide ... -> switch avec le plus petit des plus
            // grands
            else {
                NoeudBinaire<K, V> pp = courant.right;
                NoeudBinaire<K, V> perePP = courant.right;
                while (pp.left != null) {
                    perePP = pp;
                    pp = pp.left;
                }
                V courantValue = courant.value;
                perePP.left = pp.right;
                courant.key = pp.key;
                courant.value = pp.value;
                size--;
                return courantValue;
            }
        } catch (ClassCastException e) {
            return null;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    // méthodes faciles

    public K firstKey() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        NoeudBinaire<K, V> courant = root;
        while (courant.left != null) {
            courant = courant.left;
        }
        return courant.key;

    }

    public K lastKey() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        NoeudBinaire<K, V> courant = root;
        while (courant.right != null) {
            courant = courant.right;
        }
        return courant.key;
    }

    // Iterateur sur un arbre

    private class ArbreIterateur implements Iterator<Entry<K, V>> {

        Deque<NoeudBinaire<K, V>> pile = new LinkedList<>();

        // stocke le next � retourner
        NoeudBinaire<K, V> courant;

        ArbreIterateur() {
            courant = root;
            descendreAGauche();
        }

        private void descendreAGauche() {
            while (courant != null && courant.left != null) {
                pile.push(courant);
                courant = courant.left;
            }
        }

        @Override
        public boolean hasNext() {
            return courant != null;
        }

        @Override
        public Entry<K, V> next() {
            if (courant == null)
                throw new NoSuchElementException();
            Entry<K, V> res = courant;
            if (courant.right != null) {
                courant = courant.right;
                descendreAGauche();
            } else {
                courant = pile.poll();
            }
            return res;
        }

    }


    // après

    public Set<K> keySet() {
        return new AbstractSet<K>() {
            @Override
            public Iterator<K> iterator() {
                return new Iterator<K>() {
                    ArbreIterateur it = new ArbreIterateur();

                    @Override
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override
                    public K next() {
                        return it.next().getKey();
                    }

                };
            }

            @Override
            public int size() {
                return size;
            }

        };
    }


    public Collection<V> values() {
        return new AbstractCollection<V>() {
            @Override
            public Iterator<V> iterator() {
                return new Iterator<V>() {
                    ArbreIterateur it = new ArbreIterateur();

                    @Override
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override
                    public V next() {
                        return it.next().getValue();
                    }

                };
            }

            @Override
            public int size() {
                return size;
            }

        };
    }


    public Set<Entry<K, V>> entrySet() {
        return new AbstractSet<Entry<K, V>>() {

            @Override
            public Iterator<Entry<K, V>> iterator() {
                return new ArbreIterateur();
            }

            @Override
            public int size() {
                return size;
            }

        };
    }

    // methodes faciles, qui ignorent le fait qu'il y a un arbre

    public boolean containsValue(Object value) {
        // TODO Auto-generated method stub
        return false;
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        // TODO Auto-generated method stub

    }

    public void clear() {
        root = null;
        size = 0;

    }

    // pas a faire ici
    public Comparator<? super K> comparator() {
        // TODO Auto-generated method stub
        return null;
    }

    // plus dur
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        // TODO Auto-generated method stub
        return null;
    }

    public SortedMap<K, V> headMap(K toKey) {
        // TODO Auto-generated method stub
        return null;
    }

    public SortedMap<K, V> tailMap(K fromKey) {
        // TODO Auto-generated method stub
        return null;
    }

    public static void main(String[] args) {
        ArbreBinaire<Integer, String> monBelArbre = new ArbreBinaire<>();

        monBelArbre.put(10, "dix");
        monBelArbre.put(5, "cinq");
        monBelArbre.put(3, "trois");
        monBelArbre.put(8, "huit");
        monBelArbre.put(6, "six");
        monBelArbre.put(7, "sept");
        monBelArbre.put(9, "neuf");
        monBelArbre.put(12, "douze");
        // monBelArbre.put(1, "un");

        System.out.println(monBelArbre.entrySet());

        System.out.println(monBelArbre.keySet());

        System.out.println(monBelArbre.values());

        // monBelArbre.put(11, "onze");
        // monBelArbre.put(2, "deux");

        // System.out.println(monBelArbre.get(11));
        // System.out.println(monBelArbre.get(12));

    }
}