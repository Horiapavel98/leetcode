/**
 * NumberOf1Bits
 */
public class NumberOf1Bits {

    private static int getBit(int position, int n) {
        return (n >> position) & 1;
    }

    public static int hammingWeight(int n) {
        // Integer : -3
        // 32bit   : 11111111111111111111111111111101
        int count = 0;
        for (int i = 31 ; i >= 0;  --i) {
            if (getBit(i, n) == 1) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        

    }
}