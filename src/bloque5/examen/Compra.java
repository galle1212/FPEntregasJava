package bloque5.examen;


public final class Compra {
    private final Cliente cliente;
    private final String descripcion;
    private final Double importe;

    // Constructor
    public Compra(Cliente cliente, String descripcion, Double importe) {
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.importe = importe;
    }

    // Metodo de factoria
    public static Compra of(Cliente cliente, String descripcion, Double importe) {
        return new Compra(cliente, descripcion, importe);
    }

    // Metodos de consulta
    public Cliente getCliente() {
        return cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getImporte() {
        return importe;
    }
    
    // Metodo toString
    @Override
    public String toString() {
        return String.format("Compra [Nombre de cliente = %s, descripción = %s, importe = %.2f €]", cliente.getNombre(), descripcion, importe);
    }
}