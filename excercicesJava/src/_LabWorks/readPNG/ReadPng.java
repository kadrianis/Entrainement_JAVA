package _LabWorks.readPNG;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ReadPng {

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            // je m'assure que l'utilisateur a utilis� la bonne syntaxe
            System.err.println("Usage : java " + ReadPng.class.getName() + " fichier.truc");
            System.exit(1);
        }
        // je matche avec le args qui a �t� ecris sur la barre
        Path p = Paths.get(args[0]);

        if (!Files.isRegularFile(p)) {
            System.err.println(p + " is not a regular file");
            System.exit(2);
        }
        byte[] refpng = new byte[]{(byte) 137, 80, 78, 71, 13, 10, 26, 10};
        //Path f1 = Paths.get("C:\\Users\\KADRI\\Desktop\\java.png");


        try (DataInputStream in = new DataInputStream(new BufferedInputStream(Files.newInputStream(p)))) {

            byte[] tab1 = new byte[8];
            //byte[]tab2 = new byte[9];
            in.read(tab1);

			/*for ( int i=0;i<8;i++) {
			System.out.println("ref : " + refpng[i] + ", lu : "  + tab[i]);
			}*/

            if (Arrays.equals(refpng, tab1)) {
                // peut continuer
                //in.skip(8);
                //in.read(tab2);
                //System.out.println("longueur : " + tab2[]);
                System.out.println("ok");
            } else {
                System.out.println("c est pas un png");
            }

        } catch (java.io.EOFException e) {
            System.err.println("FIN DE FICHIER");
        }
    }

}


