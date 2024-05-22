/**
 * The And class represents an AND gate.
 */
public class and {
    /**
     * Inputs
     */
    short a;
    short b;

    /**
     * Output
     */
    short out;

    /**
     * Setters
     */
    public void setA(short a) {
        this.a = a;
    }

    public void setB(short b) {
        this.b = b;
    }

    /**
     * Getter
     */
    public short getOut() {
        return out;
    }

    /**
     * Computes the output of the AND gate.
     */
    public void compute() {
        out = (short) (a & b);
    }
}
