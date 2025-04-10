package bloque5.examen;


import entrega5.ListaOrdenada;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClientesPorAntiguedad extends ListaOrdenada<Cliente> {
	
	public ClientesPorAntiguedad() {
	    super(Comparator.comparing(Cliente::getAntiguedad).reversed());
	}
	
	//Lista con los n clientes con mas antiguedad del sistema
	public List<Cliente> topClientes(int n) {
	    List<Cliente> copia = this.elements();
	    List<Cliente> resultado = new ArrayList<>();
	    for (int i = 0; i < Math.min(n, copia.size()); i++) {
	        resultado.add(copia.get(i));
	    }
	    return resultado;
	}
}
