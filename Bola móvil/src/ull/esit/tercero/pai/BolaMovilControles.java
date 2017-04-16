/*
 * Clase que representa los controles (arriba, abajo, izquierda y derecha)
 * necesarios para poder desplazar la bola por la pantalla.
 * Asignatura: Programación de aplicaciones interactivas.
 */
package ull.esit.tercero.pai;


import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Clase que representa los controles (arriba, abajo, izquierda y derecha)
 * necesarios para poder desplazar la bola por la pantalla.
 */
public class BolaMovilControles extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JButton up;
	private JButton down;
	private JButton left;
	private JButton right;
	private JPanel upPanel;
	private JPanel downPanel;
	private JPanel midPanel;
	private JPanel mainPanel;
	
	/**
	 * Constructor por defecto que inicializa los botones de arriba, 
	 * abajo, izquierda y derecha, y los situa en un panel.
	 */
	public BolaMovilControles(){
		
		
		setUp(new JButton("Arriba"));
		getUp().setName("up");
		setDown(new JButton("Abajo"));
		getDown().setName("down");
		setLeft(new JButton("Izquierda"));
		getLeft().setName("left");
		setRight(new JButton("Derecha"));
		getRight().setName("right");
		setUpPanel(new JPanel());
		//getUpPanel().setName("upPanel");
		setDownPanel(new JPanel());
		//getDownPanel().setName("downPanel");
		setMidPanel(new JPanel());
		//getMidPanel().setName("midPanel");
		setMainPanel(new JPanel());
		getMainPanel().setName("mainPanel");
		getMainPanel().setLayout(new  GridLayout(3, 1, 0, 0));
		
		// Botón de arriba.
		getUpPanel().add(getUp());
		getMainPanel().add(getUpPanel());
		
		// Botones centrales (izquierda y derecha)
		getMidPanel().add(getLeft());
		getMidPanel().add(getRight());
		getMainPanel().add(getMidPanel());
		
		
		// Botón de abajo.
		getDownPanel().add(getDown());
		getMainPanel().add(getDownPanel());
		add(getMainPanel());
		
	}
	

	/**
	 * @return the up
	 */
	public JButton getUp() {
		return up;
	}

	/**
	 * @param up the up to set
	 */
	public void setUp(JButton up) {
		this.up = up;
	}

	/**
	 * @return the down
	 */
	public JButton getDown() {
		return down;
	}

	/**
	 * @param down the down to set
	 */
	public void setDown(JButton down) {
		this.down = down;
	}

	/**
	 * @return the left
	 */
	public JButton getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(JButton left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public JButton getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(JButton right) {
		this.right = right;
	}

	/**
	 * @return the upPanel
	 */
	public JPanel getUpPanel() {
		return upPanel;
	}

	/**
	 * @param upPanel the upPanel to set
	 */
	public void setUpPanel(JPanel upPanel) {
		this.upPanel = upPanel;
	}

	/**
	 * @return the downPanel
	 */
	public JPanel getDownPanel() {
		return downPanel;
	}

	/**
	 * @param downPanel the downPanel to set
	 */
	public void setDownPanel(JPanel downPanel) {
		this.downPanel = downPanel;
	}

	/**
	 * @return the midPanel
	 */
	public JPanel getMidPanel() {
		return midPanel;
	}

	/**
	 * @param midPanel the midPanel to set
	 */
	public void setMidPanel(JPanel midPanel) {
		this.midPanel = midPanel;
	}


	/**
	 * @return the mainPanel
	 */
	public JPanel getMainPanel() {
		return mainPanel;
	}


	/**
	 * @param mainPanel the mainPanel to set
	 */
	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
}
