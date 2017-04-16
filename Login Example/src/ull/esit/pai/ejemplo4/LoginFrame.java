/*
 * Class that simulates a login window.
 * Subject: Programación de aplicaciones interactivas
 */
package ull.esit.pai.ejemplo4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


/**
 * Class that simulates a login window.
 */
public class LoginFrame extends JFrame {
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor that creates all the components of the window.
   */
  public LoginFrame() {

	this.setName("loginFrame");
	
    final JLabel nameLabel = new JLabel("Username");
    nameLabel.setName("username");
    final JTextField textField = new JTextField();
    textField.setName("username");
    final JLabel pwLabel = new JLabel("Password");
    pwLabel.setName("password");
    final JTextField pwField = new JPasswordField();
    pwField.setName("password");

    JButton loginButton = new JButton("Login");
    loginButton.setName("login");

    loginButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        LoginFrame.this.dispose();
        login(textField);
      }
    });

    setLayout(new GridLayout(3,2));
    getRootPane().setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    
    
    add(nameLabel);
    add(textField);
    add(pwLabel);
    add(pwField);
    add(loginButton);

    pack();
  }

  /**
   * Simulates a login.
   */
  private void login(final JTextField textField) {
    // simulate database interaction
    new Thread(new Runnable() {

      @Override
      public void run() {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e1) {
          e1.printStackTrace();
        }
        // show the great application
        SwingUtilities.invokeLater(new Runnable() {

          @Override
          public void run() {
            JFrame frame = new MainFrame(textField.getText());
            frame.setVisible(true);
          }
        });
      }
    }).start();
    ;
  }
 
}
