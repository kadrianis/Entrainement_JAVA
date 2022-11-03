package jouerAvecDesString;

import java.util.Scanner;

public class MaString {

    private char[] lesCaracteres;

    public String toString() {
        return new String(lesCaracteres);
    }

    public MaString() {
        lesCaracteres = new char[0];
    }

    public MaString(char[] tab, int d, int f) {
        lesCaracteres = new char[f - d];
        for (int i = d; i < f; i++)
            lesCaracteres[i - d] = tab[i];
    }

    public MaString(MaString ms) {
        this(ms.lesCaracteres, 0, ms.length());
    }

    public static MaString valueOf(boolean b) {
        // retourne la repr�sentation en cha�ne de b.

        char tab[] = {'t', 'r', 'u', 'e'};
        char tab1[] = {'f', 'a', 'l', 's', 'e'};
        if (b) {
            return new MaString(tab1, 0, 5);
        }
        return new MaString(tab, 0, 4);
    }

    public static MaString valueOf(char c) {
        // retourne la repr�sentation en cha�ne de c.
        char paramettre = c;
        char tab[] = {paramettre};
        return new MaString(tab, 0, 1);
    }

    public int length() {
        return lesCaracteres.length;
    }

    public char charAt(int i) {
        return lesCaracteres[i];
    }

    public MaString substring(int a, int b) {
        return new MaString(lesCaracteres, a, b);
    }

    public MaString substring(int d) {
        return new MaString(lesCaracteres, d, lesCaracteres.length);
    }

    public boolean equals(MaString ms) {
        if (ms.lesCaracteres.length != lesCaracteres.length)
            return false;
        for (int i = 0; i < ms.lesCaracteres.length; i++) {
            if (!(ms.lesCaracteres[i] == lesCaracteres[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean startsWith(MaString prefixe) {
        boolean res = true;
        if (prefixe.lesCaracteres.length > lesCaracteres.length)
            return false;
        for (int i = 0; i < prefixe.lesCaracteres.length; i++) {
            if (!(prefixe.lesCaracteres[i] == lesCaracteres[i])) {
                res = false;
            }
        }
        return res;
    }

    public int indexOf(char c, int i) {

        int k;
        for (k = i; k < lesCaracteres.length; k++) {
            if (lesCaracteres[k] == c) {
                return (k);
            }
        }
        return -1;
    }

    public int indexOfbis(char c, int i) {
        int k;
        for (k = i; k < lesCaracteres.length; k++) {
            if (lesCaracteres[k] == c) {
                return (k - i);
            } //
        }
        return -1;
    }

    public int indexOf(char c) {
        for (int k = 0; k < lesCaracteres.length; k++) {
            if (lesCaracteres[k] == c) {
                return (k);
            } //
        }
        return -1;
    }

    public MaString concat(MaString ms) {
        int i;
        int a = lesCaracteres.length + ms.lesCaracteres.length;
        char[] str1 = new char[a];
        // MaString str = new MaString(lesCaracteres, 0, a);
        for (i = 0; i < lesCaracteres.length; i++)
            str1[i] = lesCaracteres[i];
        for (i = 0; i < ms.lesCaracteres.length; i++)
            str1[i + lesCaracteres.length] = ms.lesCaracteres[i];
        MaString res = new MaString(); // amigo
        res.lesCaracteres = str1; // amigo

        return res;
    }

    public int compareTo(MaString ms) {
        int compar = lesCaracteres.length < ms.lesCaracteres.length ? lesCaracteres.length : ms.lesCaracteres.length;
        for (int i = 0; i < compar; i++)
            if (lesCaracteres[i] != ms.lesCaracteres[i])
                return ((lesCaracteres[i] - '0') - (ms.lesCaracteres[i] - '0'));

        return length() - ms.length();
    }

    public boolean isEmpty() {
        if (lesCaracteres.length == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        char[] tab1 = {'y', 'b', 'y', 'z', 'k'};
        char[] tab2 = {'y', 'b', 'x'};
        char[] tab3 = {'l', 'u', 'e', 'g', 'o'};
        MaString ms1 = new MaString(tab1, 0, 4);
        MaString ms2 = new MaString(tab2, 0, 3);
        System.out.println(ms1.startsWith(ms2));


    }
}


