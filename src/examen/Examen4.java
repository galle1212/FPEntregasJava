package examen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Examen4 {
	//DEFINICION DE FUNCIONES
	//Funcion A
	public static Integer productoImpares(Integer n) {
		if (n <= 0) {
			throw new IllegalArgumentException("n debe ser mayor que 0");
		}
		
        Integer producto = 1;
        Integer numeroImpar = 1;
        
		for (Integer i=0; i<n ; i++) {
            producto *= numeroImpar;
            numeroImpar += 2;
		}
		
        return producto;
	}
	
	//Funcion B
	public static Double sumaGeometricaAlternada(Double a1, Double r, Integer k) {
        if (k <= 0) {
            throw new IllegalArgumentException("k debe ser mayor que 0");
        }
        if (a1 <= 0 || r <= 0) {
            throw new IllegalArgumentException("a1 y r deben ser positivos");
        }

        Double suma = 0.;
        for (Integer n = 1; n <= k; n++) {
            suma += Math.pow(-1, n) * a1 * Math.pow(r, n - 1);
        }

        return suma;
    }
	
	//Funcion C
	public static Integer combinatorioSinMultiplosDeTres(Integer n, Integer k) {
	    if (n <= 0 || k <= 0) {
	        throw new IllegalArgumentException("n y k deben ser positivos");
	    }
	    if (n < k) {
	        throw new IllegalArgumentException("n debe ser mayor o igual que k");
	    }

	    Integer numerador = 1;
	    Integer denominador = 1;

	    for (Integer i = 0; i < k; i++) {
	        Integer num = n - i;
	        Integer den = i + 1;

	        // Si el numerador o el denominador es múltiplo de 3, ignoramos el término.
	        if (num % 3 != 0 && den % 3 != 0) {
	            numerador *= num;
	            denominador *= den;
	        }
	    }

	    return numerador/denominador;
	}
    
	
	//Funcion D
	public static List<String> filtrarLineasConsecutivas(String fichero, List<String> palabrasClave) {
        List<String> lineasFiltradas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(" ");
                for (int i = 0; i < palabras.length - 1; i++) {
                    if (palabrasClave.contains(palabras[i]) && palabrasClave.contains(palabras[i + 1])) {
                        lineasFiltradas.add(linea);
                        break;
                    }
                }
            }
        } 		
        catch(IOException e) {
			e.printStackTrace();
        }

        return lineasFiltradas;
    }
	
	
	
	//TESTEOS DE FUNCIONES
	//Test funcion A
	public static void testProductoImpares() {
        System.out.println("A) Test de productoImpares:");

        try {
            System.out.println(productoImpares(5)); // Caso correcto
            System.out.println(productoImpares(-2)); // Caso en el que n es menor o igual que 0
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	
	//Test funcion B
    public static void testSumaGeometricaAlternada() {
        System.out.println("\n\nB) Test de sumaGeometricaAlternada:");

        try {
            System.out.println(sumaGeometricaAlternada(2., 3., 4)); // Caso correcto
            System.out.println(sumaGeometricaAlternada(2., 4., -3)); // Caso en el que k es menor o igual que 0
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(sumaGeometricaAlternada(-1., -5., 4)); // Caso en el que a1 o r son negativos
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	//Test funcion C
    public static void testCombinatorioSinMultiplosDeTres() {
        System.out.println("\n\nC) Test de combinatorioSinMultiplosDeTres:");

        try {
            System.out.println(combinatorioSinMultiplosDeTres(5, 2)); // Caso correcto
            System.out.println(combinatorioSinMultiplosDeTres(2, 7)); // Caso en el que n es mayor que k
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(combinatorioSinMultiplosDeTres(-2, -5)); // Caso en el que n y k son negativos
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	//Test funcion D
    public static void testFiltrarLineasConsecutivas() {
        System.out.println("\n\nD) Test de filtrarLineasConsecutivas:");

        List<String> palabrasClave = List.of("salud", "proyecto");
        String fichero = "resources/archivo_palabras.txt";

        try {
            List<String> lineasFiltradas = filtrarLineasConsecutivas(fichero, palabrasClave);
            System.out.println("Líneas encontradas: " + lineasFiltradas.size());
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        testProductoImpares();
        testSumaGeometricaAlternada();
        testCombinatorioSinMultiplosDeTres();
        testFiltrarLineasConsecutivas();
    }
}
