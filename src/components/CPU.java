package src.components;

/**
 * The CPU class represents the Central Processing Unit of the computer.
 */
public class CPU {

    private ALU alu;
    private Register registerA;
    private Register registerD;
    private PC pc;
    private Mux16 mux16;

    // Inputs
    private short inM;
    private short instruction;
    private boolean reset;

    // Outputs
    private short outM;
    private boolean writeM;
    private short addressM;
    private short pcOut;

    // Internal control signals
    private boolean isCInstruction;
    private boolean isAInstruction;
    private boolean loadA;
    private boolean loadD;
    private short writeMInternal;

    // ALU outputs
    private short outALU;
    private boolean isZeroOut;
    private boolean isNegOut;

    /**
     * Constructor for the CPU.
     */
    public CPU() {
        this.alu = new ALU();
        this.registerA = new Register();
        this.registerD = new Register();
        this.pc = new PC();
        this.mux16 = new Mux16();
    }

    /**
     * Executes the inputted instruction according to the Hack machine language
     * specification.
     *
     * @param inM         the value from memory (M = contents of RAM[A])
     * @param instruction the instruction to be executed
     * @param reset       signal to restart the program (reset == 1)
     */
    public void execute(short inM, short instruction, boolean reset) {
        this.inM = inM;
        this.instruction = instruction;
        this.reset = reset;

        decodeInstruction();
        executeInstruction();
    }

    private void decodeInstruction() {
        // Decoding whether it's a C-instruction or A-instruction
        isCInstruction = (Word.getBit(instruction, 15) == 1);
        isAInstruction = !isCInstruction;
    }

    private void executeInstruction() {
        if (isAInstruction) {
            registerA.setIn(instruction);
            loadA = true;
            registerA.load(loadA);
        } else {
            executeCInstruction();
        }

        // Update the PC
        updatePC();
    }

    private void executeCInstruction() {
        // Determine destination
        boolean destToA = (Word.getBit(instruction, 5) == 1);
        boolean destToD = (Word.getBit(instruction, 4) == 1);
        writeM = (Word.getBit(instruction, 3) == 1);

        // Select A or M as the ALU input using Mux16
        mux16.setA(registerA.getOut());
        mux16.setB(inM);
        mux16.setSel(Word.getBit(instruction, 12));
        mux16.compute();
        short y = mux16.getOut();

        // Execute the ALU operation
        alu.compute(registerD.getOut(), y, Word.getBit(instruction, 11), Word.getBit(instruction, 10),
                Word.getBit(instruction, 9),
                Word.getBit(instruction, 8), Word.getBit(instruction, 7), Word.getBit(instruction, 6));
        outALU = alu.getOut();
        isZeroOut = (alu.getZr() == 1 ? true : false);
        isNegOut = (alu.getNg() == 1 ? true : false);
        ;

        // Write to the registers based on the destination bits
        if (destToA) {
            registerA.setIn(outALU);
            loadA = true;
            registerA.load(loadA);
        }

        if (destToD) {
            registerD.setIn(outALU);
            loadD = true;
            registerD.load(loadD);
        }

        // Set outputs
        if (writeM) {
            outM = outALU;
            addressM = registerA.getOut();
            writeMInternal = (short) 1;
        } else {
            writeMInternal = (short) 0;
        }
    }

    private void updatePC() {
        boolean jumpToA = false;

        // Determine jump conditions
        boolean jgt = (isNegOut == false) && (isZeroOut == false) && (Word.getBit(instruction, 0) == 1);
        boolean jeq = (isZeroOut == true) && (Word.getBit(instruction, 1) == 1);
        boolean jlt = (isNegOut == true) && (Word.getBit(instruction, 2) == 1);

        if (jgt || jeq || jlt) {
            jumpToA = true;
        }

        // Update the PC register
        pc.setReset((short) (reset ? 1 : 0));
        pc.setLoad((short) (isCInstruction && jumpToA ? 1 : 0));
        pc.setIn(registerA.getOut());
        pc.setInc((short) (!(isCInstruction && jumpToA) ? 1 : 0));
        pc.compute();

        pcOut = pc.getOut();
    }

    /**
     * Gets the output to be written to memory (M).
     *
     * @return the output value for M
     */
    public short getOutM() {
        return outM;
    }

    /**
     * Checks if the CPU should write to memory.
     *
     * @return true if the CPU should write to memory, false otherwise
     */
    public short getWriteM() {
        return (short) writeMInternal;
    }

    /**
     * Gets the address in data memory (of M).
     *
     * @return the address in data memory
     */
    public short getAddressM() {
        return (short) addressM;
    }

    /**
     * Gets the address of the next instruction.
     *
     * @return the program counter value
     */
    public short getPC() {
        return pcOut;
    }
}