package bloque5.examen;

import entrega5.Pila;
import java.util.List;
import java.util.stream.Collectors;

public class HistorialCompras extends Pila<Compra> {

    public double totalGastadoPor(Cliente cliente) {
        return this.elements().stream().filter(compra -> compra.getCliente().equals(cliente)).mapToDouble(Compra::getImporte).sum();
    }

    public List<Compra> comprasMayoresA(double cantidad) {
        return this.elements().stream().filter(compra -> compra.getImporte() > cantidad).collect(Collectors.toList());
    }
}