package _LabWorks.codageVegenere01;

/*public class VigenereWriter{}



    /**
     * java ...Vigenere  [-e | -d] passphrase file.txt result.txt
     * @param args
     * @throws IOException
     */

    /**
     * @ todo needs t a constructor
     */

    /*
    public VigenereWriter(Writer w){
        super(w);
    }
    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            System.err.println("Usage: java " + VigenereWriter.class.getName() + " [-e | -d] passphrase file.txt result.txt");
            System.exit(1);
        }

        if (!("-e".equals(args[0]) || "-d".equals(args[0]))) {
            System.err.println("Usage: java " + VigenereWriter.class.getName() + " [-e | -d] passphrase file.txt result.txt");
            System.exit(2);
        }

        for (int i=0 ; i<args[1].length() ; i++) {
            if (!( (args[1].charAt(i)>='a' && args[1].charAt(i)<='z') || (args[1].charAt(i)>='A' && args[1].charAt(i)<='Z'))) {
                System.err.println("The passphrase must contains only letter (without accents): "+args[1]);
                System.exit(5);
            }
        }

        String passphrase = args[1];
        Path input = Paths.get(args[2]);
        if (!Files.exists(input)) {
            System.err.println("Error: "+input+" does not exist");
            System.exit(3);
        }

        if (!Files.isRegularFile(input)) {
            System.err.println("Error: "+input+" is not a regular file");
            System.exit(4);
        }


        Path output = Paths.get(args[3]);
        Reader r=null;
        Writer w=null;
        try {
            r = Files.newBufferedReader(input);
            w = Files.newBufferedWriter(output);
            if ("-e".equals(args[0])) {
                w = new VigenereWriter();
            } else {
                r = new VigenereReader(r,passphrase);
            }

            Scanner sc = new Scanner(r);
            PrintWriter pw = new PrintWriter(w);

            while (sc.hasNext()) {
                pw.println(sc.nextLine());
            }



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            if (r!=null) {
                r.close();
            }
            if (w!=null) {
                w.close();
            }
        }



    }

}*/

