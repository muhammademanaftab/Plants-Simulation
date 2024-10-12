/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package planet;

/**
 * The {@code Delta} class represents a specific type of radiation, Delta radiation.
 * -------------------- Delta class jo ke radiaiton kee child haa or apna return function ha
 * jo oski type btygaaaa
 * @author Muhammad Eman Aftab
 */
public class Delta extends Radiation {

    /**
     * Default constructor for the {@code Delta} class.
     * 
     */
    public Delta() {
    }
    
    @Override
    public String RadiationType(){
        return "Delta";
    }
}
