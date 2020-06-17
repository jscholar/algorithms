class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> paths = new ArrayList();
        dfs(graph, 0, new LinkedList(), paths);
        
        return paths;
    }
    
    public void dfs(int[][] graph, int node, LinkedList<Integer> currentPath, List<List<Integer>> paths) {
        currentPath.add(node);
        
        if (node == graph.length - 1) {
            paths.add(new LinkedList(currentPath));
        } else {
            for (int next : graph[node]) {
                dfs(graph, next, currentPath, paths);
            }
        }
        
        currentPath.removeLast();
    }
}