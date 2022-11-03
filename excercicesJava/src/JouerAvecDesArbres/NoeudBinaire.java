package JouerAvecDesArbres;

import java.util.Map;

class NoeudBinaire<K extends Comparable<K>,V> implements Map.Entry<K, V> {

    K key;
    V value;
    NoeudBinaire<K,V> left;
    NoeudBinaire<K,V> right;

    public NoeudBinaire(K key, V value) {
        this.key=key;
        this.value=value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        // pourquoi je stocke pour le retourner
        V old = this.value;
        this.value=value;
        return old;
    }

    public String toString() {
        return "["+key+","+value+"]";
    }
}
