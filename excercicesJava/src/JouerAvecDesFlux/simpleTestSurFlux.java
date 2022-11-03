package JouerAvecDesFlux;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
public class simpleTestSurFlux {

    public simpleTestSurFlux() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) throws IOException {
        Path p = Paths.get("src/fr/uga/miashs/dciss/cours1live/trucprogramme.java");
        System.out.println(" je suis ou je ne suis pas  "+ p.getClass());
        System.out.println(" je suis ou je ne suis pas  "+ p.getFileName());

        for (int i =0; i<p.getNameCount();i++) {
            System.out.println(p.getName(i));
        }

        System.out.println((p.getName(p.getNameCount()-1)));
        System.out.println(p.getParent());
        System.out.println(p.toAbsolutePath());
        System.out.println(p.isAbsolute());

        Path p2 = Paths.get("anis/truc");

        System.out.println(p2.isAbsolute());
        System.out.println(p2.toAbsolutePath());
        System.out.println(p2.toAbsolutePath().getRoot());

        Path abs = Paths.get("/chose");
        Path nv = abs.resolve(p);
        System.out.println(nv.normalize());
        try {
            Path nv2 = Paths.get("../../src/fr/uga/miashs/dciss/cours1live/trucprogramme.java").toRealPath();
        } catch (IOException e) {
            System.out.println(" un probleme, je le gere" + nv + " n existe pas");
        }
        System.out.println("coucou");
        for (int i=0; i<args.length; i++) {
            System.out.println("arg " +i+ " "+ args[i]);
        }

    }

}
