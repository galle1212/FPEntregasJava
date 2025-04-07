package entrega5;

public class Cola<E> extends AgregadoLineal<E> {

	public Cola() {
		super();
		// Constructor
	}

	public static <E> Cola<E> of() {
		return new Cola<>();
		// Metodo factoria
	}

	@Override
	public void add(E e) {
		elementos.add(e);
		// Se agrega un elemento al final de la lista
	}

	@Override
	public E remove() {
		if (isEmpty()) {
			throw new IllegalStateException("No se puede eliminar de una cola vacía.");
		}
		return elementos.remove(0);
		// Se elimina un elemento del principio de la lista
	}
}
