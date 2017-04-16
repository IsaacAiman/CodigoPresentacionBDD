/**
 * @authors Javier Ramos Fernández and Isaac Aiman Salas
 * @date 17 April 2017
 * @subject Programación de Aplicaciones Interactivas
 * Demonstration of the Java Robot Class.
 */

package example1RobotClass;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class that represents the main program. This program uses the Robot class to simulate mouse and key events on a calculator.
 *
 */
public class RobotBasico {
	private final static Integer SPEED = 400;		//Delay after every input event of the robot.

	public static void main(String[] args) {
		FrameCalculadora frame = new FrameCalculadora();
		JFrame frame_dinamico = new JFrame();
		JButton boton = new JButton();
		JPanel panel_dinamico = new JPanel();
		ImageIcon icon;
		Robot robot_calculadora = null;
		try {
			robot_calculadora = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		frame.setSize(500,600);
		frame.setVisible(true);
		frame.setTitle("Casio");
		frame.setLocationRelativeTo(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		robot_calculadora.setAutoDelay(SPEED);
		robot_calculadora.mouseMove(frame.getX() + frame.getWidth() - frame.getWidth()/8, frame.getY() + frame.getHeight() / 2  ); //Moves the mouse to an absolute position on the screen.
		robot_calculadora.mousePress(InputEvent.BUTTON1_MASK); //Clicks the left button of the mouse.
		robot_calculadora.mouseRelease(InputEvent.BUTTON1_MASK); //Releases the left button of the mouse
		robot_calculadora.mouseMove(frame.getX() + frame.getWidth() - frame.getWidth()/8,frame.getY() + frame.getHeight() / 2 + frame.getHeight()/8);
		robot_calculadora.mousePress(InputEvent.BUTTON1_MASK);
		robot_calculadora.mouseRelease(InputEvent.BUTTON1_MASK);
		robot_calculadora.mouseMove((int) (frame.getX() + frame.getWidth() - frame.getWidth()/1.5), frame.getY() + frame.getHeight() / 2  + frame.getHeight()/8);
		robot_calculadora.mousePress(InputEvent.BUTTON1_MASK);
		robot_calculadora.mouseRelease(InputEvent.BUTTON1_MASK);
		robot_calculadora.mouseMove(frame.getX() + frame.getWidth() - frame.getWidth()/3, (int) (frame.getY() + frame.getHeight() / 2  + frame.getHeight()/2.5));
		robot_calculadora.mousePress(InputEvent.BUTTON1_MASK);
		robot_calculadora.mouseRelease(InputEvent.BUTTON1_MASK);
		BufferedImage bufferedImage = robot_calculadora.createScreenCapture( new Rectangle(frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight())); //Creates a screen capture.
		icon = new ImageIcon(bufferedImage);
		boton.setIcon(icon);
		panel_dinamico.add(boton);
		frame_dinamico.add(panel_dinamico);
		frame_dinamico.setVisible(true);
		frame_dinamico.pack();	
	}
}
