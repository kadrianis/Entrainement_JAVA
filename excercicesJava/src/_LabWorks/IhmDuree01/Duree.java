package _LabWorks.IhmDuree01;

public class Duree {

    private int secondes;

    public Duree() {
        // Ce constructeur permet d'obtenir une duree de 0 secondes
        this.secondes = 0;
    }

    public Duree(int secondes) {
        // Ce constructeur permet d'obtenir une duree exprimee en secondes
        // secondes doit etre compris entre 0 et 86399
        if (secondes < 0 || secondes > 86399) {
            throw new ArithmeticException("incorrecte");
        }
        this.secondes = secondes;
    }

    public Duree(int heures, int minutes, int secondes) {
        // Ce constructeur permet d'obtenir une duree exprimee en heures, minutes et
        // secondes
        // La duree exprimee doit etre positive ou nulle et inferieure a un jour
        // TODO : le cas ou on rentre un espace

        if (secondes < 0 || secondes > 59)
            throw new IllegalArgumentException("Merci de donner un int entre 0 et 60");
        if (minutes < 0 || minutes > 59)
            throw new IllegalArgumentException("Merci de donner un int entre 0 et 60");
        if (heures < 0 || heures > 24)
            throw new IllegalArgumentException("Merci de donner un int entre 0 et 24");
        this.secondes = (heures * 3600) + (minutes * 60) + secondes;
    }

    public int getHeures() {
        // retourne le nombre d'heures pleines
        return (int) this.secondes / 3600;
    }

    public int getMinutes() {
        // retourne le nombre de minutes pleines qui ne sont pas dans une heure pleine
        int temp = this.secondes % 3600;
        temp = (int) temp / 60;
        return temp;
    }

    public int getSecondes() {
        // retourne le nombre de secondes qui ne sont pas dans une minute pleine
        int temp = this.secondes % 60;
        return temp;
    }

    public int enSecondes() {
        // retourne la duree exprimee en secondes
        return this.secondes;
    }

    public static void main(String[] args) {

        Duree a = new Duree(1, 2, 59);
        System.out.println(a.getSecondes());
    }

}

