package _LabWorks.Skiplist.Skiplist01;

public class ChainonDebut<T extends Comparable<T>> implements ChainonAbstrait<T> {
	final ChainonAbstrait<T>[] suivants;

	public ChainonDebut(int n) {
		this.suivants = new ChainonAbstrait[n];
		for(int i=0;i<n;i++) {
		suivants[i]=(ChainonAbstrait<T>)ChainonFin.getInstance();
		}
	}

	public int compareTo(ChainonAbstrait<T> o) {
		if (o instanceof ChainonFin || o instanceof Chainon) {
			return -1;
		}
		return 1;
	}
}