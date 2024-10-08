/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package planet;

import java.io.*;

/**
 * The main class that control the simulation of the {@link Planet} and its
 * plants. The program reads plant data from a file, initializes the planet
 * plants, simulates the plant changes over a number of days,and outputs the
 * results.
 *
 *
 * @author Muhammad Eman Aftab
 */
public class Main {

    /**
     * The main method that serves as the entrance point for the program. It
     * initializes the {@link Planet}, reads plant data from file,simulates the
     * planet's radiation effects over a number of days,and then outputs the
     * final state of the plants.
     *
     * @param args the command line arguments (we are not using them)
     */
    public static void main(String[] args) {

        String fileName = "input.txt";  // Giving path to the input file
        try {
            Planet planet = new Planet();
            planet.readSimulateData(fileName);  // Reading data from the input file and then simulating it.
            planet.printData(); // Reporting and Printing Data

        } catch (InvalidCharacterException e) {
            System.out.println("Error: Not correct character in input file. " + e.getMessage());
        } catch (InvalidNumberFormatException e) {
            System.out.println("Error: Not correct number format in input file. " + e.getMessage());
        } catch (InvalidNumberOfEntriesException e) {
            System.out.println("Error: Not correct number of entries in input file. " + e.getMessage());
        }
    }
}
