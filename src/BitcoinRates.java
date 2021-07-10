import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BitcoinRates {

    private String fileName;
    private int numOfRows=0;  // counter for number of rows in CSV
    private int numOfCols =3;  // number of columns in CSV
    private double btcRate;  // price for BTC in USD
    private double btcAmt;  // amount of BTC they want to mine in USD
    private double[][] csvData;
    double miningRate = 0;  // counter for our current mining rate (all miners going)

    public double getRequiredHrsToMine() throws FileNotFoundException {
        readCSV();  // gets our CSV data
        requiredHrsToMine = btcAmt / btcRate / miningRate;
        return requiredHrsToMine;
    }

    double requiredHrsToMine;

    public BitcoinRates(Double btcRate, Double btcAmt) {
        this.fileName = "MiningSetup.csv";
        this.btcRate = btcRate;
        this.btcAmt = btcAmt;
    }



    private void readCSV() throws FileNotFoundException {
        String line;
        Scanner s = null;
        s = new Scanner( new File(fileName));  // scan in the text file

        csvData = new double[25][numOfCols];  // array to hold our CSV data, up to 25 rows



        while(s.hasNextLine()) {  // while there's more lines to read
            line = s.nextLine();  // read next line
            String[] rowAsString;
            rowAsString = line.split(",");  // split row into array of 3 strings

            // read rwo into CSV Data array for later use
            for (int i=1; i < rowAsString.length; i++) {
                csvData[numOfRows][i]= Double.parseDouble(rowAsString[i]);
            }

            miningRate += Double.parseDouble(rowAsString[1]);  // add rate to mining rate
            numOfRows++;  // increment so we can go to next row
        }

        System.out.println(Arrays.deepToString(csvData));  // visualize CSV as array
        System.out.println(miningRate);


    }

    public static void main(String[] args) {

        // input = how much bitcoin they want to mine (in USD)

        // read in CSV (locally)
        // all my miners are going at once...
        // note that we could add complexity later... only have bravo going 12-5 for example.

        // get how much they want to mine

        var x = new BitcoinRates(33694.9726, 100.00);
        try {
            System.out.println(x.getRequiredHrsToMine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
