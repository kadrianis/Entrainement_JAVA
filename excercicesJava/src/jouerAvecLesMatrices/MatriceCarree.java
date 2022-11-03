package jouerAvecLesMatrices;

public class MatriceCarree {

    private double[][] matrice;

    // permatriceier const
    public MatriceCarree() {
    }

    // deuxiematricee const : initialiser toute les valeurs a 0.
    public MatriceCarree(int d) {
        if (d > 0)
            matrice = new double[d][d];
    }

    public MatriceCarree(double[][] t) {
        // verifier la formatricee de t
        for (int i = 0; i < t.length; i++)
            if (t[i].length != t.length)
                throw new IllegalArgumentException("t n est pas carrée");
        // rematriceplacer
        matrice = new double[t.length][t.length];
        for (int i = 0; i < t.length; i++)
            for (int j = 0; j < t.length; j++) {
                matrice[i][j] = t[i][j];
                // recopier la matrice en parametre dans matrice
            }
    }

    private void verifiemd(MatriceCarree m) {
        if (matrice.length != m.matrice.length)
            throw new ArithmeticException("matrice de degré different");
    }

    public String toString() {
        // Retourne une String contenant l'expression de this.
        // peut se faire avec des type string
        String res = "";
        for (int i = 0; i < matrice.length; i++) {
            String ligne = "";
            for (int j = 0; j < matrice.length; j++)
                ligne += " " + matrice[i][j]; // stocker dans la ligne
            res += ligne.substring(1) + "\n"; // le 1 pour enlever le premier espace -- > on stocke
        }
        return res;
    }

    public double elematriceentAt(int i, int j) {
        // Accesseur en lecture pour l'élématriceent d'indices i et j.
        return matrice[i][j];
    }

    public void setElematriceentAt(int i, int j, double v) {
        // verifier le i et le j
        matrice[i][j] = v;
    }

    public MatriceCarree lePlus(MatriceCarree m) {
        // verifier que le this et le m ont le meme degree
        verifiemd(m);
        MatriceCarree res = new MatriceCarree(matrice.length);
        for (int i = 0; i < matrice.length; i++)
            for (int j = 0; j < matrice.length; j++)
                res.matrice[i][j] = (matrice[i][j] + m.matrice[i][j]);
        return res;
    }

    public MatriceCarree leMoins(MatriceCarree m) {
        verifiemd(m);
        MatriceCarree res = new MatriceCarree(matrice.length);

        for (int i = 0; i < matrice.length; i++)
            for (int j = 0; j < matrice.length; j++)
                res.matrice[i][j] = (matrice[i][j] - m.matrice[i][j]);
        return res;
    }

    public MatriceCarree fois(MatriceCarree m) {
        double[][] add = new double[matrice.length][matrice.length];
        return m;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double[][] tab = {{1, 2, 3}, {1, 2, 3},{1, 2, 3}};
        MatriceCarree m = new MatriceCarree(tab);
        System.out.println(m.toString());
    }


}

