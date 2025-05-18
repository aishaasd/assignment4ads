# Graph Algorithms: BFS and Dijkstra Implementation

This Java project implements **Breadth-First Search (BFS)** and **Dijkstra's Algorithm** for an edge-weighted graph using custom `Vertex` objects (instead of raw edges).

## Description

The assignment required creating a graph representation where each vertex holds a map of its adjacent vertices along with the weight of the edge between them. Two search algorithms were implemented:

* **Breadth-First Search (BFS)** — for unweighted path discovery.
* **Dijkstra’s Algorithm** — for shortest path discovery in a weighted graph.

All algorithms work based on the following class structure:

* `Vertex<V>`
* `WeightedGraph<V>`
* `Search<V>` (interface)
* `BreadthFirstSearch<V>`
* `DijkstraSearch<V>`
* `Main` — for testing and usage example.

## Technologies Used

* Java 8+
* No external libraries used (standard library only)

## Project Structure

```
src/
│
├── Vertex.java
├── WeightedGraph.java
├── Search.java
├── BreadthFirstSearch.java
├── DijkstraSearch.java
└── Main.java
```

## Example Output

Running `Main.java`:

```
BFS Path to Z: [A, C, D, Z]
Dijkstra Path to Z: [A, C, B, D, E, Z]
```

## How to Run

1. Clone the repository
2. Compile all `.java` files:

   ```bash
   javac *.java
   ```
3. Run the `Main` class:

   ```bash
   java Main
   ```

