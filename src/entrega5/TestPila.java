package entrega5;

public class TestPila {

	public static void test() {
		System.out.println("----- Test de Pila (LIFO) -----");

		Pila<Double> pila = new Pila<>();

		System.out.println("\nAñadiendo elementos: 1.1, 2.2, 3.3");
		pila.add(1.1);
		pila.add(2.2);
		pila.add(3.3);

		System.out.println("\nElementos en la pila: " + pila.elements());
		System.out.println("Tamaño de la pila: " + pila.size());

		try {
			System.out.println("\nElemento en el tope: " + pila.top());
		} catch (IllegalStateException e) {
			System.out.println("\nExcepción al acceder al tope: " + e.getMessage());
		}

		System.out.println("\nDesapilando elementos:");

		try {
			Double d1 = pila.remove();
			System.out.println("\nDesapilado: " + d1);
			System.out.println("Pila restante: " + pila.elements());

			Double d2 = pila.remove();
			System.out.println("\nDesapilado: " + d2);
			System.out.println("Pila restante: " + pila.elements());

			Double d3 = pila.remove();
			System.out.println("\nDesapilado: " + d3);
			System.out.println("Pila restante: " + pila.elements());

			System.out.println("\n¿Está vacía? " + pila.isEmpty());

			pila.top(); // Intentamos acceder al tope de una pila vacía, deberia dar error

		} catch (IllegalStateException e) {
			System.out.println("\nExcepción correctamente lanzada al intentar acceder al tope de una pila vacía: "
					+ e.getMessage());
		}
	}

	public static void main(String[] args) {
		test();

	}
}
