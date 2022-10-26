package JouerAvecDesFichiers;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Iterator;

public class comptreLesOctets {
    public static void main(String[] args) throws IOException {
        Path f1 = Paths.get("C:\\Users\\KADRI\\Desktop\\a.txt");
        long start = System.currentTimeMillis();

        try (InputStream in = new BufferedInputStream(Files.newInputStream(f1))) {
            int a;
            int[] nbOcc = new int[256];
            while ((a = in.read()) != -1) {
                nbOcc[a] += 1;
            }
            for (int iterator = 0; iterator < 256; iterator++) {
                System.out.println(" l'octet " + iterator + " est present " + nbOcc[iterator] + "  fois");

            }
        } catch (NoSuchFileException e) {
            System.err.println("le fichier " + f1 + " n'existe pas");
        }
        System.out.println("Duration :" + (System.currentTimeMillis() - start));
    }
}


