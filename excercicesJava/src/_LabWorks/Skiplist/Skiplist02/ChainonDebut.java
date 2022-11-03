package _LabWorks.Skiplist;

public class ChainonDebut<T extends Comparable<T>> implements ChainonAbstrait<T> {
	final ChainonAbstrait<T>[] suivants;

	public ChainonDebut(int n) {
		
		this.suivants = new ChainonAbstrait[n];

	}

	public int compareTo(ChainonAbstrait<T> o) {
		// Une instance de ChainonDebut est inf�rieure � toute instance de Chainon,
		// et � l�instance de ChainonFin.
		// Une instance de ChainonDebut est �gale � une autre instance de ChainonDebut.
		
		if (o instanceof Chainon) {
			return -1;
		}

		if (o instanceof ChainonFin) {
			return -1;
		}
		else
			return 0;
	}	
}

/*
 * D�finir les constructeurs des classes ChainonDebut, et Chainon. D�finir la
 * m�thode getInstance() de la classe ChainonFin. Dans le constructeur de
 * ChainonDebut, n est la taille du tableau suivants.
 */
