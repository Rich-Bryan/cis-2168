import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Graph {

   private final int V;  // number of vertices in this graph
   private int E;        // number of edges in this graph
   private ArrayList<Integer>[] adj; // V adjacency lists (one for each vertex)

   // Constructor. Initializes a graph from the specified input stream.
   // The format is the number of vertices V,
   // followed by the number of edges E,
   // followed by E pairs of vertices, with each entry separated by whitespace.
   public Graph(In in) {
      if (in == null) throw new IllegalArgumentException("null graph data");
      this.V = in.readInt();
      adj = new ArrayList[V];
      for (int v = 0; v < V; v++)
         adj[v] = new ArrayList();

      int E = in.readInt();
      for (int i = 0; i < E; i++) {
         int v = in.readInt();
         int w = in.readInt();
         addEdge(v, w);
      }
   }

   // Returns the number of vertices in this graph.
   public int V() { return V; }

   // Returns the number of edges in this graph.
   public int E() { return E; }

   // Adds the undirected edge v-w to this graph.
   public void addEdge(int v, int w) {
      E++;
      adj[v].add(w);
      adj[w].add(v);
   }

   // Returns the vertices adjacent to vertex v.
   public Iterable<Integer> adj(int v) { return adj[v]; }

   // Returns the degree of vertex v.
   public int degree(int v) { return adj[v].size(); }

   // Returns a string representation of this graph.
   // (the number of vertices V, followed by the number of edges E.)
   public String toString() {
      StringBuilder s = new StringBuilder();
      s.append(V + " vertices, " + E + " edges \n");
      for (int v = 0; v < V; v++) {
         s.append(v + ": ");
         for (int w : adj[v])
            s.append(w + " ");
         s.append("\n");
      }
      return s.toString();
   }

   // Tests the Graph data type.
   public static void main(String[] args) {
      Graph G = new Graph(new In("tinyG.txt"));
      System.out.println(G);
   }
}
