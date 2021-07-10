import java.io.FileNotFoundException;
import java.util.Arrays;

public class NetProfitCalculator {
    public static void main(String[] args) {

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

        // For each miner:
        for(int i=0;i<br.numMiners(); i++){
            Miner currentMiner = miners[i];
            var miningCalc = new MiningNetProfit(33695.0, currentMiner.wattage, currentMiner.rate, elecArray);

            System.out.println(currentMiner.name);
            System.out.println(Arrays.toString(miningCalc.getNetProfitHourly()));
        }





    }


}
