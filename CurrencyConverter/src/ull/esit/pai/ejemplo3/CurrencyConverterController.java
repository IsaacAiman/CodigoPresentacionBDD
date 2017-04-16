/*
 * Controlador del CurrencyConverter
 * Programación de Aplicaciones Interactivas
 */
package ull.esit.pai.ejemplo3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador del CurrencyConverter
 */
public class CurrencyConverterController {

	CurrencyConverterModel model;
	CurrencyConverterVista vista;
	
	/**
	 * Constructor por defecto.
	 * @param model modelo del conversor de monedas.
	 * @param vista vista del conversor de monedas.
	 */
	CurrencyConverterController(CurrencyConverterModel model, CurrencyConverterVista vista){
		
		setVista(vista);
		setModel(model);
		start();
	}
	
	/**
	 * Comienza la ejecución del controlador del conversor de divisas.
	 */
	public void start(){
		
	    getVista().start();

	    getVista().getYenes().getText1().setText(String.valueOf(getModel().getYenes().getCurrency2()));
	    getVista().getCalcular().addActionListener(new Oyente());

	}
	
	class Oyente implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if (e.getActionCommand() == "Calcular"){			
				double value = new Double(getVista().getCantidad().getText());
				getVista().getYenes().update(value, getModel().getYenes().convert(value));
			}
		}
	}

	/**
	 * @return the model
	 */
	public CurrencyConverterModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(CurrencyConverterModel model) {
		this.model = model;
	}

	/**
	 * @return the vista
	 */
	public CurrencyConverterVista getVista() {
		return vista;
	}

	/**
	 * @param vista the vista to set
	 */
	public void setVista(CurrencyConverterVista vista) {
		this.vista = vista;
	}
}
