import java.util.*;
import java.util.jar.JarOutputStream;

public class Dijkstra {
    // Node(vertex, distance)
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        //initialization
        //setting the dist to infinity
        int[] dist = new int[adj.length];
        PriorityQueue<Integer> PQ = new PriorityQueue<>(adj.length); // contain all vertices
        //setting all the vertices to -1
        Arrays.fill(dist, -1);


        //the starting vertex is 0
        dist[s] = 0;
        System.out.println("original: "+ Arrays.toString(dist));
        //System.out.println(PQ.size());

        //check if one vertex does not have and adj vertices
        System.out.println("adjency: "+ adj[s]);
        if(adj[s].isEmpty()) {
            return -1;
        }else if(adj[s] == adj[t]){
            return 0;
        }

        PQ.add(s);
        while(!PQ.isEmpty()){
            int u = PQ.remove();
            int i = 0;
            for(int v : adj[u]){ //v as each adj vertex
                int newDist = dist[u] + cost[u].get(i);
                if(dist[v] > newDist || dist[v] == -1) {
                    dist[v] = newDist;
                    System.out.println("dist[v]: "+dist[v]);
                    PQ.add(v);
                }
                i++;
            }
        }
        
        System.out.println("after dist: "+Arrays.toString(dist));

        return dist[t];


    }

    public static void main(String[] args) {
        In in = new In("G4-1.txt");
        int n = in.readInt();
        int m = in.readInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = in.readInt();
            y = in.readInt();
            w = in.readInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = in.readInt() - 1;
        int y = in.readInt() - 1;

        System.out.println("adj: "+ Arrays.toString(adj));
        System.out.println("cost: " + Arrays.toString(cost));
        System.out.println(distance(adj, cost, x, y));
    }
}