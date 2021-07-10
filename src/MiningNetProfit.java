import java.util.Arrays;

public class MiningNetProfit {
    private double btcRate;  // price for BTC in USD

    private double minerWattage;  // watts this miner uses
    private double minerRate;  // rate of BTC/hr
    private double[] elecCost;  // 1D array of the electricity costs each hour (cents/KWh)

    public MiningNetProfit(double btcRate, double minerWattage, double minerRate, double[] elecCost) {
        this.btcRate = btcRate;
        this.minerWattage = minerWattage;
        this.minerRate = minerRate;
        this.elecCost = elecCost;
    }

    public double[] getNetProfitHourly() {
        // net profit (for that hour)= btc rate ($/btc) * miner rate (BTC/hr) - wattage (W)/1000 * (cents/kWh) / 100
        double hourlyProfit;
        netProfitHourly = new double[elecCost.length];

        for(int i=0; i<elecCost.length; i++){
            hourlyProfit = btcRate * minerRate - minerWattage/1000*elecCost[i]/100;
            netProfitHourly[i] = hourlyProfit;
        }

        return netProfitHourly;
    }

    private double[] netProfitHourly;



    // idea:


    public static void main(String[] args) {
        double[] elecCostTest  = {6, 6, 7, 7, 6, 6, 7, 7, 6, 6, 7, 7, 6, 6, 7, 7, 6, 6, 7, 7, 6, 6, 7, 7};
        double btcRateTest = 33694.9726;
        double minerWattageTest = 823;
        double minerRateTest = 0.00010294;

        var x = new MiningNetProfit(btcRateTest, minerWattageTest, minerRateTest, elecCostTest);

        System.out.println(Arrays.toString(x.getNetProfitHourly()));
    }


}
