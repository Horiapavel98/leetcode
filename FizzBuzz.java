import java.util.*;

/**
 * FizzBuzz
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1 ; i <= 15 ; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            }else if (i % 3 == 0) {
                result.add("Fizz");
            }else if (i % 5 == 0) {
                result.add("Buzz");
            }else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
        System.out.println((new FizzBuzz()).fizzBuzz(15));
    }
}