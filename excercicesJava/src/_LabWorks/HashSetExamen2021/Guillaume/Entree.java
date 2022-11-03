package _LabWorks.HashSetExamen2021.Guillaume;

public class Entree<T> extends EntreeAbstraite<T> {

	private T t;

	public Entree(T t) {
		super(); 
		this.t = t;
	}

	public String tostring() {
		return t.toString();
	}
	
	@Override
	public T get() {
		return this.t;
	}

}
