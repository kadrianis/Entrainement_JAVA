package JouerAvecDesFlux;

import java.io.*;

public class CopierFichier {



    //TODO :: trouver pourquoi ça marche pas


    public static void main(String[] args) {

        InputStream inStream = null;
        OutputStream outStream = null;

        File a_file = new File("input.txt");
        File b_file = new File("inputCopy.txt");
        try {
            inStream = new FileInputStream(a_file);
            outStream = new FileOutputStream(b_file);
            byte[] buffer = new byte[1024];
            int length;
            // copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
            inStream.close();
            outStream.close();
            System.out.println("File is copied successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
