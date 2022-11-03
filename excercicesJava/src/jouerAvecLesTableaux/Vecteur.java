package jouerAvecLesTableaux;

import java.util.Scanner;

public class Vecteur {

    private double[] vect;

    public Vecteur(int n) {
        this(n, 0.);
        // un autre constructeur
    }

    public Vecteur(int n, double x) {
        vect = new double[n];
        for (int i = 0; i < n; i++)
            vect[i] = x;
    }

    public Vecteur(double[] v) {
        int n = v.length;
        vect = new double[n];
        for (int i = 0; i < n; i++)
            vect[i] = v[i];
    }

    public double prodScal(Vecteur w) {
        if (vect.length != w.vect.length)
            return 0.;
        double ps = 0.;
        for (int i = 0; i < vect.length; i++)
            ps += vect[i] * w.vect[i];
        return ps;
    }

}
