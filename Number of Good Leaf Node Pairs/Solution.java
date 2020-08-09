class Solution {
    int pairs;
    public int countPairs(TreeNode root, int distance) {
        pairs = 0;
        distances(root, distance);
        return pairs;
    }
    
    private int[] distances(TreeNode node, int distance) {
        int[] nodeDistances = new int[distance + 1];
        if (node == null) {
            return nodeDistances;
        }
        if (node.left == null && node.right == null) {
            nodeDistances[1] = 1;
        } else {
            int[] left = distances(node.left, distance);
            int[] right = distances(node.right, distance);
            for (int i = 1; i < left.length; i++) {
                for (int j = 1; j < right.length; j++) {
                    if (i + j <= distance) {
                        pairs += left[i] * right[j];
                    }
                }
            }
            for (int i = 1; i < nodeDistances.length; i++) {
                nodeDistances[i] = left[i - 1] + right[i - 1];
            }
        }
        
        return nodeDistances;

    }
}