//By Team members: Abrar Alkamajani - Rahaf Albrakati - Ghada Aljuhani - Rahaf Koshak
package GraphFramework;
//This class is a superclass that represents the general characteristics of an algorithm used for computing the MST. 
//It has two subclasses: KruskalAlg and MHPrimAlg.

public abstract class MSTAlgorithm {

    Edge[] MSTResultList;// list of objects of the type Edge. 
    //It stores the parent of the vertex and the weight needed by the MST algorithm.

    Graph graph;

    abstract void displayResultingMST();
}
