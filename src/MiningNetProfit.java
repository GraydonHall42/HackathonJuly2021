import java.util.Arrays;

public class MiningNetProfit {
    private double btcRate;  // price for BTC in USD
    private double minerWattage;  // watts this miner uses
    private double minerRate;  // rate of BTC/hr
    private double[] elecCost;  // 1D array of the electricity costs each hour (cents/KWh)

    // idea:
    // net profit (for that hour)= btc rate ($/btc) * miner rate (BTC/hr) - wattage (W)/1000 * (cents/kWh) * 100

    public static void main(String[] args) {
        var elecCostTest = new int[{6, 6, 7, 7, 6, 6, 7, 7, 6, 6, 7, 7, 6, 6, 7, 7, 6, 6, 7, 7, 6, 6, 7, 7};
        System.out.println(Arrays.toString(elecCostTest));
    }


}
