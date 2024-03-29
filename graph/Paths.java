public class Paths {
   private boolean[] marked; // has the vertex been visited?
   private int[] edgeTo;     // last vertex on path to this vertex
   private final int s;      // source

   public Paths(Graph G, int s) {
      marked = new boolean[G.V()];
      edgeTo = new int[G.V()];
      this.s = s;
      dfs(G, s);
   }

   private void dfs(Graph G, int v) {
      marked[v] = true;
      for (int w : G.adj(v))
         if (!marked[w]) {
            edgeTo[w] = v;
            dfs(G, w);
         }
   }

   public boolean hasPathTo(int v) { return marked[v]; }

   public Iterable<Integer> pathTo(int v) {
      if (!hasPathTo(v)) return null;
      Stack<Integer> path = new Stack<>();
      for (int x = v; x != s; x=edgeTo[x])
         path.push(x);
      path.push(s);
      return path;
   }

}
