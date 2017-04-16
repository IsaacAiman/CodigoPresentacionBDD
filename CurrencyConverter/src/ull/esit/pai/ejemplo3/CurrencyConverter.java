/*
 * Clase que almancena dos monedas y realiza la conversión de una a otra.
 * Programación de Aplicaciones Interactivas
 */
package ull.esit.pai.ejemplo3;
/**
 * Clase que almancena dos monedas y realiza la conversión de una a otra.
 */
public class CurrencyConverter {

	private double currency1;
	private double currency2;
	
	/**
	 * Default constructor. Initializes the two currencies to 0.0.
	 */
	public CurrencyConverter(){
		
		setCurrency1(0.0);
		setCurrency2(0.0);
		
	}
	
	/**
	 * Constructor that initializes the two currencies with the given values.
	 */
	public CurrencyConverter(double value1, double value2){

		setCurrency1(value1);
		setCurrency2(value2);
		
	}
	
	/**
	 * Converts the currency1 to the currency2
	 */
	
	public double convert(double value){
		
		return ((value * currency2)/currency1);
	}
	
	/**
	 * @return the moneda1
	 */
	public double getCurrency1() {
		return currency1;
	}
	/**
	 * @param moneda1 the moneda1 to set
	 */
	public void setCurrency1(double moneda1) {
		this.currency1 = moneda1;
	}
	/**
	 * @return the moneda2
	 */
	public double getCurrency2() {
		return currency2;
	}
	/**
	 * @param moneda2 the moneda2 to set
	 */
	public void setCurrency2(double moneda2) {
		this.currency2 = moneda2;
	}
	
}
