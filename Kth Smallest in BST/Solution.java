class Solution {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        
        int curr = 0;
        
        while (true) {            
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            
            curr += 1;
            
            if (curr == k) {
                return root.val;
            }
            root = root.right;
        }

    }
}