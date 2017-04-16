/**
 * @authors Javier Ramos Fernández and Isaac Aiman Salas
 * @date 17 April 2017
 * @subject Programación de Aplicaciones Interactivas
 * Demonstration of the Java Robot Class.
 */

package example2RobotClass;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class that represents the frame of the program.
 *
 */
public class BolaJavaFrame extends JFrame{
	private PanelPrincipal panel_principal;	/** Main panel **/
	
	public BolaJavaFrame(Integer movimiento_pixeles) {
		panel_principal = new PanelPrincipal(movimiento_pixeles);
		add(panel_principal);
		
	}
	
	/**
	 * Method that returns the main panel.
	 * @return panel_principal as PanelPrincipal
	 */
	public PanelPrincipal getPanelPrincipal() {
		return panel_principal;
	}
	
	/**
	 * Method that sets a new main panel.
	 * @param panel_principal New main panel
	 */
	public void setPanelPrincipal(PanelPrincipal panel_principal) {
		this.panel_principal = panel_principal;
	}
	
	/**
	 * Method that initializes the balls' position.
	 */
	public void inicializarPosicionBola() {
		panel_principal.getPanelSuperior().inicializarPosicion();
		
	}
	
	public void moverAleatorio() {
		panel_principal.getPanelInferior().moverAleatorio(panel_principal.getPanelSuperior());
	}

}
