public class HaystackNeedle {
    public static int strStr(String haystack, String needle) {
        // Special case: if the needle is empty
        if (needle == "") {
            return 0;
        }
        
        // Special case: if the stack and the needle are equal
        if (haystack.equals(needle)) {
            return 0;
        }
        
        
        // Get the lenghts of the stack and neeedle
        int n = haystack.length();
        int m = needle.length();
        
        // In case the needle is greater than the stack
        if (m > n) {
            return -1;
        }
        
        // Convert to character arrays to work easier with them
        char[] letters = haystack.toCharArray();
        char[] nLetters = needle.toCharArray();
        
        for (int i = 0 ; i <= n - m ; ++i) {
            int j = 0;
            int tmpIndex = i;
            while (j < m) {
                if (letters[tmpIndex] != nLetters[j]) {
                    break;
                }
                ++j;
                ++tmpIndex;
            }
            
            if (j == m) {
                return i;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issi"));
    }
}