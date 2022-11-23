public class PathsClient {
   public static void main(String[] args) {
      In data = new In("tinyCG.txt");
      Graph G = new Graph(data);
      int s = 0;
      Paths search = new Paths(G, s);
      // the Graph and one of its vertices
      for (int v = 0; v < G.V(); v++){
         System.out.print(s + " to " + v + ": ");
         if (search.hasPathTo(v))
            for (int x : search.pathTo(v))
               if (x == s) System.out.print(x);
               else System.out.print("-" + x);
         System.out.println();
      }
   }
}
