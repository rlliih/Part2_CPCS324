//By Team members: Abrar Alkamajani - Rahaf Albrakati - Ghada Aljuhani - Rahaf Koshak
package GraphFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//KruskalAlg is a subclass of MSTAlgorithm
public class KruskalAlg extends MSTAlgorithm {

    public KruskalAlg(Graph graph) {
        this.graph = graph;
        this.MSTResultList = new Edge[graph.getVerticesNo() - 1];
    }

    @Override
    public void displayResultingMST() {

        int totalWeight = 0;
        System.out.println("Minimum Spanning Tree (Kruskal's Algorithm):");
        for (Edge e : MSTResultList) {
            if (e != null) {
                totalWeight += e.getWeight();
                System.out.printf("Office No. %s - Office No. %s : line length: %d\n", e.getSource().getLabel(),
                        e.getTarget().getLabel(), e.getWeight() * 5);
            }
        }
        System.out.println("The cost of designed phone network: " + totalWeight);
    }

    public void applyAlgorithm() {
        int i = 0;
        DisjointSet disjointSet = new DisjointSet(graph.getVerticesNo());
        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<Vertex> vertices = graph.getVertices();
        for (Vertex v : vertices) {
            for (Edge e : v.getAdjList()) {
                edges.add(e);
            }
        }
        Edge[] edgeArray = edges.toArray(new Edge[0]);
        Arrays.sort(edgeArray, Comparator.comparingInt(Edge::getWeight));
        for (Edge e : edgeArray) {
            Vertex source = e.getSource();
            Vertex target = e.getTarget();
            int set1 = disjointSet.find(getVertexIndex(vertices, source));
            int set2 = disjointSet.find(getVertexIndex(vertices, target));
            if (set1 != set2) {
                disjointSet.union(set1, set2);
                MSTResultList[i++] = e;
            }
        }
    }

    private int getVertexIndex(ArrayList<Vertex> vertices, Vertex v) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).equals(v)) {
                return i;
            }
        }
        return -1;
    }

    private static class DisjointSet {

        private int[] parent;
        private int[] rank;

        public DisjointSet(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }
}
