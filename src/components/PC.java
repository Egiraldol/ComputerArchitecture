package src.components;

/**
 * The PC class represents the Program Counter of the computer.
 */
public class PC {
    /*
     * Inputs
     */
    short in;
    short load;
    short inc;
    short reset;

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

    public void setLoad(short load) {
        this.load = load;
    }

    public void setInc(short inc) {
        this.inc = inc;
    }

    public void setReset(short reset) {
        this.reset = reset;
    }

    /*
     * Getter
     */
    public short getOut() {
        return out;
    }

    /*
     * Computes the output of the Program Counter.
     */
    public void compute() {
        if (reset == 1) {
            out = 0;
        } else if (load == 1) {
            out = in;
        } else if (inc == 1) {
            out++;
        }
    }
}
