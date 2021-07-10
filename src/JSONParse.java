import java.io.IOException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONParse {

private BitcoinData bitcoinData;
	
public JSONParse() throws IOException {
		CoindeskAPI current = new CoindeskAPI();
 		String json = current.getBitcoinData();
		
 		JsonElement element0 = JsonParser.parseString(json);

 		JsonElement time = ((JsonObject) element0).get("time");
		JsonElement bpi = ((JsonObject) element0).get("bpi");
		
 		JsonElement element1 = JsonParser.parseString(time.toString());
 		JsonElement element2 = JsonParser.parseString(bpi.toString());
		
 		JsonElement updatedTime = ((JsonObject) element1).get("updated"); 
 		JsonElement USD = ((JsonObject) element2).get("USD"); 
		
 		JsonElement element3 = JsonParser.parseString(USD.toString());
 		JsonElement rate_float = ((JsonObject) element3).get("rate_float");

 		Double rateUSD = Double.parseDouble(rate_float.toString());

 		bitcoinData = new BitcoinData(updatedTime.toString(), rateUSD);
 	}
	
 	public BitcoinData getBitcoinData() {
 		return bitcoinData;
 	}

 }