public class DepthFirstSearch<V> extends Search<V> {

    public DepthFirstSearch(UnweightedGraph<V> graph, V sourceKey) {
        super(graph.getVertex(sourceKey));
        run();
    }

    @Override
    protected void run() {
        dfs(source);
    }

    private void dfs(Vertex<V> current) {
        visited.add(current);
        for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
            if (!visited.contains(neighbor)) {
                edgeTo.put(neighbor, current);
                dfs(neighbor);
            }
        }
    }
}
