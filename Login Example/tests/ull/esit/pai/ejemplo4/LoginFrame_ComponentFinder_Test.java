/*
 * Class that contains the tests developed for the Login program.
 * Subject: Programción de aplicaciones interactivas.
 */
package ull.esit.pai.ejemplo4;

import javax.swing.JFrame;

import org.assertj.swing.core.BasicComponentFinder;
import org.assertj.swing.core.ComponentFinder;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.finder.WindowFinder;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;
/**
 * Class that contains the tests developed for the <code>Login</code> program.
 */
public class LoginFrame_ComponentFinder_Test extends AssertJSwingJUnitTestCase{
  private FrameFixture window;

  /**
  * Creates a new instance of <code>LoginFrame</code> and saves in the
  * <code>window</code> attribute the program's frame.
  */
  @Override
  public void onSetUp() {
    JFrame frame = GuiActionRunner.execute(() -> new LoginFrame());
    window = new FrameFixture(robot(), frame);
    window.show();
  }
  
  /**
   * Tests if the button <code>login</code> exists in the current frame.
   */
  @Test
  public void shouldFindButtonWithFinderWithCurrentAWTHierarchy() {
    ComponentFinder finder = BasicComponentFinder.finderWithCurrentAwtHierarchy();
    finder.findByName("login", true);
  }
  
  /**
   * Tests if a new label named <code>pw</code> appears when <code>login</code> button 
   * is clicked.
   * @throws InterruptedException
   */
  @Test
  public void shouldFindNewButtonWithFinderWithNewAWTHierarchy() throws InterruptedException {
    ComponentFinder finder = BasicComponentFinder.finderWithNewAwtHierarchy();
    window.button("login").click();
    // wait until frame is active (> 1s)
    Thread.sleep(1500);
    finder.findByName("pw", true);
  }
  
  /**
   * Tests if a new frame name "mainFrame" appears when login button is clicked.
   * @throws InterruptedException
   */
  @Test
  public void findFrame() throws InterruptedException{
	  FrameFixture frame = WindowFinder.findFrame("loginFrame").using(robot());
	  frame.button("login").click();
	  Thread.sleep(1500);
	  frame = WindowFinder.findFrame("mainFrame").using(robot());
	  frame.show();
  }
  
}
