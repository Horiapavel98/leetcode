/**
 * CountPrimes
 */
public class CountPrimes {

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        
        for (int i = 3 ; i * i <= n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int countPrimes(int n) {
        int count = 0;

        for (int i = 0 ; i < n ; ++i) {
            if (isPrime(i)){
                ++count;
            }
        }

        return count;
    }

    public static int countPrimesEratostenes(int n) {
        // Initializing sieve
        boolean[] sieve = new boolean[n];
        // Setting all values to true
        for (int i = 2 ; i < n; ++i) {
            sieve[i] = true;
        }

        for (int i = 2 ; i * i < n ; ++i) {
            if (sieve[i]){
                for (int j = i * i ; j < n ; j += i) {
                    sieve[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean b : sieve) {
            if (b) {
                ++count;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        
        long start = System.currentTimeMillis();
        countPrimes(1500000);
        System.out.println(System.currentTimeMillis() - start);
    }
}