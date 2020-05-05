/**
 * HammingDistance
 */
public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int count = 0;
        int xor = x ^ y;
        for (int i = 0 ; i < 32 ; ++i) {
            if (((xor >> i) & 1) == 1) {
                ++count;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        
        System.out.println(hammingDistance(1, 4));
    }
}