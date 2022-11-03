package JouerAvecDesFlux;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;

public class lectureFichierSurConsole {
    public static void main(String[] args) throws IOException {
        Path f1 = Paths.get("C:\\Users\\KADRI\\Desktop\\a.txt");
        try (Reader in = Files.newBufferedReader(f1, Charset.defaultCharset())) {
            int c;
            String res ="";
            while ((c = in.read()) != -1) {
               res+=(char)c;
            }
            System.out.println(res);
        } catch (NoSuchFileException e) {
            System.err.println("le fichier " + f1 + " n'existe pas");
        }
    }
}

