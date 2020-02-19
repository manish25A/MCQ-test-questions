package Assignment;
import java.util.LinkedList;

public class DirectedGraph_Qn12 {

    int oneSideofGraph;
    LinkedList<Integer> adjacencyListArray[];


    DirectedGraph_Qn12(int oneSideofGraph) {
        this.oneSideofGraph = oneSideofGraph;
        adjacencyListArray = new LinkedList[oneSideofGraph];

        for (int i = 0; i < oneSideofGraph; i++) {
            adjacencyListArray[i] = new LinkedList<Integer>();
        }
    }

    public static void main(String args[]) {
        int oneSideofGraph = 5;
        DirectedGraph_Qn12 DirectedGraph = new DirectedGraph_Qn12(oneSideofGraph);
        addSide(DirectedGraph, 0, 1);
        addSide(DirectedGraph, 0, 2);
        addSide(DirectedGraph, 0, 3);
        addSide(DirectedGraph, 0, 4);
        addSide(DirectedGraph, 1, 2);
        addSide(DirectedGraph, 1, 3);
        addSide(DirectedGraph, 1, 4);
        addSide(DirectedGraph, 2, 3);
        addSide(DirectedGraph, 3, 4);
        printDirectedGraph(DirectedGraph);
    }

    static void addSide(DirectedGraph_Qn12 DirectedGraph, int src, int dest) {

        DirectedGraph.adjacencyListArray[src].add(dest);

    }


    static void printDirectedGraph(DirectedGraph_Qn12 DirectedGraph) {
        for (int oneSideofGraph = 0; oneSideofGraph < DirectedGraph.oneSideofGraph; oneSideofGraph++) {
            System.out.println("Vertex Number " + oneSideofGraph);
            System.out.print("value");
            for (Integer Values : DirectedGraph.adjacencyListArray[oneSideofGraph]) {
                System.out.print(" -> " + Values);
            }
            System.out.println("\n");
        }
    }
}
