package jouerAvecLesFractions;

public class Fraction {
    private int Numerateur;
    private int Denominateur;

    private void finInt() {
        if (Denominateur == 0)
            throw new ArithmeticException("Denominateur nul interdit");
        if (Denominateur < 0) {
            // on inverse le signe pour les deux
            Numerateur = -Numerateur;
            Denominateur = -Denominateur;
        }
        reduire();
    }

    private void reduire() {
        // pour reduire tout mes fractions
        Numerateur = Numerateur / (pgcd(Numerateur, Denominateur));
        Denominateur = Denominateur / (pgcd(Numerateur, Denominateur));
    }

    public Fraction() {
        // construit la fraction 0/1.
        // peut etre this(0,1)
        Numerateur = 0;
        Denominateur = 1;
    }

    public Fraction(int n) {
        // construit la fraction n/1.
        // peut etre this(num,1)
        Numerateur = n;
        Denominateur = 1;
        reduire();
    }

    public Fraction(int n, int d) {
        // construit la fraction n/d.
        // rajouter exception valeur erron�e " illegal argument exception"
        // runtime exception : arithmetique exception.
        // il faut inverser le signe de n et d si le d est negatif
        // s'assurer que la fraction est reduite

        Numerateur = n;
        Denominateur = d;

        reduire();
        finInt();
    }

    public Fraction(String s) {
        // construit une fraction d'apr�s son expression �crite dans s.

        String s1 = s.substring(0, s.indexOf('/'));
        String s2 = s.substring(s.indexOf('/') + 1);
        try {
            Numerateur = Integer.valueOf(s1); // Integer.parsInt(s.substring(0,ibarre)):
            Denominateur = Integer.valueOf(s2); // Integer.parsent(s.substring(ibarre+1));
        }

        catch (NumberFormatException e) {
            throw new IllegalArgumentException("incorrect :" + s);
        }

        // selon le prof
        // int ibarre = s.indexOf('/');
        // if (ibarre ==-1)
        // throw new IllegalArgumentException("incorrect :" + s);
        // numberFormatException si le nombre est incorrecte
        // rattraper une autre exception : si la fraction est 1211a/5256666
        //
        finInt();
    }

    public String toString() {
        // Retourne une String contenant l'expression de this.
        // peut etre return Numerateur +"/" + Denominateur; sselon le prof

        return Numerateur + "/" + Denominateur;
    }

    public int getNumerateur() {
        // Accesseur en lecture pour le num�rateur.
        return this.Numerateur;
    }

    public int getDenominateur() {
        return this.Denominateur;
    }

    public void setNumerateur(int n) {
        // Accesseur en �criture pour le num�rateur.
        this.Numerateur = n;
        reduire();
    }

    public void setDenominateur(int d) {
        // Accesseur en �criture pour le denominateur.
        this.Denominateur = d;
        finInt();
    }

    public static Fraction valueOf(String s) {

        /*
         * Retourne une Fraction dont l'expression est dans s, s est de la forme :
         * expression d'un entier positif, suivie de '/', suivi de l'expression d'un
         * entier positif
         */
        // soit je passe par l'objet string de java, soit je parcours ma string sous
        // forme de tableau de char et je fais le transtypage.
        /*
         * int n=(int)s.charAt(0)-'0'; //int m = Integer.parseInt(s.charAt(0)); int
         * d=(int)s.charAt(2)-'0'; Fraction a =new Fraction(n,d); return a;
         */

        Fraction f = new Fraction(s);
        return f;
    }

    /*
     * public Fraction plus(Fraction f) { // 1er tour le 28 novembre // 2eme tour 01
     * decembre // 3eme tour ........ // Retourne le r�sultat de l'addition de this
     * et f. int d1=this.Denominateur; int d2=f.Denominateur; int p=ppcm(d1,d2); int
     * d=p; int n1=this.Numerateur; int n2=f.Numerateur; int n= n1*p/d1 + n2*p/d2;
     * return new Fraction(n,d);
     *
     * }
     *
     * public static int pgcd(int a, int b) { int r= a%b; if(r==0) return b; else
     * return pgcd(b,r); }
     *
     * public static int ppcm(int a, int b) { return ((a/pgcd(a,b))*b); }
     *
     *
     */

    public Fraction plus(Fraction f) {

        /*
         * Addition : n1/d1 + n2/d2 = n/d, o� n = n1*p/d1 + n2*p/d2 et d = p, avec p le
         * ppcm de d1 et d2
         */
        int n1 = this.Numerateur;
        int d1 = this.Denominateur;
        int n2 = f.Numerateur;
        int d2 = f.Denominateur;
        int p = ppcm(d1, d2);
        int n = n1 * p / d1 + n2 * p / d2;
        int d = p;
        return new Fraction(n, d);
    }

    public int pgcd(int a, int b) {
        int r = a % b;
        if (r == 0)
            return b;
        else
            return (pgcd(a, r));
    }

    public int ppcm(int a, int b) {
        return (a / pgcd(a, b) * b);
    }

    public Fraction moins(Fraction f) {
    // les calculs dans l'ennoncé du tp
        int n1 = this.Numerateur;
        int d1 = this.Denominateur;
        int n2 = f.Numerateur;
        int d2 = f.Denominateur;

        int p = ppcm(d1, d2);
        int n = n1 * p / d1 - n2 * p / d2;
        int d = p;
        return new Fraction(n, d);

    }

    public Fraction fois(Fraction f) {

        int n1 = this.Numerateur;
        int d1 = this.Denominateur;
        int n2 = f.Numerateur;
        int d2 = f.Denominateur;

        int p = ppcm(d1, d2);
        int n = n1 * n2;
        int d = d1 * d2;
        return new Fraction(n, d);

    }

    public Fraction diviseePar(Fraction f) {
        int n1 = this.Numerateur;
        int d1 = this.Denominateur;
        int n2 = f.Numerateur;
        int d2 = f.Denominateur;

        int n = n1 * d2;
        int d = d1 * n2;
        return new Fraction(n, d);

    }

    public int compareTo(Fraction f) {
        // Retourne un int n�gatif si this est inf�rieur � f, positif si this est
        // sup�rieur � f, nul si this est
        // �quivalent � f
        // renvoie le d car le d ne peut etre 0
        int res;
        int n1 = this.Numerateur;
        int d1 = this.Denominateur;
        int n2 = f.Numerateur;
        int d2 = f.Denominateur;

        return this.moins(f).Numerateur;

    }

    public boolean equals(Object obj) {
        // Retourne true si et seulement si this est �quivalent � obj.
        return obj instanceof Fraction && this.compareTo((Fraction) obj) == 0;
    }

    // partie deux

    public static Fraction evalueExpression(String s) {
        // fait appel a des accumulateur , pas de priorit� , de gauche a droite
        // s = 1/5 + 5/4 - 7/8 = xxxx
        Fraction acc = new Fraction();
        int i = 0;
        // it�rer si je rencontre pas un opp

        while (!estOpp(s.charAt(i))) {

            i++;
        }
        return null;
    }

    private static boolean estOpp(char c) {
        // char tab[]= {'+','-','*',':'};
        if ((c == '+') || (c == '-') || (c == '*') || (c == ':'))
            return true;
        else
            return false;
    }

    private static Fraction appOpp(char op, Fraction f1, Fraction f2) {
        if (op == '+')
            return f1.plus(f2);
        if (op == '-')
            return f1.moins(f2);
        if (op == '*')
            return f1.fois(f2);
        if (op == ':')
            return f1.diviseePar(f2);

        throw new IllegalArgumentException("operateur erron�" + op);
    }

    public String formeEgyptienne() {
        if (Numerateur < 0)
            throw new RuntimeException("n'accepte pas la n�gativit�");
        String res = "";
        Fraction f = this;
        //
        Fraction zero = new Fraction();
        for (int d = 2; f.compareTo(zero) > 0; d++) {

            Fraction g = new Fraction(1, d);
            if (f.compareTo(g) >= 0) {
                res += "+" + g;
                f = f.moins(g);
            }

        }

        return res.substring(1);

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 5;
        int b = 3;
        int e = 4;
        int r = 3;

        Fraction f = new Fraction(a, b);
        Fraction g = new Fraction(3, 4);

        // System.out.println(Fraction(2,5));
        // System.out.println(f.toString());
        // System.out.println(Fraction.valueOf("7587/2"));
        // System.out.println(pgcd(80,4));
        // System.out.println(ppcm(31,2));
        // System.out.println(f.plus(g));
        // System.out.println(f.moins(g));
        // System.out.println(f.fois(g));
        // System.out.println(f.diviseePar(g));
        // System.out.println(f.compareTo(g));
        // System.out.println(f.equals(f));
        System.out.println("kjhjhkh");
        System.out.println(">"+g.formeEgyptienne()+"<");
    }

}

