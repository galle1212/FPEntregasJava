package bloque5.examen;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class EstadisticasClientes {

    // Metodo en version funcional
    public static Map<Cliente, List<Compra>> agruparComprasPorClienteFuncional(List<Compra> compras) {
        return compras.stream().collect(Collectors.groupingBy(Compra::getCliente));
    }

    // Metodo en version imperativa
    public static Map<Cliente, List<Compra>> agruparComprasPorClienteImperativa(List<Compra> compras) {
        Map<Cliente, List<Compra>> resultado = new HashMap<>();

        for (Compra compra : compras) {
            Cliente cliente = compra.getCliente();

            if (!resultado.containsKey(cliente)) {
                resultado.put(cliente, new ArrayList<>());
            }

            resultado.get(cliente).add(compra);
        }

        return resultado;
    }
}
