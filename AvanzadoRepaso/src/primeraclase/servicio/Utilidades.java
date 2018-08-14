package primeraclase.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utilidades {

	public static int generarRandomInt(int minimo, int maximo) {
		Random generadorRandom = new Random();
		int cantidad = generadorRandom.nextInt(maximo);
		while(cantidad < minimo) {
			cantidad = generadorRandom.nextInt(maximo);
		}
		
		return cantidad;
	}
}
