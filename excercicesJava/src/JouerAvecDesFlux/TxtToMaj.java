package JouerAvecDesFlux;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;

public class TxtToMaj {
    public static void main(String[] args) throws IOException {
        Path f1 = Paths.get("C:\\Users\\KADRI\\Desktop\\test1.txt");
        try (Reader in = Files.newBufferedReader(f1, Charset.defaultCharset())) {
            int c;
            while ((c = in.read()) != -1) {
                char lu = (char) c;
                lu = Character.toUpperCase(lu);
                System.out.print(lu);
            }
        } catch (NoSuchFileException e) {
            System.err.println("le fichier \"" + f1.getFileName() + "\"  n'existe pas");
        }
    }
}
