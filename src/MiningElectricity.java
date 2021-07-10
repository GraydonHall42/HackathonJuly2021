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
        Scanner s = null;
        s = new Scanner( new File("EnergyRates.csv"));  // read in the CSV file
        elecArr = new double[24]; 
        
        try {
            sc = new Scanner(new File("EnergyRates.csv"));
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
        



        // List<String> lines = File.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        // for (String line : lines) { 
        //     String[] array = line.split(";"); 
        //     System.out.println(array[0]+" "+array[array.length-1]); 
        //  }

        sc.close();  //closes the scanner  

        // tempsArray = temps.toArray(temps[0][0]);

        // for (double d : temps) {
        //     System.out.println(d);
        //   }

    }  

    public double findMax(){

        double maximum = tempsArray[0]; 

        // for (int i=1; i<tempsArray.length; i++) {
        //     tempsArray[i] = .valueOf(tempsArray[i]); // new maximum
        //     }
        
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

        // for (int i = 0 ; i<tempsArray.length; i++){
        //  System.out.println(tempsArray);
        // }
        // maxElectricity = electricity.findMax();

        // System.out.println("The maximum energy rate is at: " + maxElectricity);


}   
}   
