import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private final Map<V, V> edgeTo = new HashMap<>();
    private final Set<V> visited = new HashSet<>();
    private final V start;

    public BreadthFirstSearch(WeightedGraph<V> graph, V start) {
        this.start = start;
        bfs(graph, start);
    }

    private void bfs(WeightedGraph<V> graph, V current) {
        Queue<V> queue = new LinkedList<>();
        queue.add(current);
        visited.add(current);

        while (!queue.isEmpty()) {
            V v = queue.poll();
            Vertex<V> vertex = graph.getVertex(v);

            for (Vertex<V> neighbor : vertex.getAdjacentVertices().keySet()) {
                V neighborData = neighbor.getData();
                if (!visited.contains(neighborData)) {
                    visited.add(neighborData);
                    edgeTo.put(neighborData, v);
                    queue.add(neighborData);
                }
            }
        }
    }

    @Override
    public List<V> getPath(V target) {
        if (!visited.contains(target)) return null;
        LinkedList<V> path = new LinkedList<>();
        for (V x = target; !x.equals(start); x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(start);
        return path;
    }
}

