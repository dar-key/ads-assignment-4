import java.util.*;

public abstract class Search<V> {
    protected Vertex<V> source;
    protected Set<Vertex<V>> visited = new HashSet<>();
    protected Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();

    public Search(Vertex<V> source) {
        this.source = source;
    }

    public Iterable<V> pathTo(V targetKey) {
        Vertex<V> target = null;
        for (Vertex<V> v : visited) {
            if (v.getData().equals(targetKey)) {
                target = v;
                break;
            }
        }

        if (target == null)
            return Collections.emptyList();

        LinkedList<V> path = new LinkedList<>();
        Vertex<V> current = target;

        while (!current.equals(source)) {
            path.addFirst(current.getData());
            current = edgeTo.get(current);
        }
        path.addFirst(source.getData());
        return path;
    }

    protected abstract void run();
}
