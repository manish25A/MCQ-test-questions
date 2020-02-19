package Assignment;

import java.util.Iterator;
import java.util.LinkedList;

public class UndirectedGraphwithBFS_Qn11 {


    private int V;   // No. of vertices
    private LinkedList<Integer> adj[];


    public UndirectedGraphwithBFS_Qn11(int sides) {
        V = sides;
        adj = new LinkedList[sides];
        for (int i = 0; i < sides; ++i)
            adj[i] = new LinkedList();
    }

    void bfs(int s) {
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();


        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {

            s = queue.poll();
            System.out.print(s + " ");


            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void addside(int numofedg, int widthOfUndGraph) {
        adj[numofedg].add(widthOfUndGraph);
    }

    public static void main(String args[]) {
        UndirectedGraphwithBFS_Qn11 g = new UndirectedGraphwithBFS_Qn11(5);

        g.addside(0, 1);
        g.addside(0, 3);
        g.addside(1, 4);
        g.addside(0, 1);
        g.addside(3, 2);
        g.addside(4, 5);

        System.out.println("This is Breadth First Traversal " +
                "which is starting from vertex 2.");

        g.bfs(2);
    }
}
