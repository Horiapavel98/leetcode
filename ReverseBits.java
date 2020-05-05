/**
 * ReverseBits
 */
public class ReverseBits {

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        // 4294967293
        // 11111111111111111111111111111101
        // Reverse: 3221225471 
        // 10111111111111111111111111111111

        for (int i = 0 ; i < 16 ; ++i) {
            int leftBit = (n >> i) & 1;
            int rightBit = (n >> (31 - i)) & 1;

            if (leftBit == 0 && rightBit == 1) {
                n |= 1 << i;
                n &= ~(1 << (31 - i));
            }else if (leftBit == 1 && rightBit == 0) {
                n &= ~(1 << i);
                n |= 1 << (31 - i);
            }else{
                // carry on ..
            }
        }

        return n;
    }

    public static void main(String[] args) {
        
        System.out.println(reverseBits(-3));
    }
}