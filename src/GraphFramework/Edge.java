//By Team members: Abrar Alkamajani - Rahaf Albrakati - Ghada Aljuhani - Rahaf Koshak
package GraphFramework;

//represents a graph edge
public class Edge {

    Vertex source;
    Vertex target;
    int weight;
    Vertex parent;

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getTarget() {
        return target;
    }

    public void setTarget(Vertex target) {
        this.target = target;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    Edge brev;

    public Edge getBrev() {
        return brev;
    }

    public void setBrev(Edge brev) {
        this.brev = brev;
    }

    public void displayInfo() {
        System.out.printf("%-5s", this.weight);

    }

}
