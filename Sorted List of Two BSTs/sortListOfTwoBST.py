class Solution:
    
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:

        def inOrderDFS(node, arr):
            if node:
                inOrderDFS(node.left, arr);
                arr.append(node.val);
                inOrderDFS(node.right, arr);

        res1 = [];
        res2 = [];
        
        inOrderDFS(root1, res1);
        inOrderDFS(root2, res2);
        
        merged = [];
        index1 = index2 = 0;

        while (index1 < len(res1) and index2 < len(res2)):
            if (res1[index1] < res2[index2]):
                merged.append(res1[index1]);
                index1 += 1;
            else:
                merged.append(res2[index2]);
                index2 += 1;
                
        merged += res1[index1:];
        merged += res2[index2:];
                
        return merged;
