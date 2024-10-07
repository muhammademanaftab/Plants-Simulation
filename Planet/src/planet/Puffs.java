/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package planet;

/**
 * Represents a specific type of plant known as Puffs, which inherits from the 
 * {@link Plant} class. Puffs have specific behaviors when exposed to different 
 * types of radiation that affect their nutrient.
 * @author Muhammad Eman Aftab
 */
public class Puffs extends Plant {
    
    /**
     * Constructs a new Puffs object with the specified name and nutrient level.
     * The initial alpha nutrient need is calculated as 10 minus the given nutrient level.
     * 
     * @param name the name of the plant
     * @param N the initial nutrient level of the plant
     */
    public Puffs(String name, int N) {
        super(name, N);
        this.alpha_need = 10 - this.N;
    }
    
    /**
     * Changes the plant's nutrient level (N) based on the type of radiation it receives.
     * After the nutrient level is updated, the plant is considered living only if its 
     * nutrient level is greater than 10.
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
                this.N += 2;
                break;
            case "delta":
                this.N -= 2;
                break;
        }
        // The plant is living only if its nutrient level exceeds 10
        living = (this.N > 10);
    }
}
