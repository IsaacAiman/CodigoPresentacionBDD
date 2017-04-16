/*
 * Class that tests if the BackgroundColor program changes the 
 * background color when an item of the comboBox is chosen.
 * 
 * Subject: Programación de aplicaciones interactivas.
 */
package ull.esit.pai.ejemplo6;

import java.awt.Color;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

/**
 * Class that tests if the BackgroundColor program changes the 
 * background color when an item of the comboBox is chosen.
 */
public class BackgroundColorTest extends AssertJSwingJUnitTestCase {
	private FrameFixture window;
	
	@Override
	/**
	* Creates a new instance of <code>BackgroundColor</code> and saves in the
	* <code>window</code> attribute the program's frame.
	*/
	protected void onSetUp() {
		BackgroundColor frame =  GuiActionRunner.execute(() -> new BackgroundColor());
	    window = new FrameFixture(robot(), frame);
	    window.show();
	}
	
	@Test
	/**
	 * Tests if the background changes to blue when the item "blue" is selected 
	 * from the comboBox.
	 */
	public void testColorBlue() {
		window.panel("combo").comboBox().selectItem("Blue");
		window.panel("background").background().requireEqualTo(Color.BLUE);
	}
	
	@Test
	/**
	 * Tests if the background changes to yellow when the item "yellow" is selected 
	 * from the comboBox.
	 */
	public void testColorYellow() {
		window.panel("combo").comboBox().selectItem("Yellow");
		window.panel("background").background().requireEqualTo(Color.YELLOW);
	}
	
	@Test
	/**
	 * Tests if the background changes to green when the item "green" is selected 
	 * from the comboBox.
	 */
	public void testColorGreen() {
		window.panel("combo").comboBox().selectItem("Green");
		window.panel("background").background().requireEqualTo(Color.GREEN);
	}
	
	@Test
	/**
	 * Tests if the background changes to black when the item "black" is selected 
	 * from the comboBox.
	 */
	public void testColorBlack() {
		window.panel("combo").comboBox().selectItem("Black");
		window.panel("background").background().requireEqualTo(Color.BLACK);
	}


}

