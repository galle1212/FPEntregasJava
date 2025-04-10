package bloque5.examen;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestExamen5 {
	public static void main(String[] args) {
        // Clientes
        Cliente ana = Cliente.of("Ana", 5);
        Cliente juan = Cliente.of("Juan", 2);
        Cliente luis = Cliente.of("Luis", 7);

        // Compras
        Compra c1 = Compra.of(ana, "Agenda personalizada", 25.5);
        Compra c2 = Compra.of(juan, "Camiseta estampada", 60.0);
        Compra c3 = Compra.of(ana, "Taza con foto", 15.0);
        Compra c4 = Compra.of(luis, "Poster gigante", 80.0);

        // Lista de compras
        List<Compra> compras = Arrays.asList(c1, c2, c3, c4);


        // Test ClientesPorAntiguedad

        ClientesPorAntiguedad listaClientes = new ClientesPorAntiguedad();
        listaClientes.add(ana);
        listaClientes.add(juan);
        listaClientes.add(luis);

        System.out.println("Top 2 clientes más antiguos:");
        listaClientes.topClientes(2).forEach(System.out::println); // Luis, Ana


        // Test HistorialCompras

        HistorialCompras historial = new HistorialCompras();
        historial.add(c1);
        historial.add(c2);
        historial.add(c3);
        historial.add(c4);

        System.out.println("\nTotal gastado por Ana:");
        System.out.println(historial.totalGastadoPor(ana)); // 40.5

        System.out.println("\nCompras mayores a 50:");
        historial.comprasMayoresA(50).forEach(System.out::println); // c2, c4


        // Test ColaComprasPendientes

        ColaComprasPendientes cola = new ColaComprasPendientes();
        cola.add(c1);
        cola.add(c2);
        cola.add(c3);
        cola.add(c4);

        System.out.println("\nBuscar compra con descripción que contenga 'Poster':");
        System.out.println(cola.buscarCompraPorDescripcion("Poster")); // c4

        System.out.println("\nFiltrar compras de Ana que contengan 'Taza':");
        cola.filtrarPorClienteYProducto(ana, "Taza").forEach(System.out::println); // c3


        // Test EstadisticasClientes

        System.out.println("\nAgrupar compras por cliente (funcional):");
        Map<Cliente, List<Compra>> mapFunc = EstadisticasClientes.agruparComprasPorClienteFuncional(compras);
        mapFunc.forEach((cliente, cs) -> {
            System.out.println(cliente.getNombre() + " -> " + cs);
        });

        System.out.println("\nAgrupar compras por cliente (imperativa):");
        Map<Cliente, List<Compra>> mapImp = EstadisticasClientes.agruparComprasPorClienteImperativa(compras);
        mapImp.forEach((cliente, cs) -> {
            System.out.println(cliente.getNombre() + " -> " + cs);
        });
    }
}
