//By Team members: Abrar Alkamajani - Rahaf Albrakati - Ghada Aljuhani - Rahaf Koshak
package AirFreightApp;

import GraphFramework.SingleSourceSPAlg;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AirFreightApp {

    public static void main(String[] args) throws FileNotFoundException {
        //Main 
        Scanner input = new Scanner(System.in);

        // Intilize variables
        int verticesNO = 0; // number of vertices
        int edgesNO = 0; // number of edges
        boolean isDigraph = false;

        System.out.println("\t\t_________________________________________________________________________\n\n"
                + "\t\t Implement Dijkstra algorithm for the single-source shortest path problem  \n"
                + "\t\t_________________________________________________________________________\n");

        System.out.println("\t\t----------  (1) Requirement 1 Using Read_from_Graph Func. ---------- \n"
                + "\t\t----------  (2) Requirement 2 Using Make_Graph Func.      ---------- \n");

        // Read User Input for the Selected Requirement  
        System.out.print("Select Requirement Option: ");

        int userInput = input.nextInt(); // Option of the Requirement

        // make sure user enter within option
        while (userInput != 1 && userInput != 2) {
            System.out.println("Wrong Selection. ");
            System.out.print("Select Requirement Option -> ");
            userInput = input.nextInt();
        }

        //  Requirement 1  
        if (userInput == 1) {
            System.out.println("\n\t\t\t-Requirement 1 Using Read From Graph function-");

            File graphFile = new File("graph.txt"); // Read from File
            Map netT = new Map(verticesNO, edgesNO, isDigraph); // Create An Object of Graph as networkTopology
            netT.readGraphFromFile(graphFile); // Access readGraphFromFile Method in Graph Class

            SingleSourceSPAlg dijkstra = new SingleSourceSPAlg(netT);
            dijkstra.computeDijkstraAlg(netT); // Read Graph in Dijkstra Algorithm
            dijkstra.printResult(); // Print path list and router length

        } // End of Requirement 1

        //  Requirement 2  
        if (userInput == 2) {
            System.out.println("\n\t\t\t-Requirement 2 Using Make Graph function-");
            System.out.print("\nDo you want the graph directed (yes/no)? "); // Ask user if he/she want to do the
            // algorithm with direct graph
            String choiceDigraph = input.next();

            // FOR WRONG INPUT
            while (!choiceDigraph.equalsIgnoreCase("yes") && !choiceDigraph.equalsIgnoreCase("no")) {
                System.out.println("\n Invalid input! ");
                System.out.print("-- Enter your choice : ");
                choiceDigraph = input.next();
            }
            // If the user answer was yes make directed graph
            if (choiceDigraph.equalsIgnoreCase("yes")) {
                isDigraph = true;
            }

            System.out.println("\n 1:  n=2000 , m=10000");
            System.out.println(" 2:  n=3000 , m=15000");
            System.out.println(" 3:  n=4000 , m=20000");
            System.out.println(" 4:  n=5000 , m=25000");
            System.out.println(" 5:  n=6000 , m=30000");

            System.out.print("\nSelect your Test Option -> ");
            userInput = input.nextInt(); // Option of the Case

            while (userInput > 5 || userInput < 1) {
                System.out.println("Option not found.");
                System.out.print("Select your Test Option: ");
                userInput = input.nextInt();
            } // End of while

            switch (userInput) {
                case 1: {
                    verticesNO = 2000;
                    edgesNO = 10000;
                }
                ;
                break;

                case 2: {
                    verticesNO = 3000;
                    edgesNO = 15000;
                }
                ;
                break;
                case 3: {
                    verticesNO = 4000;
                    edgesNO = 20000;
                }
                ;
                break;
                case 4: {
                    verticesNO = 5000;
                    edgesNO = 25000;
                }
                ;
                break;
                case 5: {
                    verticesNO = 6000;
                    edgesNO = 30000;
                }
                break;
            }

            Map networkTopology;
            networkTopology = new Map(verticesNO, edgesNO, isDigraph);
            networkTopology.makeGraph(verticesNO, edgesNO);
            SingleSourceSPAlg dijkstra = new SingleSourceSPAlg(networkTopology);
            long startTime = System.currentTimeMillis();
            dijkstra.computeDijkstraAlg(networkTopology);
            long finishTime = System.currentTimeMillis();

            System.out.println("Run time for Dijkstra algorithm " + (finishTime - startTime) + " ms \n");

        }
        input.close();
    }
}
