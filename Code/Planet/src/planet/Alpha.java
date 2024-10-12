/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package planet;

/**
 * The {@code Alpha} class represents a specific type of radiation, Alpha radiation.
 * -----------Alpha class ha jo ke radiaiton kee child haa or iskaa apna constructor waagira 
 * b haa or radiaition type ka method ha
 * @author Muhammad Eman Aftab
 */
public class Alpha extends Radiation {

    /**
     * Default constructor for the {@code Alpha} class. 
     */
    public Alpha() {
    }
    
    @Override
    public String RadiationType(){
        return "Alpha";
    }
}

