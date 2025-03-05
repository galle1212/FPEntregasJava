package entrega4;

import java.util.function.Function;

public class Funciones {
	//Funcion 1
    public static Integer calcularProducto(Integer n, Integer k) {
       if (n <= k) {
           throw new IllegalArgumentException("n debe ser mayor que k");
       }
       
       Integer producto = 1;
       for (Integer i = 0; i < k; i++) {
            producto = producto * (n - i + 1);
       }
       return producto;
    }
    
    
	//Funcion 2
	public static Double secuenciaGeometrica(Double a1, Double r, Integer k) {
		if (k <= 0) {
			throw new IllegalArgumentException("k debe ser mayor que 0");
		}

		Double producto = 1.;
		for (Integer i = 0; i < k; i++) {
			producto = producto * a1 * Math.pow(r, i);
		}
		return producto;
	}
    
	
	//Funcion 3
	
	//Como no existe una funcion por defecto para calcular el factorial vamos a crear una:
	public static Integer factorial(Integer n) {
		
		Integer fact = 1;
	    for (Integer i = 2; i <= n; i++) {
	        fact *= i;
	    }
		return fact;
	}
	
	//Ahora hacemos el numero combinatorio
	public static Integer numeroCombinatorio(Integer n, Integer k) {
		if (n < k) {
			throw new IllegalArgumentException("n debe ser mayor o igual que k");
		}

		Integer numcomb = factorial(n)/(factorial(k)*factorial(n-k));
		return numcomb;
	}
	
	// Funcion 4
	public static Double calcularS(Integer n, Integer k) {
		if (n < k) {
			throw new IllegalArgumentException("n debe ser mayor o igual a k");
		}

		Double suma = 0.;
		for (Integer i = 0; i < k; i++) {
			Double termino = Math.pow(-1, i) * numeroCombinatorio(k + 1, i + 1) * Math.pow(k - i, n);
			suma = suma + termino;
		}

		return suma / factorial(k);
	}

	// Funcion 5
	public static Double metodoNewton(Function<Double, Double> f, Function<Double, Double> fDerivada, Double a,Double epsilon) {
		Double xn = a;

		while (true) {
			if (Math.abs(f.apply(xn)) <= epsilon) {
				return xn;
			}
			xn = xn - f.apply(xn) / fDerivada.apply(xn);
		}
	}
    
	
	
	//TESTS
    public static void main(String[] args) {
        // Test funcion 1:
    	Integer n = 4;
        Integer k = 2;
        System.out.println("TEST DE LA FUNCION 1:");
        System.out.println("El resultado del producto es: " + calcularProducto(n, k));
        System.out.println("################################");
        
        // Test funcion 2:
        Double a1=3.;
        Double r=5.;
        k=2;
        System.out.println("TEST DE LA FUNCION 2:");
        System.out.println("El resultado de la secuencia geometrica es: " + secuenciaGeometrica(a1,r,k));
        System.out.println("################################");

        // Test funcion 3:
        n=4;
        k=2;
        System.out.println("TEST DE LA FUNCION 3:");
        System.out.println("El numero combinatorio es: " + numeroCombinatorio(n,k));
        System.out.println("################################");
    
        // Test funcion 4:
        n=4;
        k=2;
        System.out.println("TEST DE LA FUNCION 4:");
        System.out.println("El numero S(n,k) es: " + calcularS(n,k));
        System.out.println("################################");
        
        // Test funcion 5:
        Function<Double, Double> f = x -> 2 * x * x;
        Function<Double, Double> fDerivada = x -> 4 * x;
        Double a=3.;
        Double epsilon=0.001;
        System.out.println("TEST DE LA FUNCION 5:");
        System.out.println("La aproximacion del metodo de Newton es: " + metodoNewton(f, fDerivada, a, epsilon));
        System.out.println("################################");
    }
}