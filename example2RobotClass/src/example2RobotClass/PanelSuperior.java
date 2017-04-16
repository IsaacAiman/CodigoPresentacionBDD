/**
 * @authors Javier Ramos Fernández and Isaac Aiman Salas
 * @date 17 April 2017
 * @subject Programación de Aplicaciones Interactivas
 * Demonstration of the Java Robot Class.
 */

package example2RobotClass;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Class that represents the upper panel.
 * 
 *
 */
public class PanelSuperior extends JPanel {
	private final static Integer TAMANIO_RADIO = 30;
	/** Radious of the ball **/
	private ArrayList<Geometria> elementos;
	/** Array of figures **/
	private Integer numero_elementos;
	/** Number of elements **/
	private Integer movimiento_pixeles;

	/** Number of pixels to move **/

	public PanelSuperior(Integer movimiento_pixeles, Integer numero_elementos) {
		elementos = new ArrayList<Geometria>();

		this.numero_elementos = numero_elementos;
		this.movimiento_pixeles = movimiento_pixeles;
		setBackground(Color.BLUE);
	}

	/**
	 * Method that draws the components of the panel.
	 */
	protected void paintComponent(Graphics grafico) {
		super.paintComponent(grafico);
		Dibujable dibujo;
		setBackground(new Color(0, 255, 255));
		for (int i = 0; i < getNumeroElementos(); i++) {
			dibujo = (Dibujable) getElementos().get(i);
			dibujo.dibujar(grafico);

		}
	}

	/**
	 * Method that initializes the position of the elements.
	 */
	public void inicializarPosicion() {
		Integer posicion_inicial_x = getTamanioRadio();
		Integer posicion_inicial_y = getTamanioRadio();
		for (int i = 0; i < getNumeroElementos(); i++) {
			if (i == 0)
				getElementos()
						.add(new Bola(posicion_inicial_x, posicion_inicial_y, getTamanioRadio(), Color.RED, this));
			else
				getElementos()
						.add(new Bola(posicion_inicial_x, posicion_inicial_y, getTamanioRadio(), Color.BLUE, this));
			posicion_inicial_x += 2 * getTamanioRadio();
		}
	}

	/**
	 * Method that returns the number of pixels to move.
	 * 
	 * @return
	 */
	public Integer getMovimientoPixeles() {
		return movimiento_pixeles;
	}

	/**
	 * Method that sets a new number of pixels to move.
	 * 
	 * @param movimiento_pixeles
	 */
	public void setMovimientoPixeles(Integer movimiento_pixeles) {
		this.movimiento_pixeles = movimiento_pixeles;
	}

	/**
	 * Method that sets a new collection of elements.
	 * 
	 * @param elementos
	 *            New collection of elements.
	 */
	public void setElements(ArrayList<Geometria> elementos) {
		this.elementos = elementos;
	}

	/**
	 * 
	 * Method that returns the number of elements.
	 * 
	 * @return numero_elementos as Integer
	 */
	public Integer getNumeroElementos() {
		return numero_elementos;
	}

	/**
	 * Method that sets a new number of elements.
	 * 
	 * @param numero_bolas
	 *            New number of elements.
	 */
	public void setNumeroElementos(Integer numero_bolas) {
		this.numero_elementos = numero_bolas;
	}

	/**
	 * Method that returns the radius of the balls.
	 * 
	 * @return
	 */
	public static Integer getTamanioRadio() {
		return TAMANIO_RADIO;
	}

	/**
	 * Method that returns the array of elements.
	 * 
	 * @return
	 */
	public ArrayList<Geometria> getElementos() {
		return elementos;
	}

}
