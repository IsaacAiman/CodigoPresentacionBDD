/**
 * @authors Javier Ramos Fernández and Isaac Aiman Salas
 * @date 17 April 2017
 * @subject Programación de Aplicaciones Interactivas
 * Demonstration of the Java Robot Class.
 */

package example2RobotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * Class that represents the ball robot.
 * 
 *
 */
public class RobotBola {
	private static final Integer SPEED = 300; // Delay after every event
	private static final Integer MOVIMIENTOS = 4; // Number of movements in every direction
	private static final ArrayList<String> DIRECCIONES;
	private BolaJavaFrame frameBola; // Frame of the ball
	private Hashtable<String, Integer> teclas; // Keys of the keyboards
	private Robot robotBola; // Ball robot
	private Bola ball; // Ball

	static {
		DIRECCIONES = new ArrayList<String>(
				Arrays.asList("S", "NE", "SE", "N", "SO", "NO", "E", "O"));
	}
	
	public RobotBola(BolaJavaFrame frameBola) {
		this.frameBola = frameBola;
		ball = (Bola) frameBola.getPanelPrincipal().getPanelSuperior().getElementos().get(0);
		try {
			robotBola = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		System.out.println("HOLA");
		teclas = new Hashtable<String, Integer>();
		teclas.put("N", KeyEvent.VK_W);
		teclas.put("S", KeyEvent.VK_S);
		teclas.put("E", KeyEvent.VK_D);
		teclas.put("O", KeyEvent.VK_A);
		teclas.put("NO", KeyEvent.VK_Q);
		teclas.put("NE", KeyEvent.VK_E);
		teclas.put("SO", KeyEvent.VK_Z);
		teclas.put("SE", KeyEvent.VK_C);
		ejecutarMovimientosBola();

	}

	/**
	 * Private method that executes a fixed number of movements in all
	 * directions.
	 */
	private void ejecutarMovimientosBola() {
		PanelSuperior upper_panel = getFrameBola().getPanelPrincipal().getPanelSuperior();
		getRobotBola().setAutoDelay(getSpeed());
		for (int i = 0; i < getTeclas().size(); i++) {
			for (int j = 0; j < getMovimientos(); j++) {
				getRobotBola().keyPress(teclas.get(getDirecciones().get(i)));
				getRobotBola().keyRelease(teclas.get(getDirecciones().get(i)));
			}
		}
	}

	/**
	 * Method that returns the keys for moving the ball.
	 * 
	 * @return teclas as Hashtable<String, Integer>
	 */
	public Hashtable<String, Integer> getTeclas() {
		return teclas;
	}

	/**
	 * Method that sets a new set of key for moving the ball.
	 * 
	 * @param teclas
	 *            New keys for moving the ball.¡
	 */
	public void setTeclas(Hashtable<String, Integer> teclas) {
		this.teclas = teclas;
	}

	/**
	 * Method that returns the ball.
	 * 
	 * @return ball as Bola
	 */
	public Bola getBall() {
		return ball;
	}

	/**
	 * Method that sets a new ball.
	 * 
	 * @param ball
	 *            New ball
	 */
	public void setBall(Bola ball) {
		this.ball = ball;
	}

	/**
	 * Method that returns the frame where the ball moves.
	 * 
	 * @return frameBola as BolaJavaFrame
	 */
	public BolaJavaFrame getFrameBola() {
		return frameBola;
	}

	/**
	 * Method that sets a new frame where the ball moves.
	 * 
	 * @param frameBola
	 *            New frame
	 */
	public void setFrameBola(BolaJavaFrame frameBola) {
		this.frameBola = frameBola;
	}

	/**
	 * Method that returns the robot ball.
	 * 
	 * @return robotBola as Robot
	 */
	public Robot getRobotBola() {
		return robotBola;
	}

	/**
	 * Method that sets a new robot ball.
	 * 
	 * @param robotBola
	 *            New robot ball
	 */
	public void setRobotBola(Robot robotBola) {
		this.robotBola = robotBola;
	}

	/**
	 * Method that returns the delay after every robot event.
	 * 
	 * @return SPEED as Integer
	 */
	public static Integer getSpeed() {
		return SPEED;
	}

	/**
	 * Method that returns the number of movements of the ball in every
	 * direction.
	 * 
	 * @return MOVIMIENTOS as Integer
	 */
	public static Integer getMovimientos() {
		return MOVIMIENTOS;
	}

	/**
	 * Method that returns all possible directions of the ball movement.
	 * @return
	 */
	public static ArrayList<String> getDirecciones() {
		return DIRECCIONES;
	}
}
