/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package planet;

/**
 * The {@code Radiation} class serves as an abstract base class 
 * representing different types of radiation.
 * 
 * @author Muhammad Eman Aftab
 */
public abstract class Radiation {

    /**
     * Default constructor for the {@code Radiation} class.
     *
     */
    public Radiation() {
    }
        
    /**
     * 
     * @return String abstract function that every class implements its own.
     */
    public abstract String RadiationType();
}
