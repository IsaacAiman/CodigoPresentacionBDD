/*
 * Class that contains all the tests of the Copy class
 * Subject: Programación de aplicaciones interactivas
 */
package ull.esit.pai.ejemplo1;


import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;

import org.junit.Test;

import org.junit.After;
import org.junit.Before;

/**
 * Class that contains all the tests of the Copy class
 * Subject: Programación de aplicaciones interactivas
 */
public class CopyTest {
  private FrameFixture window;
 
  /**
  * Creates a new instance of <code>Copy</code> and saves in the
  * <code>window</code> attribute the program's frame.
  */
  @Before
  public void setUp() {
	Copy frame = GuiActionRunner.execute(() -> new Copy());
	window = new FrameFixture(frame);
    window.show(); // shows the frame to test
  }

  /**
   * Tests if the text entered in the text field is copied under the button when 
   * it is clicked.
   * @throws InterruptedException
   */
  @Test
  public void shouldCopyTextInLabelWhenClickingButton() throws InterruptedException {
    window.textBox().enterText("Esto es una prueba");
    window.button().click();
    window.label().requireText("Esto es una prueba");
  }

  /**
  * Closes the window after each test.
  */
  @After
  public void tearDown() {
    window.cleanUp();
  }
}
