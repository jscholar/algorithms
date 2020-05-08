/*
    Given a binary tree, return the sum of values of nodes with even-valued grandparent.  
    (A grandparent of a node is the parent of its parent, if it exists.)
*/

public class Solution {
    public int SumEvenGrandparent(TreeNode root) {
        int sum = 0;
        
        // traverse and remember the evenness of relevant ancesters
        void dfs(TreeNode node, bool parentEven, bool grandparentEven) {
            if (node == null) {
                return;
            }
            if (grandparentEven) {
                sum += node.val;
            }
            dfs(node.left, node.val % 2 == 0, parentEven);
            dfs(node.right, node.val % 2 == 0, parentEven);
        }
        
        dfs(root, false, false);
        
        return sum;

    }
    
}