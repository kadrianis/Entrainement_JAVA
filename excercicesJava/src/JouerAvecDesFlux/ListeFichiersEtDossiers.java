package JouerAvecDesFlux;

import java.io.File;
import java.io.IOException;

public class ListeFichiersEtDossiers {
    public static void main(String args[]) throws IOException {
        //Creating a File object for directory
        File directoryPath = new File("C:\\Users\\KADRI\\Desktop\\UGA\\DEV MOBILE");
        //List of all files and directories
        String contents[] = directoryPath.list();
        System.out.println("List of files and directories in the specified directory:");
        for (int i = 0; i < contents.length; i++) {
            System.out.println(contents[i]);
        }
    }

}
