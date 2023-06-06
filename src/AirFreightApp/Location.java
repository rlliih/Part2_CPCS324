//By Team members: Abrar Alkamajani - Rahaf Albrakati - Ghada Aljuhani - Rahaf Koshak
package AirFreightApp;

import GraphFramework.Vertex;

public class Location extends Vertex {

    // Data Type 
    // like in UML class Digram
    int city = 0;

    // label is extand from class vertex
    public Location(String labelName) {
        this.setLabel(labelName);
    }

    // Method set and get
    public int getCity() {
        return city;
    }

    public void setCity(int citynum) {
        this.city = citynum;
    }

    // Method Print
    @Override
    public void displayInfo() {
        System.out.print("Loc.");
        super.displayInfo();
        System.out.print(": city " + city + " ");
    }

}
