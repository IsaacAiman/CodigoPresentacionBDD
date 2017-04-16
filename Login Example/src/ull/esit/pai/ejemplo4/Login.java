/*
 * Class that executes a simulation of a login program.
 * subject: Programación de aplicaciones interactivas.
 */
package ull.esit.pai.ejemplo4;

import javax.swing.JFrame;
/**
 * Class that executes a simulation of a login program.
 */
public class Login{
	
	  public static void main (String args[]){
		  LoginFrame login = new LoginFrame();
		  login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  login.setVisible(true);
	  }
}
