/**
 * @authors Javier Ramos Fernández and Isaac Aiman Salas
 * @date 17 April 2017
 * @subject Programación de Aplicaciones Interactivas
 * Demonstration of the Java Robot Class.
 */

package example2RobotClass;

import javax.swing.Timer;

/**
 * Abstract class that represents a figure.
 *
 */
public abstract class Geometria {

	/**
	 * Method that moves a figure a number of pixels to the right.
	 */
	public abstract void moverDerecha(PanelSuperior panel);	
	
	/**
	 * Method that moves a figure a number of pixels to the left.
	 */
	public abstract void moverIzquierda(PanelSuperior panel);
	
	/**
	 * Method that moves a figure a number of pixels up.
	 */
	public abstract void moverArriba(PanelSuperior panel);
	
	/**
	 * Method that moves a figure a number of pixels down.
	 */
	public abstract void moverAbajo(PanelSuperior panel);

	public abstract void moverNoroeste(PanelSuperior panel_superior);
	public abstract void moverNoreste(PanelSuperior panel_superior);
	public abstract void moverSuroeste(PanelSuperior panel_superior);
	public abstract void moverSureste(PanelSuperior panel_superior);

	public abstract Timer  getTimer();
		
	

}
