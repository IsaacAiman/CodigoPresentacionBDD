/*
 * Representa un JPanel con la información de una moneda.
 * Programación de Aplicaciones Interactivas
 */

package ull.esit.pai.ejemplo3;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


/**
 * Clase que representa un JPanel con la información de una moneda.
 */
public class CurrencyBox extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel currencyPanelTop = new JPanel();
	JPanel currencyPanelBot = new JPanel();
	JPanel currencyPanelMain = new JPanel();
	JTextField text1 = new JTextField();
	JTextField text2 = new JTextField();
	JTextField text3 = new JTextField();

	public CurrencyBox(String currencyName){
		
		Border blackline;

		blackline = BorderFactory.createLineBorder(Color.gray);
		TitledBorder title;
		title = BorderFactory.createTitledBorder(blackline, currencyName);
		title.setTitleColor(Color.blue);
		title.setTitleJustification(TitledBorder.LEFT);
		Border margin = new EmptyBorder(5,5,5,5);
		
		getText1().setEditable(false);
		getText2().setEditable(false);
		getText3().setEditable(false);
		// top
	    getCurrencyPanelTop().setLayout(new BorderLayout());
	    getCurrencyPanelTop().add(new JLabel("1 euro is: "), BorderLayout.WEST);
	    getCurrencyPanelTop().add(getText1(), BorderLayout.CENTER);
	    getCurrencyPanelTop().add(new JLabel(" " + currencyName), BorderLayout.EAST);
	    
	    // bot
	    getCurrencyPanelBot().setLayout(new GridLayout(2, 2));
	    getCurrencyPanelBot().add(new JLabel("Euros"));
	    getCurrencyPanelBot().add(new JLabel(currencyName));
	    getCurrencyPanelBot().add(getText2());
	    getCurrencyPanelBot().add(getText3());

	    // main
	    getCurrencyPanelMain().setBorder(new CompoundBorder(margin, title));
	    getCurrencyPanelMain().setLayout(new GridLayout(2, 1));
	    getCurrencyPanelMain().add(getCurrencyPanelTop());
	    getCurrencyPanelMain().add(getCurrencyPanelBot());
	   
	}
	
	/**
	 * 
	 * @param value
	 */
	public void update(double value1, double value2){
		
		getText2().setText(String.valueOf(value1));
		getText3().setText(String.valueOf(value2));
		
	}


	/**
	 * @return the currencyPanel
	 */
	public JPanel getCurrencyPanel() {
		return currencyPanelMain;
	}


	/**
	 * @param currencyPanel the currencyPanel to set
	 */
	public void setCurrencyPanel(JPanel currencyPanel) {
		this.currencyPanelMain = currencyPanel;
	}


	/**
	 * @return the currencyPanelTop
	 */
	public JPanel getCurrencyPanelTop() {
		return currencyPanelTop;
	}


	/**
	 * @param currencyPanelTop the currencyPanelTop to set
	 */
	public void setCurrencyPanelTop(JPanel currencyPanelTop) {
		this.currencyPanelTop = currencyPanelTop;
	}


	/**
	 * @return the currencyPanelBot
	 */
	public JPanel getCurrencyPanelBot() {
		return currencyPanelBot;
	}


	/**
	 * @param currencyPanelBot the currencyPanelBot to set
	 */
	public void setCurrencyPanelBot(JPanel currencyPanelBot) {
		this.currencyPanelBot = currencyPanelBot;
	}


	/**
	 * @return the currencyPanelMain
	 */
	public JPanel getCurrencyPanelMain() {
		return currencyPanelMain;
	}


	/**
	 * @param currencyPanelMain the currencyPanelMain to set
	 */
	public void setCurrencyPanelMain(JPanel currencyPanelMain) {
		this.currencyPanelMain = currencyPanelMain;
	}


	/**
	 * @return the text1
	 */
	public JTextField getText1() {
		return text1;
	}


	/**
	 * @param text1 the text1 to set
	 */
	public void setText1(JTextField text1) {
		this.text1 = text1;
	}


	/**
	 * @return the text2
	 */
	public JTextField getText2() {
		return text2;
	}


	/**
	 * @param text2 the text2 to set
	 */
	public void setText2(JTextField text2) {
		this.text2 = text2;
	}


	/**
	 * @return the text3
	 */
	public JTextField getText3() {
		return text3;
	}


	/**
	 * @param text3 the text3 to set
	 */
	public void setText3(JTextField text3) {
		this.text3 = text3;
	}


}
