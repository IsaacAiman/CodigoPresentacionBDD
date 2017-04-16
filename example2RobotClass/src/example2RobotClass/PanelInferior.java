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
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class that represents the lower panel.
 *
 */
public class PanelInferior extends JPanel {
	
	private ArrayList<JPanel> controles;		    /** Controls of all balls **/
	private ArrayList<BotonArriba> bottom_up_;      /** Up buttons **/
	private ArrayList<BotonAbajo> bottom_down_;     /** Down buttons **/
	private ArrayList<BotonIzquierda> bottom_left_; /** Left buttons **/
	private ArrayList<BotonDerecha> bottom_right_;  /** Up buttons **/
	private ArrayList<BotonNoroeste> bottom_no_;    /** North-west buttons **/
	private ArrayList<BotonNoreste> bottom_ne_; 	/** North-east buttons **/
	private ArrayList<BotonSuroeste> bottom_so_; 	/** South-west buttons **/
	private ArrayList<BotonSureste> bottom_se_; 	/** South-east buttons **/
 
	public PanelInferior(PanelSuperior panel_superior, Integer numero_bolas) {
		setLayout(new GridLayout(2, 1, 1 ,1));
		controles = new ArrayList<JPanel>();
		bottom_up_ = new ArrayList<BotonArriba>();
		bottom_down_ = new ArrayList<BotonAbajo>();
		bottom_left_ = new ArrayList<BotonIzquierda>();
		bottom_right_ = new ArrayList<BotonDerecha>();
		bottom_no_ = new ArrayList<BotonNoroeste>();
		bottom_ne_ = new ArrayList<BotonNoreste>();
		bottom_so_ = new ArrayList<BotonSuroeste>();
		bottom_se_ = new ArrayList<BotonSureste>();

		Integer i = 0;
		for (i = 0; i < numero_bolas; i++) {					//Constructs a number of balls and their controls
			crearPanelControl(i, panel_superior);
			
		}

	}

	
	public void crearPanelControl(Integer i, PanelSuperior panel_superior) {
		JPanel panel_control;
		BotonArriba bottom_up;
		BotonAbajo bottom_down;
		BotonIzquierda bottom_left;
		BotonDerecha bottom_right;
		BotonNoroeste bottom_no;
		BotonNoreste bottom_ne;
		BotonSuroeste bottom_so;
		BotonSureste bottom_se;
		final Integer inner_i = new Integer(i);
		panel_control = new JPanel(new BorderLayout());
		JPanel panel_auxiliar = new JPanel();
		bottom_up = new BotonArriba("Up");
		bottom_down = new BotonAbajo("Down");
		bottom_left = new BotonIzquierda("Left");
		bottom_right = new BotonDerecha("Right");
		bottom_no = new BotonNoroeste("NO");
		bottom_ne = new BotonNoreste("NE");
		bottom_so = new BotonSuroeste("SO");
		bottom_se = new BotonSureste("SE");
		bottom_up.setPreferredSize(new Dimension(90, 35));
		bottom_down.setPreferredSize(new Dimension(90, 35));
		bottom_left.setPreferredSize(new Dimension(90, 35));
		bottom_right.setPreferredSize(new Dimension(90, 35));
		if (i == 0) {
			addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_W:
						panel_superior.getElementos().get(inner_i).moverArriba(panel_superior);
						break;
					case KeyEvent.VK_S:
						panel_superior.getElementos().get(inner_i).moverAbajo(panel_superior);
						break;
					case KeyEvent.VK_A:
						panel_superior.getElementos().get(inner_i).moverIzquierda(panel_superior);
						break;
					case KeyEvent.VK_D:
						panel_superior.getElementos().get(inner_i).moverDerecha(panel_superior);
						break;
					case KeyEvent.VK_Q:
						panel_superior.getElementos().get(inner_i).moverNoroeste(panel_superior);
						break;
					case KeyEvent.VK_E:
						panel_superior.getElementos().get(inner_i).moverNoreste(panel_superior);
						break;
					case KeyEvent.VK_Z:
						panel_superior.getElementos().get(inner_i).moverSuroeste(panel_superior);
						break;
					case KeyEvent.VK_C:
						panel_superior.getElementos().get(inner_i).moverSureste(panel_superior);
						break;

					}
				}
			});
			
			
			bottom_up.setMnemonic(new Integer(KeyEvent.VK_W));
			bottom_down.setMnemonic(new Integer(KeyEvent.VK_S));
			bottom_left.setMnemonic(KeyEvent.VK_A);
			bottom_right.setMnemonic(KeyEvent.VK_D);
			bottom_no.setMnemonic(new Integer(KeyEvent.VK_Q));
			bottom_ne.setMnemonic(new Integer(KeyEvent.VK_E));
			bottom_so.setMnemonic(KeyEvent.VK_Z);
			bottom_se.setMnemonic(KeyEvent.VK_C);
			setFocusable(true);
		} 
			

		bottom_no.setPreferredSize(new Dimension(90, 35));
		bottom_ne.setPreferredSize(new Dimension(90, 35));
		bottom_so.setPreferredSize(new Dimension(90, 35));
		bottom_se.setPreferredSize(new Dimension(90, 35));
		panel_auxiliar.add(bottom_no);
		panel_auxiliar.add(bottom_up);
		panel_auxiliar.add(bottom_ne);
		panel_control.add(panel_auxiliar, BorderLayout.NORTH);
		panel_auxiliar = new JPanel();
		panel_auxiliar.add(bottom_so);
		panel_auxiliar.add(bottom_down);
		panel_auxiliar.add(bottom_se);
		panel_control.add(panel_auxiliar, BorderLayout.SOUTH);
		panel_auxiliar = new JPanel();
		panel_auxiliar.add(bottom_left);
		panel_auxiliar.add(bottom_right);
		panel_control.add(panel_auxiliar, BorderLayout.CENTER);
		add(panel_control);
		bottom_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_superior.getElementos().get(inner_i).moverArriba(panel_superior);

			}
		});

		bottom_down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_superior.getElementos().get(inner_i).moverAbajo(panel_superior);

			}
		});

		bottom_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_superior.getElementos().get(inner_i).moverIzquierda(panel_superior);

			}
		});

		bottom_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_superior.getElementos().get(inner_i).moverDerecha(panel_superior);

			}
		});

		bottom_no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_superior.getElementos().get(inner_i).moverNoroeste(panel_superior);

			}
		});

		bottom_ne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_superior.getElementos().get(inner_i).moverNoreste(panel_superior);

			}
		});

		bottom_so.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_superior.getElementos().get(inner_i).moverSuroeste(panel_superior);

			}
		});

		bottom_se.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_superior.getElementos().get(inner_i).moverSureste(panel_superior);

			}
		});

		getBottomUp().add(bottom_up);
		getBottomDown().add(bottom_down);
		getBottomLeft().add(bottom_left);
		getBottomRight().add(bottom_right);
		getBottomNo().add(bottom_no);
		getBottomNe().add(bottom_ne);
		getBottomSo().add(bottom_so);
		getBottomSe().add(bottom_se);
		getControles().add(new JPanel(new BorderLayout()));

	}
	
	public void moverAleatorio(PanelSuperior panel_superior) {
		for (int i = 0; i < panel_superior.getElementos().size(); i++) {
			panel_superior.getElementos().get(i).getTimer().start();
		}

}

	/**
	 * Method that returns the controls of the balls.
	 * @return controles
	 */
	public ArrayList<JPanel> getControles() {
		return controles;
	}

	/**
	 * Method that sets a new collection of controls
	 * @param controles
	 */
	public void setControles(ArrayList<JPanel> controles) {
		this.controles = controles;
	}

	/**
	 * Method that returns the Down buttons.
	 * @return bottom_up_
	 */
	public ArrayList<BotonArriba> getBottomUp() {
		return bottom_up_;
	}

	/**
	 * Method that sets a new collection of Up buttons.
	 * @param bottom_up_
	 */
	public void setBottomUp_(ArrayList<BotonArriba> bottom_up_) {
		this.bottom_up_ = bottom_up_;
	}

	/**
	 * Method that returns the Down buttons.
	 * @return bottom_down_
	 */
	public ArrayList<BotonAbajo> getBottomDown() {
		return bottom_down_;
	}

	/**
	 * Method that sets a new collection of Down buttons.
	 * @param bottom_down_
	 */
	public void setBottomDown_(ArrayList<BotonAbajo> bottom_down_) {
		this.bottom_down_ = bottom_down_;
	}
	
	/**
	 * Method that return the Left buttons.
	 * @return bottom_left
	 */
	public ArrayList<BotonIzquierda> getBottomLeft() {
		return bottom_left_;
	}

	/**
	 * Method that sets a new collection of Left buttons.
	 * @param bottom_left_
	 */
	public void setBottomLeft(ArrayList<BotonIzquierda> bottom_left_) {
		this.bottom_left_ = bottom_left_;
	}

	/**
	 * Method that returns the Right buttons.
	 * @return
	 */
	public ArrayList<BotonDerecha> getBottomRight() {
		return bottom_right_;
	}
	

	


	public ArrayList<BotonNoreste> getBottomNe() {
		return bottom_ne_;
	}





	public void setBottomNe(ArrayList<BotonNoreste> bottom_ne_) {
		this.bottom_ne_ = bottom_ne_;
	}





	public ArrayList<BotonSuroeste> getBottomSo() {
		return bottom_so_;
	}





	public void setBottomSo(ArrayList<BotonSuroeste> bottom_so_) {
		this.bottom_so_ = bottom_so_;
	}





	public ArrayList<BotonSureste> getBottomSe() {
		return bottom_se_;
	}





	public void setBottomNo(ArrayList<BotonNoroeste> bottom_no_) {
		this.bottom_no_ = bottom_no_;
	}





	public void setBottomSe(ArrayList<BotonSureste> bottom_se_) {
		this.bottom_se_ = bottom_se_;
	}


	/**
	 * Method sets a new collection of Right buttons.
	 * @param bottom_right_
	 */
	public void setBottomRight(ArrayList<BotonDerecha> bottom_right_) {
		this.bottom_right_ = bottom_right_;
	}

	public ArrayList<BotonNoroeste> getBottomNo() {
		return bottom_no_;
	}

}
