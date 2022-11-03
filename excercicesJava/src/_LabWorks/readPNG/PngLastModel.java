package _LabWorks.readPNG;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PngLastModel {

    public PngLastModel() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        if (args.length != 1) {
            System.err.println("usage");
            System.exit(1);
        }

        Path p = Paths.get(args[0]); // a importer

        if (!Files.isRegularFile(p)) {
            System.err.println(p + " n est pas un file");
            System.exit(2);
        }
        // java -cp

        byte[] header = new byte[]{(byte) 137, 80, 78, 71, 13, 10, 26, 10};

        //int[] header = new int[] { 137, 80, 78, 71, 13, 10, 26, 10 };


        try (DataInputStream is = new DataInputStream(new BufferedInputStream(Files.newInputStream(p)))) {

            // V2----------------------------------------------------------------

            byte[] lus = is.readNBytes(8);
            if (lus.length < 8) {
                System.err.println(p + " n est pas une image PNG");
                System.exit(4);
            }

            for (int i = 0; i < header.length; i++) {
                if (lus[i] != header[i]) {
                    System.err.println(p + " n est pas une image PNG");
                    System.exit(5);
                }
            }

            // -----------------------------------------------------------------
            // V1
            for (int i = 0; i < header.length; i++) {
                if (is.read() != header[i]) {
                    System.err.println(p + " n est pas une image PNG");
                    System.exit(5);
                }

            }


            is.skip(8);


		/*byte[]l = is.readNBytes(4);
		int width = 0;
		width  += l[0];
		width  = width<<8;

		width  += l[1];
		width  = width<<8;

		width  += l[2];
		width  = width<<8;

		width  += l[3];
		*/

            // TODO : transient est important && la serialisation
            //


            int width = is.readInt();
            int height = is.readInt();
            int depth = is.readInt();
            System.out.println("width=" + width + "height =" + height + "depth =" + depth);


        } catch (IOException e) {
            // TODO Auto-generated catch block

            System.err.println("a problem has occured when reading " + p);
            System.exit(3);
        }

    }

}

