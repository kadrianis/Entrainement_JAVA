package _LabWorks.HashSetExamen2021.Guillaume;

public class EntreeLibre<T> extends EntreeAbstraite<T> {

	private static EntreeLibre instance = new EntreeLibre();

	private EntreeLibre() {
		
	}

	public static <V> EntreeLibre<V> getInstance() {
		return instance;
	}

	public String tostring() {
		return "";
	}

	@Override
	public T get() {
		return null;

	}

}
