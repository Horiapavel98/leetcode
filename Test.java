import java.util.ArrayList;

public class Test {
    private int x;

    public Test() {
        x = 42;
    }

    private static int fnc(int n, int k) {
        if (k == 0) {
            return 1;
        }
        if (n < k) {
            return 0;
        }
        else {
            return fnc(n-1, k-1) + fnc(n-1, k);
        }
    }

    public static void main(String[] args) {
        System.out.println(fnc(4,2));
    }
}