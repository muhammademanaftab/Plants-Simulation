package planet;

/**
 * Represents a specific type of plant known as Puffs, which inherits from the
 * {@link Plant} class. Puffs have specific behaviors when exposed to different
 * types of radiation that affect their nutrient.
 *
 * @author Muhammad Eman Aftab
 */
public class Puffs extends Plant {

    /**
     * Constructs a new Puffs object with the specified name and nutrient level.
     * The initial alpha nutrient need is calculated as 10 minus the given
     * nutrient level.
     *------yeh class similar to parabush haa
     * @param name the name of the plant
     * @param N the initial nutrient level of the plant
     */
    public Puffs(String name, int N) {
        super(name, N);
    }
/**
 * 
 * @return int according to alpha need
 * 
 * -----iska alphaa need bakioh se change haaaa 
 */
    @Override
    protected int requireAlphaNeed() {
        return 10 - this.N;  // Alpha need is based on how much the nutrients less then 10
    }

    @Override
    protected int requireDeltaNeed() {
        return 0;  // Puffs doesn't need delta radiation
    }

    /**
     * Changes the plant's nutrient level (N) based on the type of radiation it
     * receives. After the nutrient level is updated, the plant is considered
     * living only if its nutrient level is greater than 10.
     *
     * @param radiation the type of radiation affecting the plant (either "no
     * radiation", "alpha",or "delta")
     */
    @Override
    public void changeN(Radiation radiation) {
        if (radiation instanceof No_Radiation) {
            this.N -= 1;
        } else if (radiation instanceof Alpha) {
            this.N += 2;
        } else if (radiation instanceof Delta) {
            this.N -= 2;
        }

        living = (this.N < 10 && this.N > 0);
    }
}
