const goodNodes = (root) => {
  let goodNodes = 0;
  
  const dfs = (node, greatest) => {
    if (node === null) {
      return;
    }
    
    if (greatest <= node.val) {
      goodNodes++;
    }
    
    dfs(node.left, Math.max(node.val, greatest));
    dfs(node.right, Math.max(node.val, greatest));
    
  }
  
  dfs(root, root.val);
  
  return goodNodes;
}
