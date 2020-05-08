/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {

    /*
        We'll use a breadth first approach to this problem
        since we can be sure to only record the deepest leaves
        when the deepest level is reached
    */
    public int DeepestLeavesSum(TreeNode root) {
        List<TreeNode> level = new List<TreeNode>{root};
        var lowest = false;

        while (!lowest) {
            List<TreeNode> nextLevel = new List<TreeNode>();
            foreach (TreeNode node in level) {
                if (node.left != null) {
                    nextLevel.Add(node.left);
                }
                if (node.right != null) {
                    nextLevel.Add(node.right);
                }
            }
            if (nextLevel.Count == 0) {
                lowest = true;
            } else {
                level = nextLevel;
            }
        }

        int sum = 0;
        foreach (TreeNode node in level) {
            sum += node.val;
        }

        return sum;
    }
}