/* Example code from "Algorithms" by Robert Sedgewick and Thomas Wayne 
   to illustrate the implemention of undirected graphs */

import java.util.ArrayList;

public class Graph
{
    private final int numVertices;
    private int numEdges;
    private ArrayList<ArrayList<Integer>> adjacencyList;

    // Create a v-vertex graph with no edges
    public Graph(int v)
    {
        numVertices = v;
        adjacencyList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < numVertices; i++)
            adjacencyList.add(new ArrayList<Integer>());
    }

    public int getNumVertices()
    {
        return numVertices;
    }

    public int getNumEdges()
    {
        return numEdges;
    }
    public void addEdge(int v, int w)
    {
        adjacencyList.get(v).add(w);
        adjacencyList.get(w).add(v);
        numEdges++;
    }

    public Iterable<Integer> adjacent(int v)
    {
        return adjacencyList.get(v);
    }

    public String toString()
    {
        String s = numVertices + " vertices, " + numEdges + " edges\n";
        for (int v = 0; v < numVertices; v++)
        {
            s += v + ": ";
            for (int adjVertex : adjacencyList.get(v))
                s += adjVertex + " ";
            s += "\n";
        }
        return s;
    }

    // Compute the degree of vertex, v, in a graph, g
    public static int degree(Graph g, int v)
    {
        int degree = 0;
        for (Integer adjVertex : g.adjacent(v))
            degree++;
        return degree;
    }

    // Compute the max degree in a graph
    public static int maxDegree(Graph g)
    {
        int max = 0;
        for (int v = 0; v < g.getNumVertices(); v++)
        {
            if (degree(g, v) > max)
                max = degree(g, v);
        }
        return max;
    }

    // Compute the average degree of the vertices in a graph
    public static int avgDegree(Graph g)
    {
        return 2 * g.getNumEdges() / g.getNumVertices();
    }

    // Compute the number of self-loops in a graph
    public static int numSelfLoops(Graph g)
    {   
        int count = 0;
        for (int v = 0; v < g.getNumVertices(); v++)
        {
            for (int w : g.adjacent(v))
                if (v == w)
                    count++;
        }
        return count;
    }

    public static void main(String[] args)
    {
        Graph g = new Graph(3);
        g.addEdge(1, 2);
        g.addEdge(0, 1);
        g.addEdge(2, 0);

        System.out.println("Max degree: " + maxDegree(g));
        System.out.println("Average degree: " + avgDegree(g));
        System.out.println("Connections:\n" + g);
    }
}