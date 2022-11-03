package JouerAvecDesFlux;

import java.io.*;

public class TestInput {

    public static void ecriture(String name) {
        try {
            FileOutputStream f = new FileOutputStream(name);
            DataOutputStream df = new DataOutputStream(f);
            for (int i = 0; i < 10; i++) {
                int val = (int) (Math.random() * 100);
                try {
                    df.writeInt(val);
                    //System.out.print(" " + val);
                    df.flush();

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }
    }

    public static void lecture(String name) {
        try {
            FileInputStream f = new FileInputStream(name);
            try {
                int lu = f.read();
                int val = lu;
                while (lu != -1) {
                    for (int i = 1; i < 4; i++) {
                        lu = f.read(); // faut verifier que lu est different de -1
                        val <<= 8;
                        val += lu;
                    }
                    System.out.print(" " + val);
                    val = lu = f.read();
                }
                f.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ecriture("testA");
        System.out.println();
        lecture("testA");

    }

}

