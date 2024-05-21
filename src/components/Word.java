package src.components;

/**
 * Class that represents a word (16 bits).
 * It provides opereations to get a bit, set a bit and extract bits from a word.
 * 
 */
public class Word {
    short n;

    /**
     * Returns the bit at position i.
     * 
     * @param n word
     * @param i position of the bit
     * @return the bit at position i
     */
    public static short getBit(short n, int i) {
        return (short) ((n >> i) & 1);
    }

    /**
     * Sets the bit at position i to 1.
     * 
     * @param n word
     * @param i position of the bit
     * @return the word with the bit at position i set to 1
     */
    public static short setBit(short n, int i) {
        return (short) (n | (1 << i));
    }

    /**
     * Extracts the bits from startBit to endBit from word "n"
     * 
     * @param n        word with the data
     * @param startBit least significant bit to be extracted
     * @param endBit   most significant bit to be extracted
     * @return the extracted bits: from endBit to startBit (both inclusive)
     */
    public static short extractBits(short n, int startBit, int endBit) {
        int mask = (1 << (endBit - startBit + 1)) - 1;
        return (short) ((n >> startBit) & mask);
    }
}