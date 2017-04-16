/*
 * Class that tests if the controllers of the <code>BolaMovil</code> program
 * work as they should.
 * 
 * Subject: Programción de aplicaciones interactivas.
 */
package ull.esit.tercero.pai;

import static org.assertj.core.api.Assertions.assertThat;
import java.awt.Dimension;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

/**
 * Class that tests if the controllers of the <code>BolaMovil</code> program
 * work as they should.
 */
public class BolaMovilTest extends AssertJSwingJUnitTestCase {
	
	private final static int GAP = 10;
	private FrameFixture window;
	private BolaMovilController program;

	/**
	 * Creates a new instance of <code>BolaMovilController</code> and saves in 
	 * <code>window</code> the program's frame.
	 */
	@Override
	protected void onSetUp() {
		program = GuiActionRunner.execute(() -> new BolaMovilController(
				new BolaMovilPanel(), new BolaMovilControles(), new Integer(GAP)));
	    window = new FrameFixture(robot(), program);
	    window.show();	
	}
	
	@Test
	/**
	 * Tests that the ball moves up when up button is pressed.
	 * @throws InterruptedException
	 */
	public void testUp() throws InterruptedException {
		window.resizeTo(new Dimension(300,300));
		int y = program.getBolaMovilPanel().getBola().getPosY();
		window.panel("mainPanel").button("up").click();
		assertThat(program.getBolaMovilPanel().getBola().getPosY()).isLessThan(y);
	}
	
	@Test
	/**
	 * Tests that the ball moves down when down button is pressed.
	 * @throws InterruptedException
	 */
	public void testDown() throws InterruptedException {
		window.resizeTo(new Dimension(300,300));
		int y = program.getBolaMovilPanel().getBola().getPosY();
		window.panel("mainPanel").button("down").click();
		assertThat(program.getBolaMovilPanel().getBola().getPosY()).isGreaterThan(y);
	}
	
	@Test
	/**
	 * Tests that the ball moves left when left button is pressed.
	 * @throws InterruptedException
	 */
	public void testLeft() throws InterruptedException {
		window.resizeTo(new Dimension(300,300));
		int x = program.getBolaMovilPanel().getBola().getPosX();
		window.panel("mainPanel").button("left").click();
		assertThat(program.getBolaMovilPanel().getBola().getPosX()).isLessThan(x);
	}

	@Test
	/**
	 * Tests that the ball moves right when right button is pressed.
	 * @throws InterruptedException
	 */
	public void testRight() throws InterruptedException {
		window.resizeTo(new Dimension(300,300));
		int x = program.getBolaMovilPanel().getBola().getPosX();
		window.panel("mainPanel").button("right").click();
		assertThat(program.getBolaMovilPanel().getBola().getPosX()).isGreaterThan(x);
	}


}
