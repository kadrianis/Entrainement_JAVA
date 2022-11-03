package _LabWorks.codageVegenere01;

/*class VigenereReader extends FilterReader {

    private String key;
    private int idx;

    protected VigenereReader(Reader in, String key) {
        super(in);
        this.key = key;
        idx = 0;
    }

    /**
     * PRE CONDITION : c doit etre un caractere entre a et z ou A et Z
     *
     * @param c
     * @return
     */

/*
    private char decode(char c) {
        char a = 'a';
        if (Character.isUpperCase(c)) {
            a = 'A';
        }
        char res = (char) ((((c - a) - (key.charAt(idx) - a) + 26) % 26) + a);

        idx = (idx + 1) % key.length();
        return res;
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        if (c > -1) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                return decode((char) c);
            }
        }
        return c;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int nb = super.read(cbuf, off, len);

        for (int i = off; i < off + nb; i++) {
            // encode mon caract�re
            if ((cbuf[i] >= 'a' && cbuf[i] <= 'z') || (cbuf[i] >= 'A' && cbuf[i] <= 'Z')) {
                cbuf[i] = decode(cbuf[i]);
            }

        }
        return nb;
    }
}*/


