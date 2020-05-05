import java.util.Stack;

/**
 * ValidParantheses
 */
public class ValidParantheses {

    public static boolean isValid(String s) {

        // Create new empty stack...
        Stack<Character> stack = new Stack<>();

        /**
         * Verify each character on the following basis:
         * 
         * - if it is an opening bracket just add it to
         * the stack.
         * 
         * - else look if the popped item from the stack
         * is the corresponding opening brace for it.
         * --> if it is just carry on ...
         * --> else return false.
         */
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else if (stack.isEmpty()) {
                return false;
            }else if (c == ')') {
                if (stack.pop() != '(') {
                    return false;
                }
            }else if (c == ']'){
                if (stack.pop() != '['){
                    return false;
                }
            }else {
                if (stack.pop() != '{') {
                    return false;
                }
            }
        }

        // We return true only if the stack is empty at the end.
        if (stack.empty()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        
        System.out.println(isValid("()"));
    }
}