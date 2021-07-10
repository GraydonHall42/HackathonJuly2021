import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * BitcoinGUI represents the interface for the user
 * to interact with the application
 * @author Rohinesh Ram
 *
 */
public class BitcoinGUI extends JFrame implements ActionListener {
	
	private JLabel prompt;
	private JTextField inField;
	private JLabel currency;
	private JLabel mineRateLabel;
	private JTextArea mineRate;
	private JLabel mineRateUnit;
	private JButton goButton;
	private JLabel mineTimeLabel ;
	private JTextArea mineTime;
	private JLabel dateLabel;
	private JTextArea dateAccessed;
	
	
	public BitcoinGUI(String title) {
		buildGUI();
		setTitle(title);
		pack();
		setVisible(true);
	}
	
	public void buildGUI() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		// user input
		prompt = new JLabel("Amount to mine");
		inField = new JTextField(10);
		currency = new JLabel("USD");
		
		// mining rate
		mineRateLabel = new JLabel("Mine Rate");
		mineRate = new JTextArea(1, 10);
		mineRateUnit = new JLabel("BTC/hr");
		
		// go
		goButton = new JButton("Go");
		
		// mine time
		mineTimeLabel = new JLabel("Time To Mine");
		mineTime = new JTextArea(1,10);
		
		// date accessed
		dateLabel = new JLabel("Date Accessed");
		dateAccessed = new JTextArea(1, 10);
		
		JPanel inputPanel = new JPanel(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		
		//prompt
		constraint.gridx = 0;
		constraint.gridy = 0;
		inputPanel.add(prompt, constraint);
		
		//input
		constraint.gridx = 1;
		constraint.gridy = 0;
		inputPanel.add(inField, constraint);
		
		// currency label
		constraint.gridx = 2;
		constraint.gridy = 0;
		inputPanel.add(currency, constraint);
		
		//mine rate label
		constraint.gridx = 0;
		constraint.gridy = 1;
		inputPanel.add(mineRateLabel, constraint);
		
		// mine rate field
		constraint.gridx = 1;
		constraint.gridy = 1;
		inputPanel.add(mineRate, constraint);
		
		// mine rate unit
		constraint.gridx = 2;
		constraint.gridy = 1;
		inputPanel.add(mineRateUnit, constraint);
		
		// button
		constraint.gridx = 1;
		constraint.gridy = 2;
		inputPanel.add(goButton, constraint);
		goButton.addActionListener(this);
		
		// time to mine label
		constraint.gridx = 0;
		constraint.gridy = 3;
		inputPanel.add(mineTimeLabel, constraint);
		
		// time to mine
		constraint.gridx = 1;
		constraint.gridy = 3;
		inputPanel.add(mineTime, constraint);
		
		// date accessed label
		constraint.gridx = 0;
		constraint.gridy = 4;
		inputPanel.add(dateLabel, constraint);
		
		// date accessed
		constraint.gridx = 1;
		constraint.gridy = 4;
		inputPanel.add(dateAccessed, constraint);
		
		contentPane.add(inputPanel);
	}
	
	
	public static void main(String[] args) {
		BitcoinGUI app = new BitcoinGUI("BTC");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ADD code to run Brandons class
		// Add code to run Gradys class
		
	}
}
