//By Team members: Abrar Alkamajani - Rahaf Albrakati - Ghada Aljuhani - Rahaf Koshak
package GraphFramework;

import GraphFramework.Graph;

import java.util.Iterator;

public class SingleSourceSPAlg {

    // Data Fields
    int[] distance;
    String[] path;
    Graph mygraph;

    int infinity = Integer.MAX_VALUE;

    public SingleSourceSPAlg(Graph graph) {
        this.mygraph = graph;
    }

    public void computeDijkstraAlg(Graph graph) {

        distance = new int[graph.vertices.size()];
        path = new String[graph.vertices.size()];

        for (int i = 0; i < graph.vertices.size(); i++) {
            distance[i] = infinity;
        }

        distance[0] = 0;
        Vertex src = graph.vertices.get(0).adjList.get(0).source;
        path[0] = src.label;

        // Loop Through the array
        for (int i = 0; i < graph.vertices.size() - 1; i++) {
            int up = minDistance(distance);
            graph.vertices.get(up).isVisited = true;

            Iterator<Edge> iterate = graph.vertices.get(up).adjList.iterator();

            while (iterate.hasNext()) {
                Edge edge = iterate.next();

                if (edge.target.isVisited != true && edge.weight != infinity && edge.weight != 0) {
                    if (distance[up] + edge.weight < distance[graph.vertices.indexOf(edge.target)]) {
                        distance[graph.vertices.indexOf(edge.target)] = distance[up] + edge.weight;
                        path[graph.vertices.indexOf(edge.target)] = path[up] + " – " + edge.target.label;
                    }
                }
            }
        }
    }

    public int minDistance(int[] smallestDistance) {
        int up = 0;
        int minDistance = Integer.MAX_VALUE;

        // Loop through all vertices
        for (int i = 0; i < mygraph.vertices.size(); i++) {
            // The vertex must be not visited and its less than the minimum distance
            if (mygraph.vertices.get(i).isVisited != true && smallestDistance[i] < minDistance) {
                minDistance = smallestDistance[i]; // The new minimum distance
                up = i; // Minimum vertex index
            }
        }
        return up;
    }

    public void printResult() {
        String routerName = (mygraph.vertices.get(0).label);
        System.out.println("The starting point location is " + routerName);
        System.out.println("\nThe routes from location " + routerName + " to the rest of the locations are: ");

        for (int i = 0; i < mygraph.verticesNo - 1; i++) {
            //System.out.printf("loc. %s - Office No. %s : line length: %d\n", e.getSource().getLabel(),

            System.out.println("loc. " + path[i] + ": city " + distance[i]
                    + "-loc. " + path[i] + ": city " + distance[i]);
        } // End of for loop
    } // End of method

}
