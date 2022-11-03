package _LabWorks.Skiplist.Skiplist01;

public class ChainonFin<T extends Comparable<T>> implements ChainonAbstrait<T> {
	private static final ChainonFin<?> inst = new ChainonFin<>();

	public static ChainonFin<?> getInstance() {
		return inst; // ne peut avoir qu'une seule instance
		// on peut mettre le  constructeur privé pour qu'on appelle pas le constructeur 
	}

	public int compareTo(ChainonAbstrait<T> o) {
		if(o==this) {return 0;}
		return 1;// un chiffre strictement pisitif
	}
}