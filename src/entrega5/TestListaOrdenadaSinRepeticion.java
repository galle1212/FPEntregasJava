package entrega5;

import java.util.Arrays;
import java.util.Comparator;

public class TestListaOrdenadaSinRepeticion {

	public static void test() {

		// Creamos una lista sin numeros repetidos 
		ListaOrdenadaSinRepeticion<Integer> lista = ListaOrdenadaSinRepeticion.<Integer>of(Comparator.naturalOrder());

		System.out.println("----- Test de ListaOrdenadaSinRepeticion -----");

		System.out.println("\nAñadiendo elementos: 5, 2, 8, 1, 3, 5, 2");
		lista.add(5);
		lista.add(2);
		lista.add(8);
		lista.add(1);
		lista.add(3);
		lista.add(5);
		lista.add(2);

		System.out.println("\nElementos en la lista: " + lista.elements());
		System.out.println("Tamaño de la lista: " + lista.size());
		System.out.println("Se esperan 5 elementos únicos ordenados");

		System.out.println("\nEliminando el primer elemento: " + lista.remove());
		System.out.println("Elementos después de eliminar: " + lista.elements());

		System.out.println("\nAñadiendo elementos en lote: 4, 6, 7, 4");
		lista.addAll(Arrays.asList(4, 6, 7, 4)); // El 4 esta repetido

		System.out.println("Elementos después de añadir lote: " + lista.elements());
		System.out.println("Se espera que el 4 aparezca solo una vez");
	}

	public static void main(String[] args) {
		test();
	}

}
