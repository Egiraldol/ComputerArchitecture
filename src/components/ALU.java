package src.components;

/**
 * The ALU class represents an Arithmetic Logic Unit.
 */
public class ALU {
    // Inputs
    short x;
    short y;

    // Control bits
    short zx;
    short nx;
    short zy;
    short ny;
    short f;
    short no;

    // Outputs
    short out;
    short zr;
    short ng;

    /**
     * Computes the output of the ALU.
     */
    public void compute() {
        short x1 = (short) (zx == 1 ? 0 : x); // Zero the x input
        short x2 = (short) (nx == 1 ? ~x1 : x1); // Negate the x input
        short y1 = (short) (zy == 1 ? 0 : y); // Zero the y input
        short y2 = (short) (ny == 1 ? ~y1 : y1); // Negate the y input

        short out1 = (short) (f == 1 ? x2 + y2 : x2 & y2); // Perform the operation
        out = (short) (no == 1 ? ~out1 : out1); // Negate the output

        zr = (short) (out == 0 ? 1 : 0); // Set the zero flag
        ng = (short) (Word.getBit(out, 15) == 1 ? 1 : 0); // Set the negative flag
    }
}
