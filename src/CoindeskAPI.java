import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A class used to read in the current bitcoin data from the Coindesk API.
 * @author Brandon, Roh
 */
public class CoindeskAPI {
	
	// Creates variables.
	private BufferedReader reader;
	private HttpURLConnection connection;
	private String line;
	private StringBuffer bitcoinData;
	private URL url;
			
	
	/**
	 * Instantiates a CoinDeskAPI object, retrieving the current bitcoin data from Coindesk.
	 * @throws IOException 
	 */
	public CoindeskAPI() throws IOException {
		
		// Sets up a get request to the Coindesk API.
		url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		// Sets up the buffered reader to read in the input stream from the API.
		reader = new BufferedReader (new InputStreamReader(connection.getInputStream()));
		
		// Uses the string buffer to append the information from the API.
		bitcoinData = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			bitcoinData.append(line);
		}
	}
		
	/**
	 * Getter method for bitCoinData
	 * @return bitcoinData.toString(), a String representation of the bitcoin data.
	 */
	public String getBitcoinData() {
		return bitcoinData.toString();
	}
		
}
	
