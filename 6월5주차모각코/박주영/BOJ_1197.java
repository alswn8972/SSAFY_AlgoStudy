import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197 {
    static int V, E;
    static class Node implements Comparable<Node>{
        int v1, v2, weight;

        public Node(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static int[] parent;
    static int find(int a){
        if(parent[a] == a)return a;
        return parent[a] = find(parent[a]);
    }
    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b)return false;

        parent[b] = a;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V+1];
        for(int i = 1; i<V+1; i++){
            parent[i] = i;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine()," ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Node(v1, v2, w));
        }

        int minSum = 0;
        for(int i = 0; i<E; i++){
            Node cur = pq.poll();
            if(union(cur.v1, cur.v2)){
                minSum += cur.weight;
            }
        }
        System.out.println(minSum);
    }
}
