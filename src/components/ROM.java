public class ROM {
    private short[] memory = new short[64000];

    public ROM(){
        memory[0] = (short)0x0002;
        memory[1] = (short)0xEC10;
        memory[2] = (short)0x0003;
        memory[3] = (short)0xE090;
    }

    public short get(int address){
        return memory[address];
    }
}
