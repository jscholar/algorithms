const criticalConnections = (n, connections) => {
    // Build adjacency list
    let adj = [];
    for (let i = 0; i < connections.length; i++) {
        adj[i] = [];
    }
    for (let [a, b] of connections) {
        adj[a].push(b);
        adj[b].push(a);
    }
    const depthSeen = [];
    const criticals = [];

    // Returns the earliest node already encountered
    const dfs = (node, depth, previousNode) => {
        if (depthSeen[node] === undefined) {
            depthSeen[node] = depth;
            let earliest = depth;
            for (let nextNode of adj[node]) {
                if (nextNode === previousNode) continue;
                const earliestFromNextNode = dfs(nextNode, depth + 1, node);
                if (earliestFromNextNode > depth) {
                    criticals.push([node, nextNode]);
                }
                earliest = Math.min(earliest, earliestFromNextNode);
            }

            depthSeen[node] = earliest;
        }

        return depthSeen[node];
    }

    dfs(0, 0);
    return criticals;
}