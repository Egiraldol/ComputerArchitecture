package src.components;

public class Register {
    // Inputs
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

    // Computes the output of the Register.
    public void load(boolean load) {
        if (load) {
            out = in;
        }
    }
}
