package src.components;

public class mux16 {
    // Inputs
    short[] a = new short[16];
    short[] b = new short[16];
    short sel;

    // Output
    short[] out = new short[16];

    // Setters
    public void setA(short[] a) {
        this.a = a;
    }

    public void setB(short[] b) {
        this.b = b;
    }

    public void setSel(short sel) {
        this.sel = sel;
    }

    // Getter
    public short[] getOut() {
        return out;
    }

    // Computes the output of the MUX16 gate.
    public void compute() {
        for (int i = 0; i < 16; i++) {
            out[i] = (short) ((a[i] & ~sel) | (b[i] & sel));
        }
    }
}
