import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MiningElectricity {

    //1 Bitcoin takes 1544 kwh to complete - 53 days

    private double cost = 0.13;
    Scanner sc;
    private double[] tempsArray;


    public void openFile(){
        double token1 = 0.0;
        
        try {
            sc = new Scanner(new File("EnergyRates.csv"));
            sc.useDelimiter(" , "); 
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  

        List<Double> temps = new ArrayList<Double>();

        while (sc.hasNextDouble())  //returns a boolean value  
        {  
        // System.out.print(sc.next());  //find and returns the next complete token from this scanner  
            token1 = sc.nextDouble();
            temps.add(token1);
        }   
        sc.close();  //closes the scanner  

        // tempsArray = temps.toArray();

        for (double d : tempsArray) {
            System.out.println(d);
          }
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
        
        electricity.openFile();
        maxElectricity = electricity.findMax();

        System.out.println("The maximum energy rate is at: " + maxElectricity);
        
        




}   
}   
