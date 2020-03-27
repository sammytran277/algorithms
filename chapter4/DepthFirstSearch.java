/* Example code from "Algorithms" by Robert Sedgewick and Thomas Wayne 
   to illustrate the implemention of depth-first search */

public class DepthFirstSearch
{
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int source)
    {
        marked = new boolean[g.getNumVertices()];
        dfs(g, source);
    }

    public void dfs(Graph g, int source)
    {
        marked[source] = true;
        count++;
        for (int adjVertex : g.adjacent(source))
            if (!marked[adjVertex])
                dfs(g, adjVertex);
    }

    public boolean marked(int v)
    {
        return marked[v];
    }

    public int count()
    {
        return count;
    }
}