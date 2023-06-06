//By Team members: Abrar Alkamajani - Rahaf Albrakati - Ghada Aljuhani - Rahaf Koshak
package GraphFramework;

import java.util.*;

public class DBAllSourceSPAlg extends ShortestPathAlgorithm {

    Graph graph;
    ArrayList<ArrayList<Edge>> DBAllResult = new ArrayList<ArrayList<Edge>>();

    public DBAllSourceSPAlg(Graph graph) {

        super();
    }

    @Override
    void computeDijkstraAlg(Graph graph) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Edge craeteEdge(Vertex source, Vertex target, int weight) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vertex createVertex(String label) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void print(Edge e) {
        if (e.getBrev() == null) {
            e.getSource().displayInfo();
            System.out.print("- ");
            e.getTarget().displayInfo();
        } else {
            print(e.getBrev());
            System.out.print("- ");
            e.getTarget().displayInfo();
        }
    }

    //use it 
    public void displayResult() {
        Edge p;
        String s = "";
        ArrayList<Edge> result;
        for (int i = 0; i < DBAllResult.size() - 1; i++) {
            result = DBAllResult.get(i);
            System.out.println("The starting point location is " + DBAllResult.get(i).get(i).getSource().label + "\n"
                    + "The routes from location " + DBAllResult.get(i).get(i + 1).getSource().label + " to the rest of the locations are:");
            for (int j = 0; j < result.size(); j++) {
                print(result.get(j));
                result.get(j).displayInfo();
                System.out.println("");
            }
            System.out.println("\n---------------------------------------------------------------------------------------\n");
        }
        // end of displayResult
    }
}
