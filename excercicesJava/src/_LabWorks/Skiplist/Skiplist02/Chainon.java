package _LabWorks.Skiplist;

public class Chainon<T extends Comparable<T>> extends ChainonDebut<T> {

	protected T element;

	public Chainon(int n, T e) {
		super(n);
		this.element = e;
	}

	public int compareTo(ChainonAbstrait<T> o) {
		// Une instance de ChainonDebut est inf�rieure � toute instance de Chainon,
		// et � l�instance de ChainonFin.
		// Une instance de ChainonDebut est �gale � une autre instance de ChainonDebut.
		if (o instanceof ChainonFin) {
			return -1;
		}

		else if (o instanceof Chainon) {
			return this.element.compareTo(((Chainon<T>) o).element);
		}

		else
			return 1;
	}

}
