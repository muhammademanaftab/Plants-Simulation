/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package planet;

/**
 * Represents a specific type of plant called DeltaTree, which inherits from the 
 * {@link Plant} class. DeltaTree has its own specific rules for how its nutrient 
 * level (N) changes based on the type of radiation it encounters.
 * 
 * @author Muhammad Eman Aftab
 */
public class DeltaTree extends Plant {

    /**
     * Constructs a new DeltaTree object with the specified name and nutrient level .
     * 
     * @param name the name of the DeltaTree
     * @param N the initial nutrient level of the plant
     */
    public DeltaTree(String name, int N) {
        super(name, N);
    }

    /**
     * Changes the plant's nutrient level (N) based on the type of radiation it receives.
     * After the nutrient level is updated, the plant is considered living if its nutrient 
     * level is greater than 0.
     * 
     * @param radiation the type of radiation affecting the plant (either "no radiation", "alpha",or "delta")
     */
    @Override
    public void changeN(String radiation) {
        switch (radiation) {
            case "no radiation":
                this.N -= 1;
                break;
            case "alpha":
                this.N -= 3;
                break;
            case "delta":
                this.N += 4;
                break;
        }
        // The plant is living only if its nutrient level is more then 0
        living = (this.N > 0);
    }
}
