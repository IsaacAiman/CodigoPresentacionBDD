/*
 * Clase que representa el controlador del juego de la bola móvil.
 * Asignatura: Programación de aplicaciones interactivas.
 */
package ull.esit.tercero.pai;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * Clase que representa el controlador del programa de la bola móvil.
 */
public class BolaMovilController extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private BolaMovilPanel bolaMovilPanel;
	private BolaMovilControles bolaMovilControles;
	private int jumpGap;
	
	/**
	 * @return the jumpGap
	 */
	public int getJumpGap() {
		return jumpGap;
	}


	/**
	 * @param jumpGap the jumpGap to set
	 */
	public void setJumpGap(int jumpGap) {
		this.jumpGap = jumpGap;
	}


	/**
	 * Constructor por defecto.
	 * @param bolaMovilPanel panel de la bola.
	 * @param bolaMovilControles panel con los controles.
	 * @param jumpGap numero de pixeles que se desplaza la bola con cada movimiento.
	 */
	public BolaMovilController(BolaMovilPanel bolaMovilPanel, BolaMovilControles bolaMovilControles, int jumpGap){
		setBolaMovilPanel(bolaMovilPanel);
		setBolaMovilControles(bolaMovilControles);
		setLayout(new BorderLayout());
		setJumpGap(jumpGap);
		getBolaMovilPanel().setName("bolaPanel");
		add(getBolaMovilPanel(), BorderLayout.CENTER);
		add(getBolaMovilControles(), BorderLayout.SOUTH);
		start();
	}
	
	/**
	 * Crea un frame en el que se situarán el panel de la bola y el de los controles.
	 */
	public void start (){
		BolaMovilController frame = this;
	    frame.setTitle("Bola móvil");
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500, 500);
	    frame.setVisible(true);
	    frame.setResizable(true);
	    
	    getBolaMovilControles().getDown().addActionListener(new Oyente());
	    getBolaMovilControles().getUp().addActionListener(new Oyente());
	    getBolaMovilControles().getLeft().addActionListener(new Oyente());
	    getBolaMovilControles().getRight().addActionListener(new Oyente());
	}
	
	/**
	 * Clase interna encarga de manejar los eventos que se producen al pulsar sobre 
	 * los controles (botones de arriba, abajo, izquierda y derecha).
	 * @author Isaac Aiman
	 */
	class Oyente implements ActionListener{

		/**
		 * Detecta los eventos que se producen sobre los controles y se encarga de 
		 * desplazar la bola hacia arriba, abajo, izquierda o derecha, dependiendo
		 * del botón pulsado.
		 */
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()){
			case "Abajo":
				getBolaMovilPanel().down(getJumpGap());
				break;
			case "Arriba":
				getBolaMovilPanel().up(getJumpGap());
				break;
			case "Izquierda":
				getBolaMovilPanel().left(getJumpGap());
				break;
			case "Derecha":
				getBolaMovilPanel().right(getJumpGap());
				break;
				
			}
		}
	}
	/**
	 * @return the bolaMovilPanel
	 */
	public BolaMovilPanel getBolaMovilPanel() {
		return bolaMovilPanel;
	}

	/**
	 * @param bolaMovilPanel the bolaMovilPanel to set
	 */
	public void setBolaMovilPanel(BolaMovilPanel bolaMovilPanel) {
		this.bolaMovilPanel = bolaMovilPanel;
	}

	/**
	 * @return the bolaMovilControles
	 */
	public BolaMovilControles getBolaMovilControles() {
		return bolaMovilControles;
	}

	/**
	 * @param bolaMovilControles the bolaMovilControles to set
	 */
	public void setBolaMovilControles(BolaMovilControles bolaMovilControles) {
		this.bolaMovilControles = bolaMovilControles;
	}

}
