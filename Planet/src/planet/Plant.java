/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package planet;

/**
 * Abstract class representing a Plant. It defines common properties and methods 
 * for all types of plants, such as the plant name, its nutrient level (N), 
 * and its living status.
 * 
 */
public abstract class Plant {
    
    /**
     * The name and getter of name of the plant.
     */
    protected String name;

    public String getName() {
        return name;
    }
    
    /**
     * The nutrient level of the plant, which determines its living status and its getter.
     */
    protected int N;

    public int getN() {
        return N;
    }
    
    /**
     * Boolean attribute to indicate whether the plant is living or not.
     * A plant is considered living if its nutrient level (N) is greater than 0.
     */
    protected boolean living;
    
    /**
     * The plant alpha need.This can represent the required alpha nutrient for the plant.
     */
    protected int alpha_need = 0;
    
    /**
     * The plant delta need. This can represent the required delta nutrients for the plant.
     */
    protected int delta_need = 0;

    /**
     * Constructor for creating a Plant object.
     * 
     * @param name the name of the plant
     * @param N the initial nutrient level of the plant
     */
    public Plant(String name, int N) {
        this.name = name;
        this.N = N;
        this.living = N > 0; // Plant is living if N is greater than 0
    }
    
    /**
     * Abstract method to change the plant's nutrient level (N) based on radiation.
     * The exact implementation of how N changes will depend on the type of radiation provided.
     * 
     * @param rad the type of radiation affecting the plant
     */
    public abstract void changeN(String rad);
    
    /**
     * Checks if the plant is still living.
     * 
     * @return if the plant is still alive true otherwise false
     */
    public boolean stillLiving() { 
        return living; 
    }

    /**
     * Provides a string representation of the plant object.
     * 
     * @return a string containing the plant's name, nutrient level (N), and living status
     */
    @Override
    public String toString() {
        return "Plant name: " + name + ", N: " + N + ", Living: " + living;
    }
}
