import java.util.*;
import java.util.LinkedList;

/**
 * MinStack
 */
public class MinStack {

    private LinkedList<Integer> stack;
    private LinkedList<Integer> aux;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<Integer>();
        aux = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        aux.push(x);
        Collections.sort(aux);
    }
    

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int toRemove = stack.pop();
        aux.removeFirstOccurrence(toRemove);
    }
    
    /**
     * Look at the top of the stack
     */
    public int top() {
        return stack.peek();
    }
    
    /**
     * Return the minimum element in the stack
     * @return
     */
    public int getMin() {
        return aux.getFirst();
    }

    public static void main(String[] args) {
        
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }

}