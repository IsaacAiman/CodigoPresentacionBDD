/*
 * JPanel with a text field, a button and a label in which all the text 
 * entered in the text field will be copied when the button is clicked.
 * 
 * Subject: Programación de aplicaciones interactivas.
 */
package ull.esit.pai.ejemplo2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * JPanel with a text field, a button and a label in which all the text 
 * entered in the text field will be copied when the button is clicked.
 */
public class Copy extends JPanel {
  private static final long serialVersionUID = 1L;
  
  private JTextField textField;
  private JButton button;
  private JLabel label;

  /**
   * Default constructor. Add all the needed elements to the panel.
   */
  public Copy() {

	setTextField(new JTextField());
	getTextField().setName("Entrada de texto");;
	setButton(new JButton("Copiar texto"));
	getButton().setName("Botón copiar");
	setLabel(new JLabel());
	getLabel().setName("Texto copiado");
	   
	setLayout(new GridLayout(3,1));
	add(getTextField());
	add(getButton());
	add(getLabel());
	getButton().addActionListener(new Oyente());

  }
  
  /**
   * Inner class that listens to the events of the button "Copiar texto".
   */
	class Oyente implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Copiar texto"){		
				getLabel().setText(getTextField().getText());
			}
		}
	}

	/**
	 * @return the textField
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * @param textField the textField to set
	 */
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	/**
	 * @return the button
	 */
	public JButton getButton() {
		return button;
	}

	/**
	 * @param button the button to set
	 */
	public void setButton(JButton button) {
		this.button = button;
	}

	/**
	 * @return the label
	 */
	public JLabel getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(JLabel label) {
		this.label = label;
	}


 
}
