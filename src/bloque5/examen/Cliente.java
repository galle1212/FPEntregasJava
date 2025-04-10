package bloque5.examen;

import java.util.Objects;

public final class Cliente {
	private final String nombre;
	private final Integer antiguedad;

	// Constructor
	public Cliente(String nombre, Integer antiguedad) {
		this.nombre = nombre;
		this.antiguedad = antiguedad;
	}

	// Metodo factoria
	public static Cliente of(String nombre, Integer antiguedad) {
		return new Cliente(nombre, antiguedad);
	}

	// Metodos de consulta
	public String getNombre() {
		return nombre;
	}

	public Integer getAntiguedad() {
		return antiguedad;
	}

	// Metodos para decir que dos clientes son iguales por el nombre
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public int hashCode() {
		return Objects.hash(nombre);
	}
	
	// Metodo toString
	public String toString() {
		return String.format("Cliente[nombre=%s, antigüedad=%d]", nombre, antiguedad);
	}

}
