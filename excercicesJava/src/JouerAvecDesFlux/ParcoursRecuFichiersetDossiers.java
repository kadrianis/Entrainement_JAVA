package JouerAvecDesFlux;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ParcoursRecuFichiersetDossiers {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\KADRI\\Desktop\\UGA\\NET");
        try {

            Stream<Path> stream1 = Files.walk(Paths.get(String.valueOf(path)));
            stream1.filter(Files ::isDirectory).forEach(System.out::println);

            System.out.println("--------------------------------------------------------");
            System.out.println("--------------------------------------------------------");
            System.out.println("--------------------------------------------------------");
            System.out.println("--------------------------------------------------------");
            System.out.println("--------------------------------------------------------");
            System.out.println("--------------------------------------------------------");


            Stream<Path> stream2 = Files.walk(Paths.get(String.valueOf(path)));
            stream2.filter(Files::isRegularFile).forEach(System.out::println);
        }finally {

        }
    }
}
