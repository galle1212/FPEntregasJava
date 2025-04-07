package entrega5;

import java.util.Comparator;

public class ListaOrdenadaSinRepeticion<E> extends ListaOrdenada<E> {

	public ListaOrdenadaSinRepeticion(Comparator<E> comparator) {
		super(comparator);
		// Constructor
	}

	public static <E> ListaOrdenadaSinRepeticion<E> of(Comparator<E> comparator) {
		return new ListaOrdenadaSinRepeticion<>(comparator);
		// Metodo de factoria
	}

	@Override
	public void add(E e) {
		if (!elementos.contains(e)) { //En el caso en el que no exista,
			super.add(e); // reutiliza el metodo add de la clase ListaOrdenada
		}
	}
}
