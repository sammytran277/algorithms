/* Example code from "Algorithms" by Robert Sedgewick and Thomas Wayne 
   to illustrate how to find a path from a source node to a destination */

import java.util.Stack;

public class DepthFirstPaths
{
    private boolean[] marked;
    private int[] edgeTo;
    private final int source;

    public DepthFirstPaths(Graph g, int s)
    {
        marked = new boolean[g.getNumVertices()];
        edgeTo = new int[g.getNumVertices()];
        source = s;
        dfs(g, source);
    }

    private void dfs(Graph g, int v)
    {
        marked[v] = true;
        for (int w : g.adjacent(v))
            if (!marked[w])
            {
                edgeTo[w] = v;
                dfs(g, w);
            }
    }

    public boolean hasPathTo(int v)
    {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v)
    {
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != source; x = edgeTo[x])
            path.push(x);
        path.push(source);
        return path;
    }
}