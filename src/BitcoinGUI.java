import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

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

	/**
	 * BitcoingGUI() creates a BitcoinGUI instance and creates the GUI
	 * @param title
	 */
	public BitcoinGUI(String title) {
		buildGUI();
		setTitle(title);
		pack();
		setVisible(true);
	}
	
	/**
	 * buildGUI() initializes and sets all
	 */
	public void buildGUI() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		// initialize user input fields
		prompt = new JLabel("Amount to mine");
		inField = new JTextField(10);
		currency = new JLabel("USD");
		
		// initialize run button
		goButton = new JButton("Go");
		goButton.addActionListener(this);
		
		// initialize output field
		outField = new JTextArea(10, 10);
		outField.setText("BTC Price: " + "\n");
		outField.append("Time to Mine: " + "\n");
		outField.append("Date Accessed: " + "\n");
		
		// set up prompt panel
		JPanel inputPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// add components to panel
		gbc.gridx = 0;
		inputPanel.add(prompt, gbc);
		gbc.gridx++;
		inputPanel.add(inField, gbc);
		gbc.gridx++;
		inputPanel.add(currency, gbc);
		gbc.gridx=1;
		gbc.gridy=1;
		inputPanel.add(goButton, gbc);
		
		// add all components to final panel
		contentPane.add("North", inputPanel);
		contentPane.add("Center", outField);

	}
	
	
	public static void main(String[] args) throws IOException {
		BitcoinGUI app = new BitcoinGUI("BTC");
		
        var x = new NetProfitCalculator();
        x.calcHourlyProfit();
	}
	
	/**
	 * actionPerformed() implements the actionPerformed method of the ActionListener class
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// executed if go button is clicked
		if(e.getSource() == goButton) {
			
			try {
				JSONParse json = new JSONParse();
				
				BitcoinData btcData = json.getBitcoinData();
				
				// get the USD/BTC price
				String time = btcData.getTime();
				Double btcPrice = btcData.getRate();
				
				outField.setText("BTC Price: " +  btcPrice + " USD/BTC" + "\n");
				
				// create object for mine rate of btc 
				BitcoinRates rate = new BitcoinRates(btcPrice, Double.parseDouble(inField.getText()));
				
				// get the time to mine
				Double mineTime = rate.getRequiredHrsToMine();
				
				outField.append("Time to Mine: " + mineTime.toString() + " hrs" + "\n");
				outField.append("Date Accessed: " + time);
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
