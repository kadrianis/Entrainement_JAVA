package _LabWorks.codageVegenere01;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

class Vigenere extends FilterWriter {

    private String key;
    private int idx;

    protected Vigenere(Writer out, String key) {
        super(out);
        this.key = key;
        idx = 0;
    }

    @Override
    public void write(int c) throws IOException {
        this.write(new char[]{(char) c}, 0, 1);
    }

    /**
     * PRE CONDITION : c doit etre un caractere entre a et z ou A et Z
     *
     * @param c
     * @return
     */
    private char encode(char c) {
        char a = 'a';
        if (Character.isUpperCase(c)) {
            a = 'A';
        }
        char res = (char) ((((c - a) + (key.charAt(idx) - a)) % 26) + a);

        idx = (idx + 1) % key.length();
        return res;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            // encode mon caract�re
            if ((cbuf[i] >= 'a' && cbuf[i] <= 'z') || (cbuf[i] >= 'A' && cbuf[i] <= 'Z')) {
                cbuf[i] = encode(cbuf[i]);
            }

        }
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        this.write(str.toCharArray(), off, len);
    }
}
