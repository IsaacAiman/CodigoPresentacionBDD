/*
 * Class that implements all the tests of the CurrencyConverter program.
 * Subject: Programación de aplicaciones interactivas. 
 */
package ull.esit.pai.ejemplo3;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

/**
 * Class that implements all the tests of the CurrencyConverter program.
 */
public class CurrencyConverterTest extends AssertJSwingJUnitTestCase {
	private FrameFixture window;
	public static final Double YENESAEUROS = 120.78;
	public static final Double EUROS = 2.0;
	

	/**
	* Creates a new instance of <code>CurrencyConverterController</code> and saves in the
	* <code>window</code> attribute the program's frame.
	*/
	@Override
	protected void onSetUp() {
		
		CurrencyConverterController program = GuiActionRunner.execute(() -> new CurrencyConverterController(
				new CurrencyConverterModel(), new CurrencyConverterVista()));
	    window = new FrameFixture(robot(), program.getVista());
	    window.show();
		
	}
	
	@Test
	/**
	 * Tests if the currency converter works as it should when a new value is 
	 * entered and the button is clicked.
	 */
	public void shouldCalculateEurosToYens() {
		
		window.panel("Main panel").textBox().enterText("2");
		window.panel("Main panel").button().click();
		window.panel("Panel yenes").textBox("Relación yenes euros").requireText(YENESAEUROS.toString());
		window.panel("Panel yenes").textBox("Euros").enterText(EUROS.toString());
		Double valor = EUROS*YENESAEUROS;
		window.panel("Panel yenes").textBox("Yenes").enterText(valor.toString());
	}

}
