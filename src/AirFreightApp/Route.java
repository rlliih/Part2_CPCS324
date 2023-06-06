//By Team members: Abrar Alkamajani - Rahaf Albrakati - Ghada Aljuhani - Rahaf Koshak
package AirFreightApp;

import GraphFramework.Edge;
import GraphFramework.Vertex;

// This class only havae a costracter and Display info 
// is Extandextend from athur Pakge GraphFramework
public class Route extends Edge {

    public Route(Location sourceCode, Location targetCode, int weight) {
        this.setSource(sourceCode);
        this.setTarget(targetCode);
        this.setWeight(weight);
    }

    // Method print
    @Override
    public void displayInfo() {
        System.out.print(" --- route length: ");
        super.displayInfo();
    }

}
