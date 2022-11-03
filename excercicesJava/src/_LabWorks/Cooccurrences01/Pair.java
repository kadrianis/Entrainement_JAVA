package _LabWorks.Cooccurrences01;

public class Pair<X> {
	private final X e1;
	private final X e2;

	public Pair(X e1, X e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

	public X getE1() {
		return e1;
	}

	public X getE2() {
		return e2;
	}
		
	public boolean equals(Object o) {
		if(!( o instanceof Pair))
			return false;
		
		Pair p = (Pair)o;
		
		return ((p.getE1().equals(this.e1) && p.getE2().equals(this.e2)) || (p.getE1().equals(this.e1)) && p.getE2().equals(this.e2));
	}
	
	public int hashCode() {
		return (e1.hashCode() + e2.hashCode());
	}
	
	public String toString() {
		// <e1,e2>
		return ("<" + e1 + ',' + e2 + ">");
		
	}

}
