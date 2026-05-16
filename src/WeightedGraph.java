import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private final boolean directed;
    private final Map<V, Vertex<V>> vertices = new HashMap<>();

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    public void addEdge(V sourceData, V destData, double weight) {
        vertices.putIfAbsent(sourceData, new Vertex<>(sourceData));
        vertices.putIfAbsent(destData, new Vertex<>(destData));

        Vertex<V> source = vertices.get(sourceData);
        Vertex<V> dest = vertices.get(destData);

        source.addAdjacentVertex(dest, weight);

        if (!directed) {
            dest.addAdjacentVertex(source, weight);
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Map<V, Vertex<V>> getVertices() {
        return vertices;
    }
}
