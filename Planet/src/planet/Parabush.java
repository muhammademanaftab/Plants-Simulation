/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package planet;

/**
 * Represents a specific type of plant called Parabush, which inherits from the
 * {@link Plant} class. Parabush has its own rules for adjusting its nutrient
 * level (N) based on different types of radiation.
 * 
 *  
 * @author Muhammad Eman Aftab
 */
public class Parabush extends Plant {

    /**
     * Constructs a new Parabush object with the specified name and nutrient level.
     * 
     * @param name the name of the Parabush
     * @param N the initial nutrient level of the plant
     */
    public Parabush(String name, int N) {
        super(name, N);
    }

    /**
     * Changes the plant's nutrient level (N) based on the type of radiation it receives.
     * 
     * @param radiation the type of radiation affecting the plant (either "no radiation","alpha", or "delta")
     */
    @Override
    public void changeN(String radiation) {
        switch (radiation) {
            case "no radiation":
                this.N -= 1;
                break;
            case "alpha":
                this.N += 1;
                break;
            case "delta":
                this.N += 1;
                break;
        }
        
        // The plant is living only if its nutrient level exceeds 0
        living = (this.N > 0);
    }
}
