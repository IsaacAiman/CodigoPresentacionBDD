/*
 * Class that contains all the test developed for the Copy2Texts program.
 */
package ull.esit.pai.ejemplo2;

import javax.swing.JFrame;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

/**
 * Class that contains all the test developed for the Copy2Texts program.
 */
public class Copy2TextsTest extends AssertJSwingJUnitTestCase{
  private FrameFixture window;
 
  @Override
  /**
  * Creates a new instance of <code>Copy2Texts</code> and saves in the
  * <code>window</code> attribute the program's frame.
  */
  public void onSetUp() {

	JFrame frame = GuiActionRunner.execute(() -> new Copy2Texts());
	window = new FrameFixture(robot(), frame);
	window.show();
  }

  @Test
  /**
   * Tests if the program copies the entered text when the top button
   * "Copiar" is clicked.
   * @throws InterruptedException
   */
  public void writeAndCopyPanel1() throws InterruptedException {
	  
    window.panel("Panel1").textBox("Entrada de texto").enterText("hola");
    window.panel("Panel1").button("Botón copiar").click();
    window.panel("Panel1").label("Texto copiado").requireText("hola");

  }
  
  @Test
  /**
   * Tests if the program copies the entered text when the bottom button
   * "Copiar" is clicked.
   * @throws InterruptedException
   */
  public void writeAndCopyPanel2() throws InterruptedException {
	  
    window.panel("Panel2").textBox("Entrada de texto").enterText("adiós");
    window.panel("Panel2").button("Botón copiar").click();
    window.panel("Panel2").label("Texto copiado").requireText("adiós");

  }
  
  @Test
  /**
   * Tests if the text is copied in both, upper and lower, panels.
   * @throws InterruptedException
   */
  public void writeAndCopyPanel1AndPanel2() throws InterruptedException {
	
	// Panel1
	window.panel("Panel1").textBox("Entrada de texto").enterText("hola");
	window.panel("Panel1").button("Botón copiar").click();
	window.panel("Panel1").label("Texto copiado").requireText("hola");
	    
	// Panel 2
    window.panel("Panel2").textBox("Entrada de texto").enterText("adiós");
    window.panel("Panel2").button("Botón copiar").click();
    window.panel("Panel2").label("Texto copiado").requireText("adiós");

  }

}
