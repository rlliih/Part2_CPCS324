//By Team members: Abrar Alkamajani - Rahaf Albrakati - Ghada Aljuhani - Rahaf Koshak
package GraphFramework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//structure of a graph
public abstract class Graph {

    int verticesNo; //num of vert 
    int edgesNo; // num of edge
    boolean isDiagraph = false; // 0 undirect 1 direct
    ArrayList<Vertex> vertices = new ArrayList<>();

    public int getVerticesNo() {
        return verticesNo;
    }

    public void setVerticesNo(int verticesNo) {
        this.verticesNo = verticesNo;
    }

    public int getEdgesNo() {
        return edgesNo;
    }

    public void setEdgesNo(int edgesNo) {
        this.edgesNo = edgesNo;
    }

    public boolean isIsDiagraph() {
        return isDiagraph;
    }

    public void setIsDiagraph(boolean isDiagraph) {
        this.isDiagraph = isDiagraph;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    /*reads the edges and vertices from the text file whose name is specified 
    by the parameter filename and place data in a Graph object. In this project, 
    you need to create a text file that contains the graph presented in requirement 1. 
    The file format is shown in Appendix II. It is responsible for doing some 
    preprocessing then call the addEdge() method to determine the position of the Edge.*/
    public void readGraphFromFile(File filename) throws FileNotFoundException {

        //Declear & Creat Scanner 
        Scanner read = new Scanner(filename);
        read.next();
        isDiagraph = (read.nextInt() == 1);
        while (read.hasNext()) {
//            verticesNo = read.nextInt();
//            edgesNo = read.nextInt();
            String sourceString = read.next();
            String targetString = read.next();
            int weight = read.nextInt();
            Vertex sourceVer = addVertex(sourceString);
            Vertex targetVer = addVertex(targetString);
            addEdge(sourceVer, targetVer, weight);
        }

        read.close();
    }

    public abstract Edge craeteEdge(Vertex source, Vertex target, int weight);

    /*
    addEdge(v,u,w): is a function that creates an edge object and passes the source 
    vertex v, the target vertex and w the vertex weight as parameters, 
    assigns the target vertex to the adjacent list of the source vertex 
    and if the graph is undirected then it will 
    add the source vertex to the adjacent list of the target vertex. 
    It increments the EdgeNo by one in case it is a directed 
    graph and by two if it is an undirected graph.
     */
    public void addEdge(Vertex source, Vertex target, int weight) {
        Edge edge = craeteEdge(source, target, weight);
        source.getAdjList().add(edge);
        if (!isDiagraph) {
            edgesNo = edgesNo + 2;
            target.getAdjList().add(edge);
        } else {
            edgesNo++;
        }
    }

    public abstract Vertex createVertex(String label);

    public Vertex addVertex(String data) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getLabel().equals(data)) {
                return vertices.get(i);
            }
        }
        Vertex ver = createVertex(data);
        vertices.add(ver);
        verticesNo++;
        return ver;
    }


    /*this function takes as parameters the number of vertices and the number 
    of edges. It is responsible for creating a graph object with the specified
    parameters and randomly initializes the vertices’ labels, creating edges 
    that connects the created vertices randomly and assigning them random weights.
    Make sure that the resulting graph is connected.*/
    public void makeGraph(int numOfVertices, int numOfEdges) {

        for (int i = 1; i <= numOfVertices; i++) {
            addVertex("O" + i);
        }

        Random random = new Random();
        while (numOfEdges > 0) {
            int i = random.nextInt(numOfVertices);
            int j = random.nextInt(numOfVertices);
            if (i != j && !areAdjacent(vertices.get(i), vertices.get(j))) {
                int randomWeight = random.nextInt(10000) + 1;
                addEdge(vertices.get(i), vertices.get(j), randomWeight);
                numOfEdges--;
            }
        }

    }

    public boolean areAdjacent(Vertex u, Vertex v) {
        boolean isAdj = false;
        boolean isAdj2 = false;
        for (Edge e : u.getAdjList()) {
            if (e.getTarget() == v) {
                isAdj = true;
            }
        }

        for (Edge e : v.getAdjList()) {
            if (e.getTarget() == u) {
                isAdj2 = true;
            }
        }

        return (isAdj || isAdj2);
    }

}
