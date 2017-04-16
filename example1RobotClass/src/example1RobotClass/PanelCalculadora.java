/**
 * @authors Javier Ramos Fernández and Isaac Aiman Salas
 * @date 17 April 2017
 * @subject Programación de Aplicaciones Interactivas
 * Demonstration of the Java Robot Class.
 */

package example1RobotClass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 * Class that represents the calculator.
 *
 */
public class PanelCalculadora extends JPanel{
	private JTextField resultado;		//Result of an operation.
	private PanelTeclas teclas;			//Keys of the calculator.

	public PanelCalculadora() {
		setLayout(new BorderLayout());
		resultado = new JTextField();
		resultado.setEditable(false);
		resultado.setBackground(Color.cyan);
		teclas = new PanelTeclas(this);
		add(resultado, BorderLayout.NORTH);
		add(teclas);
	}

	/**
	 * Method that returns the result of an operation.
	 * @return resultado as JTextField
	 */
	public JTextField getResultado() {
		return resultado;
	}

	/**
	 * Method that sets a new result to the operation.
	 * @param resultado New result of the operation.
	 */
	public void setResultado(JTextField resultado) {
		this.resultado = resultado;
	}
}
