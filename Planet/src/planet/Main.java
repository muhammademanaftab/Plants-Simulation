/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package planet;

import java.io.*;

/**
 * The main class that control the simulation of the {@link Planet} and its plants.
 * The program reads plant data from a file, initializes the planet plants, 
 * simulates the plant changes over a number of days,and outputs the results.
 * 
 * 
 * @author Muhammad Eman Aftab
 */
public class Main {

    
    /**
     * The main method that serves as the entrance point for the program. It initializes 
     * the {@link Planet}, reads plant data from file,simulates the planet's radiation 
     * effects over a number of days,and then outputs the final state of the plants.
     * 
     * @param args the command line arguments (we are not using them)
     */
    public static void main(String[] args) {
        
        Planet planet = new Planet();  // Making a new planet
        
        String fileName = "input.txt";  // Giving path to the input file
        
        planet.readSimulateData(fileName); // Reading Data from input file and then simulating it.
        planet.printData(); // Reporting and Printing Data
        
        
        
        
        
//        Testing Purpose        
//        planet.addPlant(new Puffs("Piggy",7));
//        planet.addPlant(new DeltaTree("Willowy",3));
//        planet.addPlant(new Parabush("Dumpy",4));   
//        System.out.println(planet.plants.get(0));
//        System.out.println(planet.plants.get(1));
//        System.out.println(planet.plants.get(2));
//        for (int i = 0; i < 10; i++) {
//            planet.simulate();
//            for (Plant p : planet.plants) {
////                if(p.living){
//                    System.out.println(p);
////                }
//            }
//        }
       
    }
}
