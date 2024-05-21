package src.components;

public class not {
    // Input
    short in;

    // Output
    short out;

    // Setter
    public void setIn(short in) {
        this.in = in;
    }

    // Getter
    public short getOut() {
        return out;
    }

    // Computes the output of the NOT gate.
    public void compute() {
        out = (short) ~in;
    }
}