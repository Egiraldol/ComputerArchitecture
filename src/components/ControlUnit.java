/**
 * The ControlUnit class represents the control unit of the computer.
 */
public class ControlUnit {
    /**
 * Inputs
 */
    short in;
    short instruction;
    boolean reset;

    /**
* Setters 
*/
    public void setIn(short in) {
        this.in = in;
    }

    public void setInstruction(short instruction) {
        this.instruction = instruction;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    public static void main(String [] args) {
        ControlUnit cu = new ControlUnit();
        ROM rom = new ROM();
        CPU cpu = new CPU();
        RAM ram = new RAM();

        for (short i = 0; i < 4; i++) {
            short instruction = rom.get(cpu.pcOut);
            cpu.execute(ram.getOut(), instruction, cu.reset);

            System.out.println("Instruction: " + Integer.toBinaryString(instruction & 0xFFFF));
            System.out.println("Register A: " + cpu.registerA.getOut());
            System.out.println("Register D: " + cpu.registerD.getOut());
            System.out.println("PC: " + cpu.getPC());
        }
    }

}
