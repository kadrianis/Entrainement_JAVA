package _LabWorks.Huffman;

import java.util.Iterator;
import java.util.Map;

public class NoeudBinaire<E> extends NoeudAbstrait<E> {
    private NoeudAbstrait<E> gauche, droit;

    public NoeudBinaire(NoeudAbstrait<E> g, NoeudAbstrait<E> d) {
        super(4);
    }

    protected void getDictionnaire(Map<E, String> dict, StringBuffer buf) {}


    public E decode(Iterator<Boolean> elemsCodes) {
        return null;
    }


}
