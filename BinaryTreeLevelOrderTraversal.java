import java.util.List;
import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    private static int recurse(TreeNode node, int height) {
        if (node == null) {
            return height;
        }
        if (node.left == null && node.right == null) {
            return height;
        }
        return Math.max(recurse(node.left, height + 1), recurse(node.right, height + 1));
    }

    private static void treeTraversalFillingList(TreeNode node, int level, List<List<Integer>> listOfLists) {
        listOfLists.get(level).add(node.val);
        if (node.left != null) {
            treeTraversalFillingList(node.left, level + 1, listOfLists);
        }
        if (node.right != null) {
            treeTraversalFillingList(node.right, level + 1, listOfLists);
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        int treeHeight = recurse(root, 0);

        List<List<Integer>> listOfLists = new ArrayList<>();
        for (int i = 0 ; i <= treeHeight ; ++i) {
            listOfLists.add(new ArrayList<>());
        }

        treeTraversalFillingList(root, 0, listOfLists);

        return listOfLists;
    }
    
    public static void main(String[] args) {
        
        /**
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);
        */

        TreeNode t2 = new TreeNode(1);
        t2.right = new TreeNode(2);

        System.out.println(recurse(t2, 0));
        System.out.println(levelOrder(t2));
    }
}