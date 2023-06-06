//By Team members: Abrar Alkamajani - Rahaf Albrakati - Ghada Aljuhani - Rahaf Koshak
package GraphFramework;

import java.util.LinkedList;
//represents a graph vertex

public class Vertex {

    String label;
    boolean isVisited;
    LinkedList<Edge> adjList = new LinkedList<Edge>();
    Vertex parent;

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean IsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public LinkedList<Edge> getAdjList() {
        return adjList;
    }

    public void setAdjList(LinkedList<Edge> adjList) {
        this.adjList = adjList;
    }

    public void displayInfo() {
        System.out.printf("%-1s", this.label);
    }
}
