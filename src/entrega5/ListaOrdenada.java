package entrega5;

import java.util.Comparator;

public class ListaOrdenada<E> extends AgregadoLineal<E> {

	private Comparator<E> comparator;
	// Comparador para definir el orden de los elementos.
	// Es del tipo Comparator<E>, que viene definido por defecto en la librería

	public ListaOrdenada(Comparator<E> comparator) {
		super();
		this.comparator = comparator;
		// Constructor
	}

	public static <E> ListaOrdenada<E> of(Comparator<E> comparator) {
		return new ListaOrdenada<>(comparator);
		// Metodo de factoria
	}

	private int indexOrder(E e) {
		for (int i = 0; i < elementos.size(); i++) {
			if (comparator.compare(e, elementos.get(i)) < 0) {
				return i;
			}
		}
		return elementos.size();
		// Calcula la posición donde debería insertarse el nuevo elemento para mantener
		// el orden
	}

	@Override
	public void add(E e) {
		elementos.add(indexOrder(e), e);
		// Inserta el nuevo elemento en la posición calculada para mantener el orden

	}

}