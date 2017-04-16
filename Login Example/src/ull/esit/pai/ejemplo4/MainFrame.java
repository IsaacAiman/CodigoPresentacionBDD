/*
 * Class that represents a window with the information 
 * of a user login. 
 * Subject: Programación de aplicaciones interactivas
 */
package ull.esit.pai.ejemplo4;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * Class that represents a window with the information 
 * of a user login. 
 */
public class MainFrame extends JFrame {
  private static final long serialVersionUID = 1L;

  /**
   * Adds all the components, needed to show the login 
   * information of a user, to the JFrame.
   * @param name of the user.
   */
  public MainFrame(String name) {
	
	this.setName("mainFrame");
    setLayout(new GridLayout(3,1));
    getRootPane().setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    
    JLabel labelName = new JLabel("The user has the name: '" + name + "'");
    labelName.setName("name");
    add(labelName);
    JLabel labelPassword = new JLabel("and the password: '***");
    labelPassword.setName("pw");
    
    add(labelName);
    add(labelPassword);
    pack();
    
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  }
}
