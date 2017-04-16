/**
 * @authors Javier Ramos Fernández and Isaac Aiman Salas
 * @date 17 April 2017
 * @subject Programación de Aplicaciones Interactivas
 * Demonstration of the Java Robot Class.
 */

package example2RobotClass;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * Class that represents the main program.
 *
 */
public class BolaMovil {

	public static void main(String[] args) {
		BolaJavaFrame frame = new BolaJavaFrame(new Integer(args[0]));
		RobotBola bola_robot;
		boolean aleatorio = new Boolean(args[1]);
		frame.setSize(500, 600);
		frame.setVisible(true);
		frame.setTitle("Move a Ball");
		frame.setLocationRelativeTo(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		if (aleatorio) {
			frame.moverAleatorio();
		} else {
		
			bola_robot = new RobotBola(frame);
		}
		
		
		
		
	}

}
