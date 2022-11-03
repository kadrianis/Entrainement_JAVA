package jouerAvecLesTableaux;
import java.util.Arrays;

public class Aleatoire {

        private int[] val;
        private int nVal, limite;


        public Aleatoire(int n, int l) {
            nVal = n;
            limite = l;
            val = new int[nVal];
            for (int i = 0; i < nVal; i++)
                val[i] = (int) ((l + 1) * Math.random());
        }


        public int getValeur(int num) {
            return val[num];
        }


        public int[] getValeurs() {
            int[] res = new int[nVal];
            for (int i = 0; i < nVal; i++)
                res[i] = val[i];
            return res;
        }


        public int[] histo() {
            int[] res = new int[limite + 1];
            for (int i = 0; i < nVal; i++)
                res[val[i]]++;
            return res;
        }


        public static void main(String[] args) {
            Aleatoire premierEssai= new Aleatoire(10,10);
            System.out.println(Arrays.toString(premierEssai.histo()));

        }
    }

