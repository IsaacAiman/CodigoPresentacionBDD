/*
 * Vista del CurrencyConverter
 * Programación de Aplicaciones Interactivas
 */
package ull.esit.pai.ejemplo3;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Clase que representa la vista del conversor de divisas.
 */
public class CurrencyConverterVista extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel;
	private JTextField cantidad;
	private JButton calcular;
	private CurrencyBox yenes;
	
	/**
	 * Constructor por defecto que crea una gui para el conversor de divisas.
	 */
	public CurrencyConverterVista(){
		
		setYenes(new CurrencyBox("Yenes"));
		getYenes().getCurrencyPanel().setName("Panel yenes");
		setMainPanel(new JPanel());
		getMainPanel().setName("Main panel");
		setCantidad(new JTextField());
		setCalcular(new JButton("Calcular"));
		getMainPanel().setLayout(new GridLayout(1,2));
		
		getYenes().getText1().setName("Relación yenes euros");
		getYenes().getText2().setName("Euros");
		getYenes().getText3().setName("Yenes");
		
		getMainPanel().add(getCantidad(), BorderLayout.EAST);
		getMainPanel().add(getCalcular(), BorderLayout.WEST);
		
		add(getYenes().getCurrencyPanel(), BorderLayout.NORTH);
		add(getMainPanel());
		
		
	}
	

	
	/**
	 * Comienza la ejecución de la vista.
	 */
	public void start(){
	
	    this.setTitle("Currency Converter");
	    this.setSize(400, 200);
	    this.setLocationRelativeTo(null); // Center the this
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(true);
	    this.setVisible(true);
	}
	
	/**
	 * Actualiza los valores de la relación euros-moneda de la GUI.
	 * @param value
	 */
	public void update(double value){
		
		getYenes().update(14.1, 89.8);
		
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


	/**
	 * @return the yenes
	 */
	public CurrencyBox getYenes() {
		return yenes;
	}

	/**
	 * @param yenes the yenes to set
	 */
	public void setYenes(CurrencyBox yenes) {
		this.yenes = yenes;
	}

	public JTextField getCantidad() {
		return cantidad;
	}

	public void setCantidad(JTextField cantidad) {
		this.cantidad = cantidad;
	}

	public JButton getCalcular() {
		return calcular;
	}

	public void setCalcular(JButton calcular) {
		this.calcular = calcular;
	}
    
}
