package entrega5;

import java.util.ArrayList;
import java.util.List;

public class ColaPrioridad<E, P extends Comparable<P>> extends Cola<PriorityElement<E, P>> {
	
	public ColaPrioridad() {
		super();
		//Constructor
	}
	
	public static <E, P extends Comparable<P>> ColaPrioridad<E, P> ofPriority() {
		return new ColaPrioridad<>();
		//Metodo de factoria
	}
	
    @Override
    public void add(PriorityElement<E, P> element) {
        for (int index = 0; index < elementos.size(); index++) {
            if (element.priority().compareTo(elementos.get(index).priority()) < 0) {
                elementos.add(index, element);
                return;
            }
        }
        elementos.add(element);
	}
    
    public void add(E value, P priority) {
        add(new PriorityElement<>(value, priority));
        // Añade un nuevo valor con su prioridad
    }
    
    public List<E> valuesAsList() {
        List<E> values = new ArrayList<>();
        for (PriorityElement<E, P> elem : elementos) {
            values.add(elem.value());
        }
        return values;
        // Devuelve una lista con solamente los valores
	}
    
    public void decreasePriority(E value, P newPriority) {
        PriorityElement<E, P> objetivo = null;
        for (PriorityElement<E, P> elem : elementos) {
            if (elem.value().equals(value)) {
                objetivo = elem;
                break;
        // Busca el elemento que tenga ese valor
            }
        }
        if (objetivo != null) {
            elementos.remove(objetivo);
            add(new PriorityElement<>(value, newPriority));
        // Si lo encuentra, lo quita y lo reinserta con menor prioridad
        }
        
	}
    
    public E removeValue() {
        PriorityElement<E, P> eliminado = remove();
        return eliminado.value();
        // Elimina el elemento con mayor prioridad
    }
    
    public void addAllValues(List<E> values, P priority){
    	for (E value:values) {
    		add(value,priority);
    	}
    	//Añade una lista de valores con la misma prioridad
    }
}
