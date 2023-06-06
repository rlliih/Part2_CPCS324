//By Team members: Abrar Alkamajani - Rahaf Albrakati - Ghada Aljuhani - Rahaf Koshak
package GraphFramework;

import java.util.ArrayList;
//MHPrimAlg is a subclass of MSTAlgorithm

public class MHPrimAlg extends MSTAlgorithm {

    public MHPrimAlg(Graph graph) {
        this.graph = graph;
        this.MSTResultList = new Edge[graph.getVerticesNo() - 1];
    }

    @Override
    public void displayResultingMST() {
        int totalWeight = 0;
        System.out.println("Minimum Spanning Tree:");
        for (Edge e : MSTResultList) {
            if (e != null) {
                totalWeight += e.getWeight();
                System.out.printf("Office No. %s - Office No. %s : line length: %d\n", e.getSource().getLabel(),
                        e.getTarget().getLabel(), e.getWeight() * 5);
            }
        }
        System.out.println("The cost of designed phone network: " + totalWeight);
    }

    public void applyAlgorithm(Vertex startVer) {
        Vertex startVertex = startVer;
        if (startVertex == null) {
            System.out.println("Invalid start vertex.");
            return;
        }

        ArrayList<Vertex> unvisitedVertices = new ArrayList<>();
        for (Vertex v : graph.getVertices()) {
            if (!v.IsVisited()) {
                unvisitedVertices.add(v);
            }
        }

        MinHeap heap = new MinHeap();
        startVertex.setIsVisited(true);
        for (Edge e : startVertex.getAdjList()) {
            heap.insert(e);
        }

        int i = 0;
        while (!heap.isEmpty() && i < graph.getVerticesNo() - 1) {
            Edge minEdge = heap.extractMin();
            Vertex nextVertex = minEdge.getTarget();
            if (!nextVertex.IsVisited()) {
                nextVertex.setIsVisited(true);
                MSTResultList[i++] = minEdge;
                for (Edge e : nextVertex.getAdjList()) {
                    if (!e.getTarget().IsVisited()) {
                        heap.insert(e);
                    }
                }
            }
        }
    }

}
