package listeChainee;

class Chainon<E> {
	
	E elem;
	
	Chainon precedent;
	Chainon suivant;

	public Chainon(E elem, Chainon precedent, Chainon suivant) {
		super(); // sure ?
		this.elem = elem;
		this.precedent = precedent;
		this.suivant = suivant;
	}
	
	
	private Chainon tete;
	private Chainon queue;
	private int nbElem;
	
	private void MalistChainee() {
		tete=null;
		queue=null;
		
	}
	
}
