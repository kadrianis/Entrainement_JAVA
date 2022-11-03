package _LabWorks.Skiplist;

public class ChainonFin<T extends Comparable<T>> implements ChainonAbstrait<T> {

	private static final ChainonFin<?> inst = new ChainonFin<>();

	public static ChainonFin<?> getInstance() {
		
		return inst; // je ne sais pas si c'est correcte
		
	}
	
	@Override
	public int compareTo(ChainonAbstrait<T> o) {
		// Une instance de ChainonDebut est inf�rieure � toute instance de Chainon,
		// et � l�instance de ChainonFin.
		// Une instance de ChainonDebut est �gale � une autre instance de ChainonDebut.
		if (o instanceof ChainonDebut) {
			return 1;
		}
		else  // dans le cas d'un chainon fin --> egale
			return 0;
		}
		

	
}
	