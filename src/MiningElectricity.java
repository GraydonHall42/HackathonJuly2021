import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MiningElectricity {

    //1 Bitcoin takes 1544 kwh to complete - 53 days

    private double cost = 0.13;
    // private int numOfCols = 2;
    private int numOfRows = 0;
    private double elecArr[];
    Scanner sc;
    private static double[] tempsArray;


    public void openFile() throws FileNotFoundException {

        // String line;
        // double token1 = 0.0;
        String line;
        elecArr = new double[24]; 
        
        try {
            sc = new Scanner(new File("EnergyRates.csv"));  // read in the CSV file
            sc.useDelimiter(" , "); 
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  

        List<Double> temps = new ArrayList<Double>();

        while(sc.hasNextLine()) {  // while there's more lines to read
            line = sc.nextLine();  // read next line
            String[] rowAsString;
            rowAsString = line.split(",");  // split row into array of 3 strings

            // read row into CSV Data array for later use
            for (int i=1; i < rowAsString.length; i++) {
                elecArr[numOfRows]= Double.parseDouble(rowAsString[i]);
                numOfRows++; 
            }
            // miningRate += Double.parseDouble(rowAsString[1]);  // add each miner to mining rate
             // increment so we can go to next row

        }
        for (int i=0; i < elecArr.length; i++) {
            System.out.println(elecArr[i]);
        }

        sc.close();  //closes the scanner  

    }  

    public double findMax(){

        double maximum = tempsArray[0]; 

        // start with the first value
        for (int i=1; i<tempsArray.length; i++) {
            if (tempsArray[i] > maximum) {
                maximum = tempsArray[i];   // new maximum
            }
        }
        return maximum;
    }


    public static void main(String[] args) { 
        double maxElectricity;

        MiningElectricity electricity = new MiningElectricity();
        
        try {
            electricity.openFile();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }   
}   
