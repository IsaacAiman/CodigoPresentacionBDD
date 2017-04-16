/*
 * Main de la práctica 7: CurrencyConverter
 * Programación de Aplicaciones Interactivas
 */

package ull.esit.pai.ejemplo3;
/**
 * Main que crea una vista y un modelo y ejecuta el controlador para un conversor de 
 * divisas.
 */
public class CurrencyConverterProgram {
	
	public CurrencyConverterProgram(){
		CurrencyConverterModel model = new CurrencyConverterModel();
		CurrencyConverterVista view = new CurrencyConverterVista();
		CurrencyConverterController controller= new CurrencyConverterController(model, view);
		controller.start();
	}
	
	public static void main(String args[]){
		
		new CurrencyConverterProgram();
	    
	}

	
}
