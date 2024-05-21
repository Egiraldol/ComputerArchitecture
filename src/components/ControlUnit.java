package src.components;

/**
 * The ControlUnit class represents the control unit of the computer.
 */
public class ControlUnit {
    // Inputs
    short in;
    short instruction;
    short reset;

    // Outputs
    short outM;
    short writeM;
    short addressM;
    short pc;

    // Setters
    public void setIn(short in) {
        this.in = in;
    }

    public void setInstruction(short instruction) {
        this.instruction = instruction;
    }

    public void setReset(short reset) {
        this.reset = reset;
    }

    // Getters
    public short getOutM() {
        return outM;
    }

    public short getWriteM() {
        return writeM;
    }

    public short getAddressM() {
        return addressM;
    }

    public short getPc() {
        return pc;
    }

}
