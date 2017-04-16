/**
 * @authors Javier Ramos Fernández and Isaac Aiman Salas
 * @date 17 April 2017
 * @subject Programación de Aplicaciones Interactivas
 * Demonstration of the Java Robot Class.
 */

package example2RobotClass;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

/**
 * Class that represents a ball.
 *
 */
public class Bola extends Geometria implements Dibujable {

	public static final double PI = Math.PI;	/** PI number **/
	private Color color; /** Ball color **/
	public Integer x; /** Horizontal coordinate **/
	public Integer y; /** Vertical coordinate **/
	Bola auxiliary_ball;
	public Integer radio;
	private Timer reloj;

	public Bola(Integer posicionX, Integer posicionY, Integer radio, Color color, PanelSuperior panel) {
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				moverAleatorio(panel);
			}
		};
		reloj = new Timer(1000, taskPerformer);
		x = posicionX;
		y = posicionY;
		this.radio = radio;
		this.color = color;
		
	}

	public Bola(Integer radio, Color color) {
		x = 0;
		y = 0;
		this.radio = radio;
		this.color = color;
	}

	public Bola(Bola bola_copia) {
		x = bola_copia.getX();
		y = bola_copia.getY();
		this.radio = bola_copia.getRadio();
		this.color = color;
	}

	/**
	 * Method that draws a ball.
	 */
	public void dibujar(Graphics drawing) {
		drawing.setColor(color);
		drawing.fillOval(getX() - getRadio(), getY() - getRadio(), 2 * getRadio(), 2 * getRadio());
		if (getAuxiliaryBall() != null) {
			getAuxiliaryBall().dibujar(drawing);
		}
	}

	/**
	 * Method that returns the color of the ball.
	 * @return color as Color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Method that sets a new color to the ball.
	 * @param color New color of the ball
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Method that moves the ball a number of pixels to the left.
	 */
	public void moverIzquierda(PanelSuperior panel) {
		if ((getX() - getRadio() - panel.getMovimientoPixeles()) >= 0) {
			setX(getX() - panel.getMovimientoPixeles());
			
			panel.repaint();
		}

	}

	public void moverDerecha(PanelSuperior panel) {
		if ((getX() + getRadio() + panel.getMovimientoPixeles()) <= panel.getWidth()) {
			setX(getX() + panel.getMovimientoPixeles());
			panel.repaint();
		}
	}

	public void moverArriba(PanelSuperior panel) {

		if ((getY() - getRadio() - panel.getMovimientoPixeles()) >= 0) {
			setY(getY() - panel.getMovimientoPixeles());
			panel.repaint();
		}
	}

	public void moverAbajo(PanelSuperior panel) {

		if ((getY() + getRadio() + panel.getMovimientoPixeles()) <= panel.getHeight()) {
			setY(getY() + panel.getMovimientoPixeles());
			panel.repaint();
		}
	}



	public void moverNoroeste(PanelSuperior panel) {

		if ((getY() - getRadio() - panel.getMovimientoPixeles()) >= 0
				&& (getX() - getRadio() - panel.getMovimientoPixeles()) >= 0) {
			setX(getX() - panel.getMovimientoPixeles());
			setY(getY() - panel.getMovimientoPixeles());

		}
		panel.repaint();
	}

	public void moverNoreste(PanelSuperior panel) {

		if ((getY() - getRadio() - panel.getMovimientoPixeles()) >= 0
				&& (getX() + getRadio() + panel.getMovimientoPixeles()) <= panel.getWidth()) {
			setX(getX() + panel.getMovimientoPixeles());
			setY(getY() - panel.getMovimientoPixeles());

		}
		panel.repaint();
	}

	public void moverSuroeste(PanelSuperior panel) {

		if ((getY() + getRadio() + panel.getMovimientoPixeles()) <= panel.getHeight()
				&& (getX() - getRadio() - panel.getMovimientoPixeles()) >= 0) {
			setX(getX() - panel.getMovimientoPixeles());
			setY(getY() + panel.getMovimientoPixeles());

		}
		panel.repaint();
	}

	public void moverSureste(PanelSuperior panel) {

		if ((getY() + getRadio() + panel.getMovimientoPixeles()) <= panel.getHeight()
				&& (getX() + getRadio() + panel.getMovimientoPixeles()) <= panel.getWidth()) {
			setX(getX() + panel.getMovimientoPixeles());
			setY(getY() + panel.getMovimientoPixeles());

		}
		panel.repaint();
	}
	
	public void moverAleatorio(PanelSuperior panel) {
		Random r = new Random();
		int low = 0 + getRadio();
		int high = panel.getWidth() - getRadio();
		int x = r.nextInt(high - low) + low;
		r = new Random();
		low = 0 + getRadio();
		high = panel.getHeight() - getRadio();
		y = r.nextInt(high - low) + low;
		setX(x);
		setY(y);

		if (getX() - getRadio() == 0 || getX() + getRadio() == panel.getWidth() || getY() - getRadio() == 0 || getY() + getRadio() == panel.getHeight()) {
			getTimer().stop();
		} else {
		}

		panel.repaint();

	}

	
	
	public Timer getTimer() {
		return reloj;
	}

	public void setTimer(Timer reloj) {
		this.reloj = reloj;
	}

	/**
	 * Method that returns the PI number-
	 * @return PI as double
	 */
	public static double getPi() {
		return PI;
	}


	/**
	 * Method that returns the horizontal coordinate of the circle.
	 * 
	 * @return x as Integer
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * Method that sets a new horizontal coordinate to the circle.
	 * 
	 * @param x
	 *            New horizontal coordinate of the circle
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	/**
	 * Method that returns the vertical coordinate of the circle.
	 * 
	 * @return y as Integer
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * Method that sets a new vertical coordinate to the circle.
	 * 
	 * @param x
	 *            New vertical coordinate of the circle
	 */
	public void setY(Integer y) {
		this.y = y;
	}

	/**
	 * Method that returns the radio of the circle.
	 * 
	 * @return r as Integer
	 */
	public Integer getRadio() {
		return radio;
	}

	/**
	 * Method that sets a new radio to the circle.
	 * 
	 * @param radio
	 *            New radio of the circle
	 */
	public void setRadio(Integer r) {
		this.radio = radio;
	}

	public Bola getAuxiliaryBall() {
		return auxiliary_ball;
	}

	public void setAuxiliaryBall(Bola auxiliary_ball) {
		this.auxiliary_ball = auxiliary_ball;
	}


}
