package entrega5;

import java.util.ArrayList;
import java.util.List;

public abstract class AgregadoLineal<E> {
	protected List<E> elementos;

	public AgregadoLineal() {
		this.elementos = new ArrayList<>();
		// Constructor (lo que en python equivalia a __init__)
	}

	public int size() {
		return elementos.size();
		// Devuelve el numero de elementos de la ArrayList
	}

	public boolean isEmpty() {
		return elementos.size() == 0;
		// Devuelve true o false si esta o no vacio el agregado
	}

	public List<E> elements() {
		List<E> elementosCopia = new ArrayList<>(elementos);
		return elementosCopia;
		// Hace una copia del agregado
	}

	public abstract void add(E e);
	// El metodo add es abstracto y lo implementaremos en las subclases

	public void addAll(List<E> list) {
		for (E e : list) {
			add(e);
			// Añade directamente todos los elementos de una lista
		}
	}

	public E remove() {
		if (!elementos.isEmpty()) {
			return elementos.remove(0);
		}
		return null;

		// Si el agregado no esta vacio, elimina el primer elemento
	}

	public List<E> removeAll() {
		List<E> removedElements = new ArrayList<>(elementos);
		elementos.clear();
		return removedElements;
		// Elimina todos los elementos y los mete en una ArrayList
	}
}
