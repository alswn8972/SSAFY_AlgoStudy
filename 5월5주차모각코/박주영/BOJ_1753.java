import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
    static class Edge implements Comparable<Edge>{
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight,o.weight);
        }
    }
    static int V, E, K;
    static ArrayList<Edge>[] adj;
    static int[] dij;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        adj = new ArrayList[V+1];
        dij = new int[V+1];
        for(int i = 1; i<=V; i++){
            adj[i] = new ArrayList<>();
            dij[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Edge(v,w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        check = new boolean[V+1];
        pq.add(new Edge(K, 0));
        dij[K] = 0;
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(check[cur.to])continue;
            check[cur.to] = true;
            for(Edge next: adj[cur.to]){
                if(dij[next.to] > dij[cur.to]+next.weight){
                    dij[next.to] = dij[cur.to]+next.weight;
                    pq.offer(new Edge(next.to, dij[next.to]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=V; i++){
            if(dij[i]==Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else sb.append(dij[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
