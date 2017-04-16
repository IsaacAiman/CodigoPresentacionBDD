/**
 * @authors Javier Ramos Fernández and Isaac Aiman Salas
 * @date 17 April 2017
 * @subject Programación de Aplicaciones Interactivas
 * Demonstration of the Java Robot Class.
 */

package example3RobotClass;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Class that represents a TextEditor.
 *
 */
public class TextEditor implements ActionListener {
	// Size of editing text area.
	private static final int NUM_ROWS = 25;
	private static final int NUM_COLS = 50;
	//Scroll pane of the text
	private JScrollPane textScroller;
	// Buttons to save and load files.
	private JButton saveButton, loadButton;

	// Area where the user does the editing
	private JTextArea text;

	// Creates the GUI
	public TextEditor() {
		JFrame frame = new JFrame();
		JPanel buttonPanel = new JPanel();
		saveButton = new JButton("Save File");
		loadButton = new JButton("Load File");
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);

		text = new JTextArea(NUM_ROWS, NUM_COLS);
		text.setFont(new Font("System", Font.PLAIN, 24));
		textScroller = new JScrollPane(text);
		Container contentPane = frame.getContentPane();
		contentPane.add(textScroller, BorderLayout.CENTER);
		contentPane.add(buttonPanel, BorderLayout.NORTH);

		saveButton.addActionListener(this);
		loadButton.addActionListener(this);

		frame.pack();
		frame.setVisible(true);
	}


	/**
	 * Listener for button clicks that loads the specified files and puts it in the editor.
	 */
	public void actionPerformed(ActionEvent event) {
		Thread hilo1 = new Thread(new Hilo(getTextScroller().getVerticalScrollBar()));
		if (event.getSource() == saveButton) {
			saveFile();
		} else {
			loadFile();
			hilo1.start();
		}
	}


	/**
	 * Method that displays a file chooser so the user can select a file
	 * to save to. Then writea the contents of the text area
	 * to that file. Does nothing if the user cancels out
	 * of the file chooser.
	 */
	private void saveFile() {
		File file;

		// create and display dialog box to get file name
		JFileChooser dialog = new JFileChooser();

		// Make sure the user didn't cancel the file chooser
		if (dialog.showSaveDialog(text) == JFileChooser.APPROVE_OPTION) {

			// Get the file the user selected
			file = dialog.getSelectedFile();

			try {
				// Now write to the file
				PrintWriter output = new PrintWriter(new FileWriter(file));
				output.println(text.getText());
				output.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(text, "Can't save file "
						+ e.getMessage());
			}
		}
		
		
		
	}

	/** 
	 * Method that displays a file chooser so the user can select a file to load.
	 * Then loads the file into the editing area. Does nothing if
	 * the user cancels the file chooser.
	 */
	private void loadFile() {
		String line;
		File file;

		// create and display dialog box to get file name
		JFileChooser dialog = new JFileChooser();

		// Make sure the user did not cancel.
		if (dialog.showOpenDialog(text) == JFileChooser.APPROVE_OPTION) {
			// Find out which file the user selected.
			file = dialog.getSelectedFile();

			try {
				// Open the file.
				BufferedReader input = new BufferedReader(new FileReader(file));

				// Clear the editing area
				text.setText("");

				// Fill up the ediitng area with the contents of the file being
				// read.
				line = input.readLine();
				while (line != null) {
					text.append(line + "\n");
					line = input.readLine();
				}

		
				// Close the file
				input.close();
				JScrollBar vertical = getTextScroller().getVerticalScrollBar();
				vertical.setValue( vertical.getMaximum() );

			} catch (IOException e) {
				JOptionPane.showMessageDialog(text, "Can't load file "
						+ e.getMessage());
			}
			
		}
	}

	/**
	 * Main program that creates a text editor.
	 * @param args
	 */
	public static void main(String[] args) {
		new TextEditor();
	}
	
	/**
	 * Method that returns the text scroller.
	 * @return textScoller as JScrollPane
	 */
	public JScrollPane getTextScroller() {
		return textScroller;
	}
	
	/**
	 * Method that sets a new text scroller.
	 * @param textScroller New textscroller.
	 */
	public void setTextScroller(JScrollPane textScroller) {
		this.textScroller = textScroller;
	}
	
}