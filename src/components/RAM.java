public class RAM {
    
    private short[] memory = new short[64000];
    private short out;

    public void get(int address){
        out = memory[address];
    }

    public short getOut(){
        return out;
    }

    public void set(int address, short value){
        memory[address]=value;
    }
}
