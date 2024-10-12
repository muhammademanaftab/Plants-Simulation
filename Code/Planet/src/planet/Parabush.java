package planet;

/**
 * Represents a specific type of plant called Parabush, which inherits from the
 * {@link Plant} class. Parabush has its own rules for adjusting its nutrient
 * level (N) based on different types of radiation.
 *---------------Delta class kee tarah haaa jiskay apnay constuctor haa os isay parabush ketay han
 * @author Muhammad Eman Aftab
 */
public class Parabush extends Plant {

    /**
     * Constructs a new Parabush object with the specified name and nutrient
     * level.
     *---------param han 2 jo N or name haaa
     * @param name the name of the Parabush
     * @param N the initial nutrient level of the plant
     */
    public Parabush(String name, int N) {
        super(name, N);
    }

    /**
     * 
     * @return int that tells alpha Need
     */
    @Override
    protected int requireAlphaNeed() {
        return 0;
    }

    /**
     * 
     * @return int that tells delta neeed.
     */
    @Override
    protected int requireDeltaNeed() {
        return 0;
    }

    /**
     * Changes the plant's nutrient level (N) based on the type of radiation it
     * receives.
     *
     * @param radiation the type of radiation affecting the plant (either "no
     * radiation", "alpha", or "delta")
     */
    @Override
    public void changeN(Radiation radiation) {
        if (radiation instanceof No_Radiation) {
            this.N -= 1;
        } else if (radiation instanceof Alpha) {
            this.N += 1;
        } else if (radiation instanceof Delta) {
            this.N += 1;
        }

        living = (this.N > 0);
    }
}
