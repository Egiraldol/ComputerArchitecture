package src.components;

/**
 * The Xor class represents an XOR gate.
 */
public class Xor {
    /*
     * Inputs
     */

    short a;
    short b;

    /*
     * Output
     */
    short out;

    /*
     * Setters
     */
    public void setA(short a) {
        this.a = a;
    }

    public void setB(short b) {
        this.b = b;
    }

    /*
     * Getter
     */
    public short getOut() {
        return out;
    }

    /*
     * Computes the output of the XOR gate.
     */
    public void compute() {
        out = (short) (a ^ b);
    }
}
