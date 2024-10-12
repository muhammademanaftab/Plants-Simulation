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
 *-------Planet class jo puraaa program run kregi iski apni Radiation haaa jokay decide hogi
 * overall plants keee base pr ke onko kitni radiaiton chahaiy.
 * @author Muhammad Eman Aftab
 */
public class Planet {

    /**
     * A collection of plants on the planet.
     * List haaa plants keee
     */
    private ArrayList<Plant> plants;

    private ArrayList<Plant> getPlants() {
        return plants;
    }

    /**
     * The type of radiation affecting the plants on the planet. It can be
     * No_Radiation, Alpha,or Delta.
     */
    private Radiation radiation;

    /**
     * The total alpha nutrient needs of the plants on the planet.
     */
    private int totalAlpha;

    /**
     * The total delta nutrient needs of the plants on the planet.
     */
    private int totalDelta;

    /**
     * Constructs a new Planet with no plants and radiation type of No_Radiation
     *
     */
    public Planet() {
        this.plants = new ArrayList<>();
        this.radiation = new No_Radiation();
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
     *
     * Simulates the growth of plants over a specified number of days, adjusting
     * their nutrient levels based on radiation types.
     *--Simulation chalaingay agar koi plant die hogyaa osay remove krdenge or 
     * bakioh keee alpha or deltaa neeed decide krenge.
     */
  
public void simulate(int N) {
    for (int day = 0; day < N; day++) {
        int totalAlphaNeed = 0;
        int totalDeltaNeed = 0;
        ArrayList<Plant> plantsToRemove = new ArrayList<>();

        for (Plant plant : plants) {
            plant.changeN(radiation);
            if (plant.living) {
                totalAlphaNeed += plant.requireAlphaNeed();
                totalDeltaNeed += plant.requireDeltaNeed();
            } else {
                plantsToRemove.add(plant);
            }
        }

        plants.removeAll(plantsToRemove);
        int radiationDifference = totalAlphaNeed - totalDeltaNeed;

        if (Math.abs(radiationDifference) >= 3) {
            if (radiationDifference > 0) {
                radiation = new Alpha();
            } else {
                radiation = new Delta();
            }
        } else {
            radiation = new No_Radiation();
        }

        System.out.println("Day " + (day + 1) + ":");
        System.out.println("Radiation Type: " + radiation.RadiationType());
        
        printData();
        
        System.out.println();
    }
}


    /**
     * ReadData function to read data from input file and storing it.
     *---File reading haaa jo ke buffer reader se krenege or input lenege file se
     * @param filename from which we read data
     */
    public void readSimulateData(String filename) throws InvalidCharacterException,
            InvalidNumberFormatException,
            InvalidNumberOfEntriesException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            int plantsNumber;
            try {
                plantsNumber = Integer.parseInt(br.readLine());  
            } catch (NumberFormatException e) {
                throw new InvalidNumberFormatException("The First line must be an Integer representing the number of plants.");
            }

            for (int i = 0; i < plantsNumber; i++) {
                String[] line = br.readLine().split(" "); 

                if (line.length != 3) {
                    throw new InvalidNumberOfEntriesException("Not correct entry format. There should be Expected plant name, type, and nutrient value.");
                }

                String plantName = line[0];
                String plantType = line[1];
                int N;

                try {
                    N = Integer.parseInt(line[2]);
                } catch (NumberFormatException e) {
                    throw new InvalidNumberFormatException("Not correct nutrient format for plant it must be inetegr: " + plantName);
                }

                switch (plantType) {
                    case "p":  
                        this.addPlant(new Puffs(plantName, N));
                        break;
                    case "b":  
                        this.addPlant(new Parabush(plantName, N));
                        break;
                    case "d":  
                        this.addPlant(new DeltaTree(plantName, N));
                        break;
                    default: //yeh tab chalegaa jaab koi or nai chalege, 
                        throw new InvalidCharacterException("Not correct plant type: " + plantType + " for plant : " + plantName);
                }
            }

            if (br.ready()) {
                String nextLine = br.readLine();

                try {
                    int days = Integer.parseInt(nextLine);

                    this.simulate(days);
                } catch (NumberFormatException e) {
                    throw new InvalidNumberFormatException("Not correct number format for days: " + nextLine);
                }
            } else {
                throw new InvalidNumberOfEntriesException("Missing simulation days input after plant entries.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + filename);
        } catch (IOException e) {
            System.out.println("IO Exception occurred.");
        }
    }

    /**
     * Report Data function to output the data by using simulate function.
     * ----------------yeh print kregaa data ke kiaaa plants kese print hongay or plants ke andar override huwa huwa haaaaa.
     */
    public void printData() {
        // Making a counter for surviving plants
        int survivorCount = 0;

        for (Plant p : this.getPlants()) {
            if (p.living) {
                System.out.println(p);
                survivorCount++;  //
            }
        }

        if (survivorCount == 0) {
            System.out.println("No survivor plants.");
        }
    }

}
