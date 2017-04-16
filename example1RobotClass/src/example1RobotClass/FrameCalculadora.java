/**
 * @authors Javier Ramos Fernández and Isaac Aiman Salas
 * @date 17 April 2017
 * @subject Programación de Aplicaciones Interactivas
 * Demonstration of the Java Robot Class.
 */

package example1RobotClass;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * Class that represents the frame of the calculator.
 *
 */
public class FrameCalculadora extends JFrame{
	private PanelCalculadora calculator_panel;	//Main panel
	
	public FrameCalculadora() {
		calculator_panel = new PanelCalculadora();
		add(calculator_panel);
	}
}
