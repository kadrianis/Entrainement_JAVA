package jouerAvecDesLCollections;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Personne> m = new HashMap<String, Personne>();
        Calendar d = Calendar.getInstance();
        d.set(1950, 11, 4);
        Personne jacques = new Personne("Dupond", "Jacques", "0606060606", d);
        d = Calendar.getInstance();
        d.set(1980, 9, 30);
        Personne paul = new Personne("Martin", "Paul", "0632323232", d);
        m.put(jacques.getTel(), jacques); // je d�clare la cl� ( tel, personne)
        m.put(paul.getTel(), paul);
// Admettons que je recois un appel du 0632323232
// la question est qui m'appelle ?
        System.out.println(m.get("0632323232"));
    }
}

class Personne {

    private String nom, prenom, tel;
    private Calendar dateNaissance;

    public Personne(String nom, String prenom, String tel, Calendar dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.dateNaissance = dateNaissance;
    }

    public String getTel() {
        return tel;
    }

    @Override
    public String toString() {
        return "Personne [nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", dateNaissance="
                + SimpleDateFormat.getInstance().format(dateNaissance.getTime()) + "]";
    }
}

