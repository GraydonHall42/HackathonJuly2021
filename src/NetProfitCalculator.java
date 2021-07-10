import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class NetProfitCalculator {
    public void calcHourlyProfit() throws IOException {

        BitcoinRates br = null;
        try {
            br = new BitcoinRates(33694.9726, 100.00);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        var miningElec = new MiningElectricity();
        try {
            miningElec.openFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // our array of electricity rates
        var elecArray = miningElec.getElectricityRate();
//        System.out.println(Arrays.toString(elecArray));


        var miners = br.getMiners();

        // ********** ADDD CODE HERE TO GET BITCOIN PRICE FROM BRANDON *********
        JSONParse json = new JSONParse();
		
		BitcoinData btcData = json.getBitcoinData();
		
		// get the USD/BTC price
		Double btcPrice = btcData.getRate();
  
        // For each miner:
        System.out.println("--------------- Hourly Profit ($) For each of your miners ----------------");
        for(int i=0;i<br.numMiners(); i++){
            Miner currentMiner = miners[i];
            var miningCalc = new MiningNetProfit(btcPrice, currentMiner.wattage, currentMiner.rate, elecArray);

            System.out.println(currentMiner.name);
            System.out.println(Arrays.toString(miningCalc.getNetProfitHourly()));
        }


    }

    public static void main(String[] args) throws IOException {
        var x = new NetProfitCalculator();
        x.calcHourlyProfit();
    }


}
