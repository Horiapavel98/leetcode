public class LongestCommonPrefix {
    private static String twoStrings(String s1, String s2) {
        
        int n = 0;
        if (s1.length() < s2.length()) {
            n = s1.length();
        }else{
            n = s2.length();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < n ; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return sb.toString();
            }else{
                sb.append(s1.charAt(i));
            }
        }

        return sb.toString();
    }
    
    public static String longestCommonPrefix(String[] strs) {
        String commonString = strs[0];
        for (int i = 1 ; i < strs.length ; ++i) {
            commonString = twoStrings(commonString, strs[i]);
        }

        return commonString;
    }

    public static void main(String[] args) {
        String[] strs = new String[] {
            "flower",
            "flow",
            "flight"
        };

        // System.out.println(twoStrings("flow", "flight"));

        System.out.println(longestCommonPrefix(strs));
    }
}