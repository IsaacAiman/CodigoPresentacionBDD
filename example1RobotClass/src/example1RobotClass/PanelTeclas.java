/**
 * @authors Javier Ramos Fernández and Isaac Aiman Salas
 * @date 17 April 2017
 * @subject Programación de Aplicaciones Interactivas
 * Demonstration of the Java Robot Class.
 */

package example1RobotClass;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class that represents the keyboard of the calculator.
 *
 */
public class PanelTeclas extends JPanel {

	private static final ArrayList<String> SIMBOLOS_CALCULADORA;	//Symbols of the calculator
	private static final Integer NUMERO_FILAS = 4;				 	//Number of rows of the calculator
	private static final Integer NUMERO_COLUMNAS = 4;				//Number of columns of the calculator
	private static final Integer NUMERO_DIGITOS = 10;				//Number of digits.
	private Stack<String> operandos;								//Operands 
	private ArrayList<JButton> teclas;								//Keys of the calculator.
	private PanelCalculadora panel_principal;						//Main panel

	static {
		SIMBOLOS_CALCULADORA = new ArrayList<String>(
				Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "/", "*", "=", "C"));
	}

	public PanelTeclas(PanelCalculadora panel_principal) {
		operandos = new Stack<String>();
		teclas = new ArrayList<JButton>();

		this.panel_principal = panel_principal;
		JButton tecla;
		setLayout(new GridLayout(getNumeroFilas(), getNumeroColumnas()));
		for (int i = 0; i < getSimbolosCalculadora().size(); i++) {
			tecla = new JButton(getSimboloCalculadora(i));
			tecla.addActionListener(new Oyente(i));
			teclas.add(tecla);
			add(tecla);
		}
	}

	/**
	 * Method that returns the operands of an operation.
	 * @return operandos as Stack<String> 
	 */
	public Stack<String> getOperandos() {
		return operandos;
	}

	/**
	 * Method that sets a set of operands of an operation.
	 * @param operandos New operands
	 */
	public void setOperandos(Stack<String> operandos) {
		this.operandos = operandos;
	}

	/**
	 * Method that returns the keys of the calculator.
	 * @return teclas as ArrayList<JButton>
	 */
	public ArrayList<JButton> getTeclas() {
		return teclas;
	}

	/**
	 * Method that sets a new set of keys to the calculator.
	 * @param teclas New set of keys.
	 */
	public void setTeclas(ArrayList<JButton> teclas) {
		this.teclas = teclas;
	}

	/**
	 * Method that returns the main panel.
	 * @return panel_principal as PanelCalculadora
	 */
	public PanelCalculadora getPanelPrincipal() {
		return panel_principal;
	}

	/**
	 * Method that sets a new main panel.
	 * @param panel_principal New main panel
	 */
	public void setPanelPrincipal(PanelCalculadora panel_principal) {
		this.panel_principal = panel_principal;
	}

	/**
	 * Method that get the symbols of the keys of the calculator.
	 * @return SIMBOLOS_CALCULADORA as ArrayList<String>
	 */
	public static ArrayList<String> getSimbolosCalculadora() {
		return SIMBOLOS_CALCULADORA;
	}

	/**
	 * Method that returns a specific key of the calculator.
	 * @param index Index of the key
	 * @return JButton object
	 */
	public JButton getTecla(Integer index) {
		return teclas.get(index);

	}

	/**
	 * Method that returns a specific symbol of a key of the calculator.
	 * @param index Index of the symbol
	 * @return String object
	 */
	public String getSimboloCalculadora(Integer index) {
		return SIMBOLOS_CALCULADORA.get(index);
	}

	/**
	 * Method that returns the number of rows of the keyboard of the calculator.
	 * @return NUMERO_FILAS as Integer
	 */
	public static Integer getNumeroFilas() {
		return NUMERO_FILAS;
	}

	/**
	 * Method that returns the number of columns of the keyboard of the calculator.
	 * @return NUMERO_COLUMNAS as Integer
	 */
	public static Integer getNumeroColumnas() {
		return NUMERO_COLUMNAS;
	}

	/**
	 * Method that returns the number of digits.
	 * @return NUMERO_DIGITOS as Integer
	 */
	public static Integer getNumeroDigitos() {
		return NUMERO_DIGITOS;
	}

	/**
	 * Inner class that implements the ActionListener interface for the keyboard of the calculator.s
	 *
	 */
	class Oyente implements ActionListener {

		Integer indice;

		public Oyente(Integer indice) {
			this.indice = indice;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JTextField resultado = getPanelPrincipal().getResultado();
			if (getIndice() < getNumeroDigitos()) {
					resultado.setText("" + getSimboloCalculadora(getIndice()));
					getOperandos().push(getSimboloCalculadora(getIndice()));
				

			} else if (e.getSource() == getTecla(15)) {
				getOperandos().clear();
				resultado.setText("" + 0);
			} else if (e.getSource() == getTecla(14) && getOperandos().size() == 3) {
				Integer right = new Integer(getOperandos().pop());
				String operacion = new String("" + getOperandos().pop());
				Integer left = new Integer(getOperandos().pop());
				Integer result = operacion(left, right, operacion);
				getOperandos().push("" + result);
				resultado.setText("" + result);
				
			} else {
				getOperandos().push(getSimboloCalculadora(getIndice()));
			}
		}

		/**
		 * Private method that works out an operation.
		 * @param left	Left operand
		 * @param right Right operand
		 * @param operacion Operation
		 * @return
		 */
		private Integer operacion(Integer left, Integer right, String operacion) {
			Integer resultado = 0;
			switch (operacion) {
			case "+":
				resultado = left + right;
				break;
			case "-":
				resultado = left - right;
				break;
			case "*":
				resultado = left * right;
				break;
			case "/":
				resultado = left / right;
				break;

			}
			return resultado;

		}

		/**
		 * Method of the inner class that returns the index of a specific key.
		 * @return indice as Integer
		 */
		public Integer getIndice() {
			return indice;
		}

		/**
		 * Method of the inner class that sets a new index of a specific key.
		 * @param indice New index
		 */
		public void setIndice(Integer indice) {
			this.indice = indice;
		}

	}

}
