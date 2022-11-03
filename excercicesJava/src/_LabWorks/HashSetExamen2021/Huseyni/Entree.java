package examen23Juin2021;

public class Entree<T> extends EntreeAbstraite<T> {

	private T t;
	
	public Entree(T t){
		this.t = t;	
	}
	 
	public T get(){
		return this.t;	
	}
	
	public String toString(){
		return this.get()+"";
	}
}
