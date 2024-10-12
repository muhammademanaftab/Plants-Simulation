package planet;

/**
 * Represents a specific type of plant called DeltaTree, which inherits from the
 * {@link Plant} class. DeltaTree has its own specific rules for how its
 * nutrient level (N) changes based on the type of radiation it encounters.
 *------------ woh class jo plants se extend horhi haaa .
 * @author Muhammad Eman Aftab
 */
public class DeltaTree extends Plant {

    /**
     * Constructs a new DeltaTree object with the specified name and nutrient
     * level.
     *---------params btanay ke liayaaa
     * @param name the name of the DeltaTree
     * @param N the initial nutrient level of the plant
     */
    public DeltaTree(String name, int N) {
        super(name, N);
    }

    @Override
    protected int requireAlphaNeed() {
        return 0; 
    }

    @Override
    protected int requireDeltaNeed() {
        if (this.N < 5) {
            return 4;  
        } else if (this.N >= 5 && this.N <= 10) {
            return 1;  
        }
        return 0;  
    }   

    /**
     * Changes the plant's nutrient level (N) based on the type of radiation it
     * receives. After the nutrient level is updated, the plant is considered
     * living if its nutrient level is greater than 0.
     *----agar nutrient 0 se barhay huway to plant living haaaaa.
     * @param radiation the type of radiation affecting the plant (either "no
     * radiation", "alpha",or "delta")
     */
    @Override
    public void changeN(Radiation radiation) {
        if (radiation instanceof No_Radiation) {
            this.N -= 1;
        } else if (radiation instanceof Alpha) {
            this.N -= 3;
        } else if (radiation instanceof Delta) {
            this.N += 4;
        }
        living = (this.N > 0);
    }
}
