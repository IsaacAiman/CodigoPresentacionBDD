/*
 * Clase que representa el panel en el que se sitúa la bola.
 * Asignatura: Programación de aplicaciones interactivas.
 */

package ull.esit.tercero.pai;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Clase que representa el panel en el que se sitúa la bola.
 */
public class BolaMovilPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private Color backgroundColor;
	private Bola bola;
	private static final int SIZEBOLA = 40;
	
	private boolean start;
	
	/**
	 * Constructor por defecto, crea un panel con el fondo azul.
	 */
	public BolaMovilPanel(){
		setBackgroundColor(Color.cyan);
		setStart(true);
	}
	
	/**
	 * Constructor que crea un panel con el fondo del color especificado.
	 * @param color
	 */
	public BolaMovilPanel(Color color){
		setBackgroundColor(color);	
	}
	
	/**
	 * Método encargado de dibujar sobre la pantalla la bola.
	 */
	public void paintComponent(Graphics g) {
		setBackground(getBackgroundColor());
		g.setColor(getBackgroundColor());
		super.paintComponent(g);
		
		if (isStart()){
			setBola(new Bola(g, getWidth()/2 - SIZEBOLA/2, getHeight()/2 - SIZEBOLA/2, SIZEBOLA, Color.RED, true));
		}
		else{
			
			setBola(new Bola(g, getBola().getPosX(), getBola().getPosY(), SIZEBOLA, Color.RED, true));
		}
		
		getBola().draw();
	}

	/**
	 * Mueve la bola hacia arriba. Si el último movimiento supone traspasar el borde de la pantalla,
	 * se situará la bola justo al borde de la misma y se impedirá que la bola siga moviéndose en 
	 * esa dirección.
	 * @param gap número de pixeles que se desplaza la bola.
	 */
	public void up(int gap){
		setStart(false);
		getBola().moveUp(gap);
		paintComponent(this.getGraphics());
	}
	
	/**
	 * Mueve la bola hacia abajo. Si el último movimiento supone traspasar el borde de la pantalla,
	 * se situará la bola justo al borde de la misma y se impedirá que la bola siga moviéndose en 
	 * esa dirección.
	 * @param gap número de pixeles que se desplaza la bola.
	 */
	public void down(int gap){
		setStart(false);
		getBola().moveDown(getHeight(), gap);
		paintComponent(this.getGraphics());
	}
	
	/**
	 * Mueve la bola hacia la izquierda. Si el último movimiento supone traspasar el borde de la pantalla,
	 * se situará la bola justo al borde de la misma y se impedirá que la bola siga moviéndose en 
	 * esa dirección.
	 * @param gap número de pixeles que se desplaza la bola.
	 */
	public void left(int gap){
		setStart(false);
		getBola().moveLeft(gap);
		paintComponent(this.getGraphics());
		
	}
	
	/**
	 * Mueve la bola hacia la derecha. Si el último movimiento supone traspasar el borde de la pantalla,
	 * se situará la bola justo al borde de la misma y se impedirá que la bola siga moviéndose en 
	 * esa dirección.
	 * @param gap número de pixeles que se desplaza la bola.
	 */
	public void right(int gap){
		setStart(false);
		getBola().moveRight(getWidth(), gap);
		paintComponent(this.getGraphics());
	}
	/**
	 * @return the backgroundColor
	 */
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * @param backgroundColor the backgroundColor to set
	 */
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	/**
	 * @return the bola
	 */
	public Bola getBola() {
		return bola;
	}

	/**
	 * @param bola the bola to set
	 */
	public void setBola(Bola bola) {
		this.bola = bola;
	}

	/**
	 * @return the start
	 */
	public boolean isStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(boolean start) {
		this.start = start;
	}
	

}
