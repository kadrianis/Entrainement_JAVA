package _LabWorks.Coocurrences02;

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

	
	
	
	
	
	/**
	 * Deux paires sont �gales si leurs deux �l�ments sont �gaux quelque soit
	 * l'ordre (on suppose e1 et e2 non null)
	 */
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Pair ))
			return false;
		
		Pair p =(Pair)o;
		
		return (p.getE1().equals(this.e1) && p.getE2().equals(this.e2)) ||(p.getE1().equals(this.e2) && p.getE2().equals(this.e1));
	}

	
	
	
	
	/**
	 * Le hashcode d'une paire est la somme des hashcodes de ses deux �l�ments
	 */
	@Override
	public int hashCode() {
		int res;
		res = this.e1.hashCode() + this.e2.hashCode();
		return res;
	}

	
	
	
	
	/**
	 * Une paire est repr�sent�e de la mani�re suivante : <e1,e2>
	 */
	@Override
	public String toString() {
		return ("<" + e1 + ',' + e2 +">") ;
	}
}
