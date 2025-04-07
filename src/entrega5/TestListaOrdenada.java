package entrega5;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

// Test de ListaOrdenada

public class TestListaOrdenada {

	public static void test() {

		// Creamos una listaOrdenada de enteros con un comparador de orden natural
		ListaOrdenada<Integer> lista = ListaOrdenada.<Integer>of(Comparator.naturalOrder());

		System.out.println("----- Test de ListaOrdenada -----");

		System.out.println("\nAñadiendo elementos: 5, 2, 8, 1, 3");
		lista.add(5);
		lista.add(2);
		lista.add(8);
		lista.add(1);
		lista.add(3);

		System.out.println("Elementos en la lista: " + lista.elements());

		System.out.println("Tamaño de la lista: " + lista.size());

		Integer eliminado = lista.remove();
		System.out.println("Eliminando el primer elemento: " + eliminado);

		System.out.println("Elementos después de eliminar: " + lista.elements());

		System.out.println("Añadiendo elementos en lote: 4, 6, 7");
		List<Integer> lote = Arrays.asList(4, 6, 7);
		lista.addAll(lote);

		System.out.println("Elementos después de añadir lote: " + lista.elements());

		List<Integer> eliminados = lista.removeAll();
		System.out.println("Eliminando todos los elementos: " + eliminados);

		System.out.println("¿Está vacía? " + lista.isEmpty());

		System.out.println("Prueba con strings:");
		ListaOrdenada<String> listaStrings = ListaOrdenada.<String>of(Comparator.naturalOrder());
		listaStrings.add("apple");
		listaStrings.add("banana");
		listaStrings.add("cherry");
		listaStrings.add("date");
		System.out.println("Elementos ordenados: " + listaStrings.elements());

	}

	public static void main(String[] args) {
		test();
	}
}
