/**
 * @authors Javier Ramos Fernández and Isaac Aiman Salas
 * @date 17 April 2017
 * @subject Programación de Aplicaciones Interactivas
 * Demonstration of the Java Robot Class.
 */

package example2RobotClass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class that represents the main panel.
 *
 */
public class PanelPrincipal extends JPanel {
	private static final Integer NUMERO_BOLAS = 1;	/** Number of balls **/
	private PanelSuperior panel_superior;	/** Upper panel **/
	private PanelInferior panel_inferior;	/** Lower panel **/

	public PanelPrincipal(Integer movimiento_pixeles) {
		setLayout(new BorderLayout());
		panel_superior = new PanelSuperior(movimiento_pixeles, NUMERO_BOLAS);
		panel_inferior = new PanelInferior(panel_superior, NUMERO_BOLAS);
		add(panel_superior, BorderLayout.CENTER);
		add(panel_inferior, BorderLayout.SOUTH);
		panel_superior.inicializarPosicion();
	}

	/**
	 * Method that returns the upper panel.
	 * @return panel_superior as PanelSuperior
	 */
	public PanelSuperior getPanelSuperior() {
		return panel_superior;
	}

	/**
	 * Method that sets a new upper panel.s
	 * @param panel_superior
	 */
	public void setPanelSuperior(PanelSuperior panel_superior) {
		this.panel_superior = panel_superior;
	}

	/**
	 * Method that returns the lower panel.
	 * @return panel_inferior as PanelInferior
	 */
	public PanelInferior getPanelInferior() {
		return panel_inferior;
	}

	/**
	 * Method that sets a new lower panel.
	 * @param panel_inferior
	 */
	public void setPanelInferior(PanelInferior panel_inferior) {
		this.panel_inferior = panel_inferior;
	}

}
