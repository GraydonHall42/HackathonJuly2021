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
	private JButton goButton;
	private JTextArea outField;

	
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
		
		// go
		goButton = new JButton("Go");
		
		outField = new JTextArea(10, 10);
		outField.setText("Mine Rate: " + "\n");
		outField.append("Time to Mine: " + "\n");
		outField.append("Date Accessed: " + "\n");
				
		GridBagConstraints gbc = new GridBagConstraints();
		
		// prompt panel
		JPanel inputPanel = new JPanel(new GridBagLayout());
		
		gbc.gridx = 0;
		inputPanel.add(prompt, gbc);
		gbc.gridx++;
		inputPanel.add(inField, gbc);
		gbc.gridx++;
		inputPanel.add(currency, gbc);
		gbc.gridx=1;
		gbc.gridy=1;
		inputPanel.add(goButton, gbc);
		
		
		contentPane.add("North", inputPanel);
		contentPane.add("Center", outField);

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
