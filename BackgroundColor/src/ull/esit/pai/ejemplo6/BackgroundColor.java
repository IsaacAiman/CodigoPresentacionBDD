/*
 * Class that represents a JFrame with a combo box that is used
 * to change the background color.
 * 
 * Subject: Programacion de aplicaciones interactivas. 
 */
package ull.esit.pai.ejemplo6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class that represents a JFrame with a combo box that is used
 * to change the background color.
 */
public class BackgroundColor extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBox;
	private JPanel backgroundPanel;
	private JPanel ComboPanel;
	private static final String[] ITEMS = {"Black", "Yellow", "Blue", "Green"};

	/**
	 * Adds to the JFrame all the components needed.
	 */
	public BackgroundColor(){
		
		setComboBox(new JComboBox<String>(ITEMS));
		setBackgroundPanel(new JPanel());
		getBackgroundPanel().setName("background");
		setComboPanel(new JPanel());
		getComboPanel().setName("combo");
		setLayout(new BorderLayout());
		
		getComboPanel().add(getComboBox());
		getBackgroundPanel().setBackground(Color.BLACK);
		add(getBackgroundPanel(), BorderLayout.CENTER);
		add(getComboPanel(), BorderLayout.SOUTH);
		
		getComboBox().addItemListener(new Oyente());
				
	}
	
	/**
	 * Inner class used as ItemListener for the comboBox.
	 */
	class Oyente implements ItemListener{

		public void itemStateChanged(ItemEvent e) {
			switch(e.getItem().toString()){
			case "Blue":
				getBackgroundPanel().setBackground(Color.BLUE);
				break;
			case "Yellow":
				getBackgroundPanel().setBackground(Color.YELLOW);
				break;
			case "Black":
				getBackgroundPanel().setBackground(Color.BLACK);
				break;
			case "Green":
				getBackgroundPanel().setBackground(Color.GREEN);
				break;
				
				
			}
			
		}
	}
	
	/**
	 * Main that executes the backgroundColor program.
	 * @param arg
	 */
	public static void main(String arg[]){
		
        JFrame frame = new BackgroundColor();
	    frame.setTitle("Change Background");
	    frame.setSize(400, 200);
	    frame.setLocationRelativeTo(null); // Center the this
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(true);
	    frame.setVisible(true);
	}

	/**
	 * @return the combobox
	 */
	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	/**
	 * @param combobox the combobox to set
	 */
	public void setComboBox(JComboBox<String> combobox) {
		this.comboBox = combobox;
	}

	/**
	 * @return the comboPanel
	 */
	public JPanel getComboPanel() {
		return ComboPanel;
	}

	/**
	 * @param comboPanel the comboPanel to set
	 */
	public void setComboPanel(JPanel comboPanel) {
		ComboPanel = comboPanel;
	}

	/**
	 * @return the backgroundPanel
	 */
	public JPanel getBackgroundPanel() {
		return backgroundPanel;
	}

	/**
	 * @param backgroundPanel the backgroundPanel to set
	 */
	public void setBackgroundPanel(JPanel backgroundPanel) {
		this.backgroundPanel = backgroundPanel;
	}


}
