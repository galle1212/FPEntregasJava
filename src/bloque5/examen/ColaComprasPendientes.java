package bloque5.examen;

import entrega5.Cola;
import java.util.List;
import java.util.stream.Collectors;

public class ColaComprasPendientes extends Cola<Compra> {

    public Compra buscarCompraPorDescripcion(String desc) {
        for (Compra compra:this.elements()) {
            if (compra.getDescripcion().contains(desc)) {
                return compra;
            }
        }
        return null;
    }

    public List<Compra> filtrarPorClienteYProducto(Cliente cliente, String producto) {
        return this.elements().stream().filter(compra -> compra.getCliente().equals(cliente) && compra.getDescripcion().contains(producto)).collect(Collectors.toList());
    }
}
