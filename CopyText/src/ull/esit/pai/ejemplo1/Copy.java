/*
 * JFrame with a text field, a button and a label in which all the text 
 * entered in the text field will be copied when the button is clicked.
 * 
 * Subject: Programación de aplicaciones interactivas.
 */
package ull.esit.pai.ejemplo1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 * JFrame with a text field, a button and a label in which all the text 
 * entered in the text field will be copied when the button is clicked.
 */
public class Copy extends JFrame {
  private static final long serialVersionUID = 1L;
  
  private JTextField textField;
  private JButton button;
  private JLabel label;

  /**
   * Default constructor. Add all the needed elements to the frame.
   */
  public Copy() {

	setTextField(new JTextField());
	getTextField().setName("Entrada de texto");;
	setButton(new JButton("Copiar texto"));
	getButton().setName("Botón copiar");
	setLabel(new JLabel());
	getLabel().setName("Texto copiado");
	   
	setLayout(new GridLayout(3,1));
	getRootPane().setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
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
	 * Main that executes an instance of <code>Copy</code>.
	 * @param args
	 * @throws InvocationTargetException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
	
		JFrame frame = new Copy();
		frame.setTitle("Copy");
		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null); // Center the this
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);
	
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

