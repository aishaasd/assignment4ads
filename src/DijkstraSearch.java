import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private final Map<V, V> edgeTo = new HashMap<>();
    private final Map<V, Double> distTo = new HashMap<>();
    private final PriorityQueue<Vertex<V>> pq;
    private final V start;

    public DijkstraSearch(WeightedGraph<V> graph, V start) {
        this.start = start;

        Comparator<Vertex<V>> comparator = Comparator.comparingDouble(v -> distTo.get(v.getData()));
        pq = new PriorityQueue<>(comparator);

        for (Vertex<V> v : graph.getAllVertices()) {
            distTo.put(v.getData(), Double.POSITIVE_INFINITY);
        }

        distTo.put(start, 0.0);
        pq.add(graph.getVertex(start));

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();
            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                V neighborData = neighbor.getData();
                double newDist = distTo.get(current.getData()) + weight;

                if (newDist < distTo.get(neighborData)) {
                    distTo.put(neighborData, newDist);
                    edgeTo.put(neighborData, current.getData());
                    pq.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<V> getPath(V target) {
        if (!distTo.containsKey(target)) return null;
        LinkedList<V> path = new LinkedList<>();
        for (V at = target; at != null && !at.equals(start); at = edgeTo.get(at)) {
            path.addFirst(at);
        }
        if (!path.isEmpty()) {
            path.addFirst(start);
        }
        return path;
    }
}

