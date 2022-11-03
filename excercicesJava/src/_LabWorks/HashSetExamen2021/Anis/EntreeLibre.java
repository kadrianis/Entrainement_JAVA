package _LabWorks.HashSetExamen2021.Anis;

public class EntreeLibre<T> extends EntreeAbstraite<T> {

	private static EntreeLibre instance = new EntreeLibre();

	private EntreeLibre() {
		// libro
	}

	public static <V> EntreeLibre<V> getInstance() {
		return instance;
	}

	public String tostring() {
		return "";
	}

	@Override
	public T get() {
		return null; // rien
	}

}
