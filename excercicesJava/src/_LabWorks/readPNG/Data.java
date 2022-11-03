package _LabWorks.readPNG;

public class Data {/*

    public Data() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        if (args.length != 1) {
            System.err.println("usage");
            System.exit(1);
        }

        Path p = Paths.get(args[0]);  // a importer

        if (!Files.isRegularFile(p)) {
            System.err.println(p + " n est pas un file");
            System.exit(2);
        }
        // java -cp

        int[] header = new int[]{137, 80, 78, 71, 13, 10, 26, 10};
        try (InputStream is = new BufferedInputStream(Files.newInputStream(p))) {

            for (int i = 0; i < header.length; i++) {
                if (is.read() != header[i]) {
                    System.err.println(p + " n est pas une image PNG");
                    System.exit(4);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block

            System.err.println("a problem has occured when reading " + p);
            System.exit(3);
        }

    }
*/
}


