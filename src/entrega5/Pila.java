package entrega5;

public class Pila<E> extends AgregadoLineal<E> {
    @Override
    public void add(E e) {
        elementos.add(0, e);
    	// Agrega un elemento en la posicion 0 de la pila
	}
    
    public E top() {
    	if (isEmpty()) {
    		throw new IllegalStateException("La pila está vacía.");
    	}
		return elementos.get(0);
		// Devuelve el elemento de la posicion 0 de la pila
	}
}
