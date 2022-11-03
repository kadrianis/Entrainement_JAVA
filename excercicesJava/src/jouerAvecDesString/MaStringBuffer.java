package jouerAvecDesString;

public class MaStringBuffer {
    private char[] lesCaracteres;
    private int n;

    public String toString() {
        //s'assurer que le offset est un int positif ???
        return new String(lesCaracteres, 0, n);
    }

    public MaStringBuffer(int l) {
        // construit la cha�ne vide, avec un tampon de l caract�res.
        lesCaracteres = new char[l];
        n = 0;
    }

    public MaStringBuffer() {
        // construit la cha�ne vide, avec un tampon de 16 caract�res.
        lesCaracteres = new char[16];
        n = 0;
    }

    public MaStringBuffer(MaString ms) {
        // construit une cha�ne �quivalente � ms, avec un tampon de ms.length() + 16
        // caract�res.
        n = ms.length();
        lesCaracteres = new char[ms.length() + 16];
        for (int i = 0; i < ms.length(); i++)
            lesCaracteres[i] = ms.charAt(i);
    }

    public int length() {
        // retourne le nombre de caract�res effectifs de this.
        return n;
    }

    public int capacity() {
        // retourne la taille du tampon.
        return lesCaracteres.length;
    }

    public void ensureCapacity(int capMin) {
        // assure que le tampon a une taille minimum de capMin caract�res.
        if (capacity() < capMin) {
            char[] t = new char[capMin];
            for (int i = 0; i < capacity(); i++)
                t[i] = lesCaracteres[i];
            lesCaracteres = t;
        }
    }

    public MaStringBuffer append(MaString ms) {
        // int j=0;
        // modifie et retourne this en lui concat�nant les caract�res de ms.
        ensureCapacity(ms.length() + lesCaracteres.length);
        for (int i = 0; i < ms.length(); i++) {
            lesCaracteres[i + n] = ms.charAt(i);
        }
        n = n + ms.length();
        // mettre a jour n ( le nb de chars dans la

        return this;
    }

    public MaStringBuffer replace(int d, int f, MaString ms) {
        // modifie puis retourne this en rempla�ant les caract�res d'indices d (inclus)
        // � f (exclus) par tous les caract�res de ms.

        int taille = ms.length() + lesCaracteres.length - (f - d);
        //System.out.println(taille);
        ensureCapacity(taille);
        //System.out.println(lesCaracteres.length);
        char[] t = new char[n - f];
        //System.out.println(t.length);
        for (int i = f; i < n; i++) // copier tout les caracteres qui sont apres f
            t[i - f] = lesCaracteres[i];
        for (int i = 0; i < ms.length(); i++)// rajouter ms
            lesCaracteres[d + i] = ms.charAt(i);
        for (int i = 0; i < t.length; i++) // rajouter t
            lesCaracteres[d + ms.length() + i] = t[i];
        n = n + ms.length();
        // lesCaracteres = t;
        return this;
    }

    public MaStringBuffer delete(int d, int f) {
        // modifie puis retourne this en supprimant les caract�res d'indices d (inclus)
        // � f (exclus).
        for (int i = d; i <= n; i++)
            lesCaracteres[i + d] = lesCaracteres[i + (f - d)];// TODO  : deux d alors pour le premier tab ??
        n = n - (f - d);

        return this;
    }


    /* public MaStringBuffer delete(int d, int f) {
         // modifie puis retourne this en supprimant les caract�res d'indices d (inclus)
         // � f (exclus).
         for (int i = d; i <(n-f)+d; i++)
             lesCaracteres[i] = lesCaracteres[i + (f - d)];// TODO  : deux d alors pour le premier tab ??
         n = n - (f - d);

         return this;
     }
    */

    public MaStringBuffer insert(int i, MaString ms) {
        return this.replace(i, i, ms);
    }

    public static void main(String[] args) {
        char[] tab1 = {'a', 'n', 'i', 's', 'a', 'n', 'i', 's'};
        char[] tab2 = {'t', 't', 't'};
        MaString ms1 = new MaString(tab1, 0, 8);
        MaString ms2 = new MaString(tab2, 0, 3);

        MaStringBuffer msb1 = new MaStringBuffer(ms1);
        MaStringBuffer msb2 = new MaStringBuffer(ms2);

        //System.out.println(msb.delete(0, 2));
        System.out.println(msb1.insert(0, ms2));


    }

}

