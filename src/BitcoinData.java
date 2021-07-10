public class BitcoinData {
	private String updateTime;
	private double bitcoinRate;
	
	public BitcoinData(String time, double rate) {
		updateTime = time;
		bitcoinRate = rate;
	}
	
	public String getTime() {
		return updateTime;
	}
	
	public double getRate() {
		return bitcoinRate;
	}
}