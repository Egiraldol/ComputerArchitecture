package src.components;

public class mux {
    // Inputs
    short a;
    short b;
    short sel;

    // Output
    short out;

    // Setters
    public void setA(short a) {
        this.a = a;
    }

    public void setB(short b) {
        this.b = b;
    }

    public void setSel(short sel) {
        this.sel = sel;
    }

    // Getter
    public short getOut() {
        return out;
    }

    // Computes the output of the MUX gate.
    public void compute() {
        out = (short) ((a & ~sel) | (b & sel));
    }
}
