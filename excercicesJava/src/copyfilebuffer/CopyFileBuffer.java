package copyfilebuffer;
import java.io.*;
import java.nio.file.*;

public class CopyFileBuffer {

    public static void main(String[] args) throws IOException {
        Path f1 = Paths.get("C:\\Users\\KADRI\\Desktop\\a.txt"); // plac� � la racine du projet
        Path f2 = Paths.get("C:\\Users\\KADRI\\Desktop\\b.txt");
        long start = System.currentTimeMillis();

        try (InputStream in = Files.newInputStream(f1); OutputStream out = Files.newOutputStream(f2)) {

            byte[] buf = new byte[512];
            int nb = 0;
            while ((nb = in.read(buf)) != -1) {
                out.write(buf, 0, nb);
            }
        } catch (NoSuchFileException e) { // ancienne API : FileNotFoundException
            System.err.println("le fichier " + f1 + " n'existe pas");
        }
        System.out.println("duration : " + (System.currentTimeMillis() - start));
    }
}
