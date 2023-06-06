//By Team members: Abrar Alkamajani - Rahaf Albrakati - Ghada Aljuhani - Rahaf Koshak
package AirFreightApp;

import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;


public class Map extends Graph {
    int i =0;

    public Map(int verticesNO, int edgesNO, boolean digraph) {
        this.setIsDiagraph(digraph);
        this.setVerticesNo(verticesNO);
        this.setEdgesNo(edgesNO);
    }

    public Map() {
       super();
    }
    // Create Vertex constracter to Ghrph 

    @Override
    public Edge craeteEdge(Vertex source, Vertex target, int weight) {
        return new Route( (Location)source, (Location)target, weight);
    }

   
    
        @Override
        public Vertex createVertex(String lable) {
        Location Loc = new Location(lable);
        Loc.setCity(++i);
        return Loc; 
    }

}
