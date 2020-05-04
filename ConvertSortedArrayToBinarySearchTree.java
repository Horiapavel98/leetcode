/**
 * ConvertSortedArrayToBinarySearchTree
 */
public class ConvertSortedArrayToBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    private static int[] getLeft(int[] nums) {
        int[] toReturn = new int[nums.length/2];
        for (int i = 0 ; i < nums.length/2 ; ++i) {
            toReturn[i] = nums[i];
        }
        return toReturn;
    }

    private static int[] getRight(int[] nums) {
        if (nums.length % 2 != 0) {
            int[] toReturn = new int[nums.length/2];
            for (int i = 1 ; i <= nums.length/2 ; ++i) {
                toReturn[i - 1] = nums[nums.length/2 + i];
            }
            
            return toReturn;
        }
        else {
            int[] toReturn = new int[nums.length/2 - 1];
            for (int i = 1 ; i < nums.length/2 ; ++i) {
                toReturn[i - 1] = nums[nums.length/2 + i];
            }
            
            return toReturn;
        }
    }

    private static void recurse(TreeNode node, int[] nums) {
        if (nums.length == 3){
            node.left = new TreeNode(nums[0]);
            node.right = new TreeNode(nums[2]);
            return;
        }else if (nums.length == 2) {
            node.left = new TreeNode(nums[0]);
            return;
        }else {
            // split left
            int[] left = getLeft(nums);
            // split right
            int[] right = getRight(nums);
            
            if (left.length != 0) {
                node.left = new TreeNode(left[left.length/2]);
                recurse(node.left, left);
            }

            if (right.length != 0) {
                node.right = new TreeNode(right[right.length/2]);
                recurse(node.right, right);
            }
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(nums[nums.length/2]);
        
        if (nums.length == 1) {
            return root;
        }else { 
            recurse(root, nums);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-1, 0, 1, 2};
        TreeNode root = sortedArrayToBST(arr);

        System.out.println("Done..");
    }
}