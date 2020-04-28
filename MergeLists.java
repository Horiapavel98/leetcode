import java.util.List;
import java.util.ArrayList;

public class MergeLists {
  
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> toArray = new ArrayList<>();
        while(head != null){
            toArray.add(head.val);
            head = head.next;
        }
        
        int n = toArray.size();
        
        for (int i = 0; i < n/2 ; ++i) {
            int first = toArray.get(i);
            int second = toArray.get(n - i - 1);
            if ( first != second ) {
                return false;
            }
        }
        
        return true;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = null;
        
        if (l1.val > l2.val) {
            newList = new ListNode(l2.val);
            l2 = l2.next;
        }else if (l2.val > l1.val) {
            newList = new ListNode(l1.val);    
            l1 = l1.next;
        }else {
            newList = new ListNode(l1.val);
            newList.next = new ListNode(l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        
        ListNode current = null;
        if (newList.next == null) {
            current = newList;
        }else{
            current = newList.next;
        }
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = new ListNode(l1.val);
                current = current.next;
                l1 = l1.next;
            }else if (l1.val > l2.val) {
                current.next = new ListNode(l2.val);
                current = current.next;
                l2 = l2.next;
            }else{
                current.next = new ListNode(l1.val);
                current = current.next;
                current.next = new ListNode(l2.val);
                current = current.next;
                l1 = l1.next; l2 = l2.next;
            }
        }
        
        return newList;
    }
 
    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        
        boolean isNegative = false;
        boolean alreadySigned = false;

        boolean alreadyComputing = false;
        
        long number = 0;
        
        long max_value = (long) Integer.MAX_VALUE;
        long min_value = (long) Integer.MIN_VALUE;
        
        for (char c : chars) {
            if (Character.isDigit(c)) {
                number = number*10 + Character.getNumericValue(c);
                alreadyComputing = true;
            }else if (c == '-') {
                isNegative = true;
                if (!alreadySigned) {
                    alreadySigned = true;
                }else{
                    return 0;
                }
            }else if (c == '+') {
                if(!alreadySigned) {
                    alreadySigned = true;
                }else {
                    return 0;
                }
            }else if (c != ' ') {
                if(isNegative) {
                    number = -number;
                    if (number < min_value) {
                        return Integer.MIN_VALUE;
                    }else{
                        return (int) number;
                    }
                }else{
                    if (number > max_value) {
                        return Integer.MAX_VALUE;
                    }else{
                        return (int) number;
                    }
                }
            } else if (alreadyComputing) {
                return 0;
            }
        }

        if(isNegative) {
                    number = -number;
                    if (number < min_value) {
                        return Integer.MIN_VALUE;
                    }else{
                        return (int) number;
                    }
                }else{
                    if (number > max_value) {
                        return Integer.MAX_VALUE;
                    }else{
                return (int) number;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(myAtoi(" +0 123"));
    }
}