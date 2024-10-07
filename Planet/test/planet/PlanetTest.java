/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package planet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Muhammad Eman Aftab
 */
public class PlanetTest {

    @Test
    public void testAddPlant() {
        Planet planet = new Planet();
        planet.addPlant(new Puffs("Piggy", 7));
        planet.addPlant(new DeltaTree("Willowy", 3));
        planet.addPlant(new Parabush("Dumpy", 4));
        System.out.println(planet.plants.get(0));
        System.out.println(planet.plants.get(1));
        System.out.println(planet.plants.get(2));
        assertEquals("Piggy", planet.plants.get(0));
//        for (int i = 0; i < 10; i++) {
//            planet.simulate();
//            for (Plant p : planet.plants) {
//                if (p.living) {
//                    System.out.println(p);
//                }
//            }
//        }

    }

}
