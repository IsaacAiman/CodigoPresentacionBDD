/*
 * Modelo del CurrencyConverter
 * Programación de Aplicaciones Interactivas
 */
package ull.esit.pai.ejemplo3;
/**
 * Modelo del conversor de divisas.
 */
public class CurrencyConverterModel {

	
	private CurrencyConverter yenes;

	
	/**
	 * Constructor por defecto que establace las relaciones entre euros y el resto de 
	 * monedas.
	 */
	public CurrencyConverterModel(){

		setYenes(new CurrencyConverter(1,120.78)); 

		
	}

	/**
	 * @return the yenes
	 */
	public CurrencyConverter getYenes() {
		return yenes;
	}


	/**
	 * @param yenes the yenes to set
	 */
	public void setYenes(CurrencyConverter yenes) {
		this.yenes = yenes;
	}

}
