/**
 * @authors Javier Ramos Fernández and Isaac Aiman Salas
 * @date 17 April 2017
 * @subject Programación de Aplicaciones Interactivas
 * Demonstration of the Java Robot Class.
 */

package example3RobotClass;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 * Class that represents a thread whose objective is to scroll down the text
 * written in the text editor.
 *
 */
class Hilo implements Runnable {
	private final static Integer DESPLAZAMIENTO = 9; 	// Shift of every scroll
	private static final int DELAY = 2000; 				// Delay of every event of the robot
	private static final int NUMERO_SCROLLS = 6;		// Number of scrolls
	private Robot robotEditor; 							// Robot of the text editor
	private JScrollBar scrollText; 						// Scroll bar of the text editor

	public Hilo(JScrollBar scrollText) {
		try {
			this.robotEditor = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robotEditor.setAutoDelay(getDelay());
		this.scrollText = scrollText;
	}

	/**
	 * Method that scrolls down the text.
	 */
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getScrollText().setValue(getScrollText().getMinimum());
		for (int i = 0; i < 6; i++) {
			getRobotEditor().mouseWheel(getDesplazamiento());
		}
	}


	/**
	 * Method that returns the robot of the text editor.
	 * 
	 * @return robotEditor as Robot
	 */
	public Robot getRobotEditor() {
		return robotEditor;
	}

	/**
	 * Method that sets a new robot for the text editor.
	 * 
	 * @param robotEditor
	 *            New robot
	 */
	public void setRobotEditor(Robot robotEditor) {
		this.robotEditor = robotEditor;
	}

	/**
	 * Method that returns the shift of every scroll.
	 * 
	 * @return DESPLAZAMIENTO as Integer
	 */
	public static Integer getDesplazamiento() {
		return DESPLAZAMIENTO;
	}

	/**
	 * Method that returns the scroll bar of the text editor.
	 * 
	 * @return scrollText as JScrollBar
	 */
	public JScrollBar getScrollText() {
		return scrollText;
	}

	/**
	 * Method that sets a new scroll bar for the text editor.
	 * 
	 * @param scrollText
	 *            New scroll bar
	 */
	public void setScrollText(JScrollBar scrollText) {
		this.scrollText = scrollText;
	}

	/**
	 * Method that returns the delay after every input of the robot.
	 * @return DELAY as Integer
	 */
	public static Integer getDelay() {
		return DELAY;
	}

	/**
	 * Method that return the number of scrolls.
	 * @return NUMERO_SCROLLS as Integer
	 */
	public static Integer getNumeroScrolls() {
		return NUMERO_SCROLLS;
	}
	
	
	
	

}