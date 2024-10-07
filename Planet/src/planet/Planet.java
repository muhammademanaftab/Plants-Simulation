/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package planet;

import java.util.ArrayList;
import java.io.*;

/**
 * Represents a planet that contains a collection of {@link Plant} objects and
 * simulates the effects of radiation on the plant. The type of radiation on the
 * planet (alpha or delta) is effected by the nutrient needs of the plants.
 *
 * @author Muhammad Eman Aftab
 */
public class Planet {

    /**
     * A collection of plants on the planet.
     */
    private ArrayList<Plant> plants;

    private ArrayList<Plant> getPlants() {
        return plants;
    }

    /**
     * The type of radiation affecting the plants on the planet. It can be
     * "no-radiation", "alpha",or "delta".
     */
    private String radiation;

    /**
     * The total alpha nutrient needs of the plants on the planet.
     */
    private int totalAlpha;

    /**
     * The total delta nutrient needs of the plants on the planet.
     */
    private int totalDelta;

    /**
     * Constructs a new Planet with no plants and radiation type of "no
     * radiation".
     */
    public Planet() {
        this.plants = new ArrayList<>();
        this.radiation = "no radiation";
    }

    /**
     * Adds a new plant to the planet.
     *
     * @param p the plant to be added to the planet
     */
    public void addPlant(Plant p) {
        this.plants.add(p);
    }

    /**
     * Simulates the changes in nutrient levels of the plants based on the
     * current radiation. It also updates the planet's radiation type based on
     * the balance between alpha and delta nutrient needs.
     *
     */
    public void simulate() {
        totalAlpha = 0;
        totalDelta = 0;
        for (Plant p : plants) {
            p.changeN(radiation);  // Update the plant nutrient level based on radiation type
            if (p.stillLiving()) {  // Only calculate needs for living plants
                if (p instanceof Puffs) {
                    totalAlpha += (10 - p.N);  // Alpha need is determined by how much Puffs is below 10 nutrient level
                } else if (p instanceof DeltaTree) {
                    if (p.N < 5) {
                        totalDelta += 4;  // Delta need increases by 4 if the DeltaTree has less than 5 nutrients
                    } else if (p.N >= 5 && p.N <= 10) {
                        totalDelta += 1;  // Delta need increases by 1 if nutrients are between 5 and 10
                    }
                }
            }
        }

        // Update the radiation type based on the balance between alpha and delta needs
        if (Math.abs(totalAlpha - totalDelta) >= 3 && totalAlpha > totalDelta) {
            radiation = "alpha";
        } else if (Math.abs(totalDelta - totalAlpha) >= 3 && totalDelta > totalAlpha) {
            radiation = "delta";
        }
    }

    /**
     * ReadData function to read data from input file and storing it.
     *
     * @param filename from which we read data
     */
    public void readSimulateData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int plantsNumber = Integer.parseInt(br.readLine());  // Read number of plants
            for (int i = 0; i < plantsNumber; i++) {
                String[] line = br.readLine().split(" ");
                int N = Integer.parseInt(line[2]);  // Extract plant nutrient level
                switch (line[1]) {
                    case "p":  // If plant type is "p",create a Puff plant
                        this.addPlant(new Puffs(line[0], N));
                        break;
                    case "b":  // If plant type is "b", create a Parabush plant
                        this.addPlant(new Parabush(line[0], N));
                        break;
                    case "d":  // If plant type is "d", creates a DeltaTree plant
                        this.addPlant(new DeltaTree(line[0], N));
                        break;
                }
            }

            int days = Integer.parseInt(br.readLine());  // Reading number of days

            // Simulate the planet for the specified number of days
            for (int i = 0; i < days; i++) {
                this.simulate();  // Updating plant states based on current radiation
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + filename);
        }  catch (IOException e) {
            System.out.println("IO Exception occurred: " + e.getMessage());
        }
    }

    /**
     * Report Data function to output the data by using simulate function.
     */
    public void printData() {
        // Output the final state of all plants 
        for (Plant p : this.getPlants()) {
            System.out.println(p);
        }
    }
}
