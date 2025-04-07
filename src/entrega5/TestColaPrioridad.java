package entrega5;

import java.util.List;

public class TestColaPrioridad {

	public static void test() {
		System.out.println("----- Test de ColaPrioridad -----\n");

		ColaPrioridad<String, Integer> cola = ColaPrioridad.ofPriority();

		System.out.println("Añadiendo elementos con prioridad:");
		cola.add("Crítico", 1);
		System.out.println("'Crítico' con prioridad 1");
		cola.add("Normal", 3);
		System.out.println("'Normal' con prioridad 3");
		cola.add("Urgente", 2);
		System.out.println("'Urgente' con prioridad 2");
		cola.add("Bajo", 4);
		System.out.println("'Bajo' con prioridad 4");

		System.out.println("\nElementos en la cola por prioridad: " + cola.valuesAsList());
		System.out.println("Elementos con sus prioridades: " + cola.elements());
		System.out.println("Tamaño de la cola: " + cola.size());

		System.out.println("\nCambiando la prioridad de 'Normal' de 3 a 1:");
		cola.decreasePriority("Normal", 1);
		System.out.println("Elementos con prioridad actualizada: " + cola.valuesAsList());

		System.out.println("\nDesencolando elementos por prioridad:");
		try {
			String v1 = cola.removeValue();
			System.out.println("\nDesencolado: " + v1);
			System.out.println("Cola restante: " + cola.valuesAsList());

			String v2 = cola.removeValue();
			System.out.println("\nDesencolado: " + v2);
			System.out.println("Cola restante: " + cola.valuesAsList());

			String v3 = cola.removeValue();
			System.out.println("\nDesencolado: " + v3);
			System.out.println("Cola restante: " + cola.valuesAsList());

			String v4 = cola.removeValue();
			System.out.println("\nDesencolado: " + v4);
			System.out.println("Cola restante: " + cola.valuesAsList());

			System.out.println("\n¿Está vacía? " + cola.isEmpty());

			// Intentamos eliminar un elemento de una cola vacía
			cola.removeValue();
		} catch (IllegalStateException e) {
			System.out.println(
					"\nExcepción correctamente lanzada al intentar desencolar de una cola vacía: " + e.getMessage());
		}

		System.out.println("\n\nPrueba con addAll:");
		List<String> tareas = List.of("Tarea A", "Tarea B", "Tarea C");
		cola.addAllValues(tareas, 2);
		System.out.println("Elementos añadidos en lote con prioridad 2: " + cola.valuesAsList());

		cola.add("Tarea Urgente", 1);
		System.out.println("Después de añadir 'Tarea Urgente' con prioridad 1: " + cola.valuesAsList());
	}

	public static void main(String[] args) {
		test();

	}

}
