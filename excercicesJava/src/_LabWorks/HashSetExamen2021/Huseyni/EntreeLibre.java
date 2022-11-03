package examen23Juin2021;

public class EntreeLibre<T> extends EntreeAbstraite<T> {
	
	
	private static EntreeLibre instance = new EntreeLibre();
	
	private EntreeLibre(){
		super();// par defaut super est toujours appelé, on peut sans passer
	}
	
	public static <V> EntreeLibre<V> getInstance(){
		return instance;
	}
	
	public String toString(){
		return "";
	}
	

	@Override
	public T get() {
		return null;// pas sur ??
	}

}
