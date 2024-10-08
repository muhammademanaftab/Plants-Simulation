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
        ArrayList<Plant> plantsToRemove = new ArrayList<>();
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
            } else {
                plantsToRemove.add(p);  // Gathering plants to remove
            }

        }

        // Update the radiation type based on the balance between alpha and delta needs
        if (Math.abs(totalAlpha - totalDelta) >= 3 && totalAlpha > totalDelta) {
            radiation = "alpha";
        } else if (Math.abs(totalDelta - totalAlpha) >= 3 && totalDelta > totalAlpha) {
            radiation = "delta";
        }
        plants.removeAll(plantsToRemove);
    }

    /**
     * ReadData function to read data from input file and storing it.
     *
     * @param filename from which we read data
     */
    public void readSimulateData(String filename) throws InvalidCharacterException,
            InvalidNumberFormatException,
            InvalidNumberOfEntriesException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            int plantsNumber;
            try {
                plantsNumber = Integer.parseInt(br.readLine());  // Read number of plants
            } catch (NumberFormatException e) {
                throw new InvalidNumberFormatException("The First line must be an Integer representing the number of plants.");
            }

            // Loop for the  specified number of plants
            for (int i = 0; i < plantsNumber; i++) {
                String[] line = br.readLine().split(" "); //splitting on basis of space

                // Ensure the entry is in the correct format (3 parts: name, type, nutrient level)
                if (line.length != 3) {
                    throw new InvalidNumberOfEntriesException("Not correct entry format. There should be Expected plant name, type, and nutrient value.");
                }

                String plantName = line[0];
                String plantType = line[1];
                int N;

                // Validate plant nutrient level (must be an integer)
                try {
                    N = Integer.parseInt(line[2]);
                } catch (NumberFormatException e) {
                    throw new InvalidNumberFormatException("Not correct nutrient format for plant it must be inetegr: " + plantName);
                }

                // Validate plant type
                switch (plantType) {
                    case "p":  // If plant type is "p", create a Puff plant.
                        this.addPlant(new Puffs(plantName, N));
                        break;
                    case "b":  // If plant type is "b", Create a Parabush plant
                        this.addPlant(new Parabush(plantName, N));
                        break;
                    case "d":  // If plant type is "d",create a DeltaTree plant
                        this.addPlant(new DeltaTree(plantName, N));
                        break;
                    default: //If there is other character other then these 3 then it should give exception.
                        throw new InvalidCharacterException("Not correct plant type: " + plantType + " for plant : " + plantName);
                }
            }

            // Checkinggs if there are more lines than the expected number of plants
            if (br.ready()) {
                String nextLine = br.readLine();

                // Validate the next line as the number of days for simulation
                try {
                    int days = Integer.parseInt(nextLine);

                    // Simulate the planet for the specified number of days
                    for (int i = 0; i < days; i++) {
                        this.simulate();  // Updating plant states based on current radiation
                    }
                } catch (NumberFormatException e) {
                    throw new InvalidNumberFormatException("Not correct number format for days: " + nextLine);
                }
            } else {
                throw new InvalidNumberOfEntriesException("Missing simulation days input after plant entries.");
            }
            // if there is no file found then file not found exception and on the end IO Exception.
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + filename);
        } catch (IOException e) {
            System.out.println("IO Exception occurred.");
        }
    }

    /**
     * Report Data function to output the data by using simulate function.
     */
    public void printData() {
        // Making a counter for surviving plants
        int survivorCount = 0;

        for (Plant p : this.getPlants()) {
            if (p.living) {  // Check if the plant is alive
                System.out.println(p);  // Print the plant name
                survivorCount++;  // Increasee the counter
            }
        }

        // If no survivors found, print a different message
        if (survivorCount == 0) {
            System.out.println("No survivor plants.");
        } 
    }

}
