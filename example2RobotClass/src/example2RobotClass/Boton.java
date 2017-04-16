/**
 * @authors Javier Ramos Fernández and Isaac Aiman Salas
 * @date 17 April 2017
 * @subject Programación de Aplicaciones Interactivas
 * Demonstration of the Java Robot Class.
 */

package example2RobotClass;

import javax.swing.JButton;

/**
 * Abstract class that represents a button.
 *
 */
abstract class Boton extends JButton {
	String texto;
	
	public Boton(String texto) {
		super(texto);
		this.texto = texto;
		
	}

	/**
	 * Method that returns the text of the button.
	 * @return texto as String
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * Method that sets a new text to the button.
	 * @param texto New text
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

}
