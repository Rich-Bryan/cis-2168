public class SearchClient {
   public static void main(String[] args) {
      In data = new In("tinyCG.txt");
      Graph G = new Graph(data);           // create a Graph object
      Search search = new Search(G, 0); // create a Search object, passing it
                                           // the Graph and one of its vertices
      for (int v = 0; v < G.V(); v++)
         if (search.marked(v))
            System.out.print(v + " ");  // print vertices connected to the source
      System.out.println();

      // is the graph connected?
      if (search.count() != G.V())
         System.out.print("not ");
      System.out.println("connected");
   }
}
