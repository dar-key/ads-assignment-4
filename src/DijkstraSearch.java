import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Double> distTo = new HashMap<>();

    public DijkstraSearch(WeightedGraph<V> graph, V sourceKey) {
        super(graph.getVertex(sourceKey));
        run();
    }

    @Override
    protected void run() {
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(
                Comparator.comparingDouble(v -> distTo.getOrDefault(v, Double.MAX_VALUE)));

        distTo.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();
            visited.add(current);

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();

                if (visited.contains(neighbor))
                    continue;

                double newDist = distTo.getOrDefault(current, Double.MAX_VALUE) + weight;
                if (newDist < distTo.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distTo.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }
}
