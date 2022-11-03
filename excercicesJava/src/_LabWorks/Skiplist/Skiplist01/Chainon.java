package _LabWorks.Skiplist.Skiplist01;

public class Chainon<T extends Comparable<T>> extends ChainonDebut<T> {
	protected T element;

	public Chainon(int n, T e) {
		super(n);
		this.element=e;
	}

	public int compareTo(ChainonAbstrait<T> o) {
		if(o instanceof Chainon) {
			return element.compareTo(((Chainon<T>)o).element);
		}else if (o instanceof ChainonFin) {
			return -1;
		}
		return 1;
	}
}