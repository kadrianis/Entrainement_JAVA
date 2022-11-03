package _LabWorks.IhmDuree02.src.duree;

public class Duree {

	private int secondes;

	public Duree() {
		// Ce constructeur permet d'obtenir une duree de 0 secondes
		this.secondes = 0;
	}

	public Duree(int secondes) {
		// Ce constructeur permet d'obtenir une duree exprimee en secondes
		// secondes doit etre compris entre 0 et 86399
		if (secondes>86399 ||secondes<0 )
			throw new IllegalArgumentException("Merci de rentrer une duree correcte");
			this.secondes=secondes;
	}

	public Duree(int heures, int minutes, int secondes) {
		// Ce constructeur permet d'obtenir une duree exprimee en heures, minutes et secondes
		// La duree exprimee doit etre positive ou nulle et inferieure a un jour
		if ((secondes>60 ||secondes<0) || (minutes>60 ||minutes<0) ||(heures>24 ||heures<0) )
			throw new IllegalArgumentException("Merci de rentrer une duree correcte");
			this.secondes = secondes + minutes *60 + heures*3600;		
	}

	public int getHeures() {
		// retourne le nombre d'heures pleines
		return ((this.secondes / 3600));
	}

	public int getMinutes() {
		// retourne le nombre de minutes pleines qui ne sont pas dans une heure pleine
		return ((this.secondes % 3600) / 60);

	}

	public int getSecondes() {
		// retourne le nombre de secondes qui ne sont pas dans une minute pleine
		return ((this.secondes % 3600) % 60);
	}

	public int enSecondes() {
		// retourne la duree exprimee en secondes
		return (this.getHeures()*3600 +this.getMinutes()*60 + this.getSecondes());
	}

	public static void main(String[] args) {
		// Methode main si vous souhaitez faire des tests
		Duree d = new Duree(1,1,24);
		System.out.println(d.getMinutes());
	}
}
