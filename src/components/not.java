package src.components;

/**
 * The Not class represents a NOT gate.
 */
public class Not {
    /*
     * Input
     */
    short in;

    /*
     * Output
     */
    short out;

    /*
     * Setters
     */
    public void setIn(short in) {
        this.in = in;
    }

    /*
     * Getter
     */
    public short getOut() {
        return out;
    }

    /*
     * Computes the output of the NOT gate.
     */
    public void compute() {
        out = (short) ~in;
    }
}