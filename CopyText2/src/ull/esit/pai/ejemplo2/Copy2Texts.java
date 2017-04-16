/*
 * Class that creates a simple Gui with two panels. Both panels work in the 
 * same way, the user can enter a text and when the button "Copiar" is clicked,
 * the text will appear under it.
 * 
 * Subject: Programación de aplicaciones interactivas.
 */
package ull.esit.pai.ejemplo2;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

/**
 * Class that creates a simple Gui with two panels. Both panels work in the 
 * same way, the user can enter a text and when the button "Copiar" is clicked,
 * the text will appear under it.
 */
public class Copy2Texts extends JFrame{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor that adds to the JFrame two panels,
	 * an upper Copy panel and a lower Copy panel.
	 */
	public Copy2Texts(){
		Copy copy1 = new Copy();
		copy1.setName("Panel1");
		Copy copy2 = new Copy();
		copy2.setName("Panel2");
		this.setName("Copy2Texts");
		setLayout(new GridLayout(2,1));
		getRootPane().setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		add(copy1);
		add(copy2);
	}
	
	/**
	 * Creates a new instance of the <code>Copy2Texts</code> class
	 * and shows the program window in the screen.
	 * @param args
	 */
	public static void main(String[] args) {
	    JFrame frame = new Copy2Texts();
	    frame.setTitle("Copy2Texts");
	    frame.setSize(400, 300);
	    frame.setLocationRelativeTo(null); // Center the this
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(true);
	    frame.setVisible(true);

	}

}
