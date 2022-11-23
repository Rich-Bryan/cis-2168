public class Search {
   private boolean[] marked;
   private int count;

   public Search(Graph G, int s) {
      marked = new boolean[G.V()];
      dfs(G, s);
   }

   private void dfs(Graph G, int v) {
      marked[v] = true;
      count++;
      for (int x : G.adj(v))
         if (!marked[x]) dfs(G, x);
   }

   // is the vertex marked?
   public boolean marked(int w) {
      return marked[w];
   }

   //how many vertices are connected to s?
   public int count() { return count; }
}
