package entrega4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lecturas {
	// Funcion 6
	public static Integer cuentaPalabras(String fichero, String sep, String cad) {
		int contador = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
			String linea;

			while ((linea = br.readLine()) != null) {

				String[] palabras = linea.split(sep);

				for (String palabra : palabras) {
					if (palabra.equalsIgnoreCase(cad)) {
						contador++;
					}
				}
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return contador;
	}

	// Funcion 7
	public static List<String> lineasContenganPalabra(String fichero, String cad) {
		List<String> listaCad = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {

			String linea;

			while ((linea = br.readLine()) != null) {
				if (linea.contains(cad)) {
					listaCad.add(linea);

				}
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return listaCad;
	}

	// Funcion 8
	public static List<String> listaPalabrasSinRepetir(String fichero) {
		List<String> listaCad = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {

			String linea;

			while ((linea = br.readLine()) != null) {

				String[] listaPalabras = linea.split(" ");
				for (String palabra : listaPalabras) {
					if (!(listaCad.contains(palabra))) {
						listaCad.add(palabra);
					}
				}
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return listaCad;
	}
	
	
	// Funcion 9
	public static Double longitudPromedioLineas(String fichero, String sep) {
		
		Double numPalabras = 0.;
		Double numLineas = 0.;
		try (BufferedReader br= new BufferedReader(new FileReader(fichero))){

			String linea;
			while((linea = br.readLine()) != null) {
				String[] listaPalabras = linea.split(sep);
				numLineas++;
				for (String palabra:listaPalabras) {
					numPalabras++;
				}
			}
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		return numPalabras/numLineas;
	}
	
	

	
	

	// TESTS
	public static void main(String[] args) {
		// Test funcion 6:
		String fichero = "resources/lin_quijote.txt";
		String sep = " ";
		String cad = "quijote";
		System.out.println("TEST DE LA FUNCION 6:");
		System.out.println("El número de veces que aparece la palabra en el fichero es: " + cuentaPalabras(fichero, sep, cad));
		System.out.println("################################");
		// Test funcion 7:
		fichero = "resources/lin_quijote.txt";
		cad = "la";
		System.out.println("TEST DE LA FUNCION 7:");
		System.out.println("Las lineas en las que aparece la palabra son: " + lineasContenganPalabra(fichero, cad));
		System.out.println("################################");
		// Test funcion 8:
		fichero = "resources/archivo_palabras.txt";
		System.out.println("TEST DE LA FUNCION 8:");
		System.out.println("Las unicas palabras que existen en el fichero son: " + listaPalabrasSinRepetir(fichero));
		System.out.println("################################");
		// Test funcion 9:
		fichero = "resources/palabras_random.csv";
		sep = ",";
		System.out.println("TEST DE LA FUNCION 9:");
		System.out.println("La longitud promedio de las lineas del fichero es: " + longitudPromedioLineas(fichero, sep));
		System.out.println("################################");
	}
}
