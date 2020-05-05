import java.util.*;

/**
 * PascalsTriangle
 */
public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {

        if (numRows == 0) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0 ; i < numRows ; ++i) {
            triangle.add(new ArrayList<>());
        }

        triangle.get(0).add(1);

        if (numRows == 1) {
            return triangle;
        }

        triangle.get(1).add(1);
        triangle.get(1).add(1);

        if (numRows == 2) {
            return triangle;
        }

        // Doing the real thing now ...

        for (int i = 3 ; i <= numRows; ++i) {
            triangle.get(i - 1).add(1);
            // Seek how many items are in the middle
            for (int j = 0 ; j < i - 2 ; ++j) {
                int upLeft = triangle.get(i - 2).get(j);;
                int upRight = triangle.get(i - 2).get(j + 1);
                
                triangle.get(i - 1).add(upLeft + upRight);
            }
            triangle.get(i - 1).add(1);
        }

        return triangle;
    }

    public static void main(String[] args) {
        
        System.out.println(generate(10));
    }
}