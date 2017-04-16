/*
 * Programa que ejecuta una un juego en el que una bola se desplaza por la pantalla
 * al pulsar los botones de arriba, abajo, izquierda y derecha.
 * Asignatura: Programación de aplicaciones interactivas.
 */
package ull.esit.tercero.pai;

/**
 * Clase que ejecuta el juego de la bola movil.
 */
public class BolaMovil {
	
	public static void main(String args[]){
		
		if (args.length == 0){
			System.err.println("Error. Para ejecutar el programa introduzca por línea de comandos"
					+ " el número de pixeles que desea que se desplace la bola.");
			
		}
		else{
			new BolaMovilController(new BolaMovilPanel(), new BolaMovilControles(), new Integer(args[0]));
		}
		
	}

}
