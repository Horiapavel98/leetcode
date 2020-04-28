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
        int[] toReturn = new int[nums.length/2];
        if (nums.length % 2 != 0) {
                
            for (int i = 1 ; i <= nums.length/2 ; ++i) {
                toReturn[i - 1] = nums[nums.length/2 + i];
            }
        }
        else {
            
            for (int i = 1 ; i < nums.length/2 ; ++i) {
                toReturn[i - 1] = nums[nums.length/2 + i];
            }
        }
        return toReturn;
    }

    private static void recurse(TreeNode node, int[] nums) {
        // split left
        int[] left = getLeft(nums);
        // split right
        int[] right = getRight(nums);

        node = new TreeNode(nums[nums.length/2]);

        recurse(node.left, left);
        recurse(node.right, right);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        TreeNode root = null;
        recurse(root, nums);

        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-10, -3, 0, 5, 9};
        sortedArrayToBST(arr);
    }
}