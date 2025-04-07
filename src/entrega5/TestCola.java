package entrega5;

public class TestCola {

	public static void test() {
		System.out.println("----- Test de Cola (FIFO) -----");

		Cola<String> cola = Cola.of();

		System.out.println("\nAñadiendo elementos: 'primero', 'segundo', 'tercero'");
		cola.add("primero");
		cola.add("segundo");
		cola.add("tercero");

		System.out.println("\nElementos en la cola: " + cola.elements());
		System.out.println("Tamaño de la cola: " + cola.size());

		System.out.println("\nDesencolando elementos:");

		try {
			String e1 = cola.remove();
			System.out.println("\nDesencolado: " + e1);
			System.out.println("Cola restante: " + cola.elements());

			String e2 = cola.remove();
			System.out.println("\nDesencolado: " + e2);
			System.out.println("Cola restante: " + cola.elements());

			String e3 = cola.remove();
			System.out.println("\nDesencolado: " + e3);
			System.out.println("Cola restante: " + cola.elements());

			System.out.println("\n¿Está vacía? " + cola.isEmpty());

			cola.remove(); // Esto debe lanzar excepcion ya que no quedan elementos en la cola
		} catch (IllegalStateException e) {
			System.out.println(
					"\nExcepción correctamente lanzada al intentar desencolar de una cola vacía: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		test();
	}

}
