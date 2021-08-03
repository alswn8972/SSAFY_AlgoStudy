import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5972 {
    static int N, M;
    static List<Node>[] map;
    static boolean[] visited;
    static class Node implements Comparable<Node> {
        int d;
        int cost;

        public Node(int d, int cost) {
            this.d = d;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new ArrayList[N+1];
        for(int i = 0; i<N+1; i++)
            map[i] = new ArrayList<>();
        for(int i = 1; i<=M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Node(b,c));
            map[b].add(new Node(a,c));
        }

        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        visited = new boolean[N+1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(!visited[cur.d])
                visited[cur.d] = true;
            else continue;

            for(Node next: map[cur.d]){
                if(distance[next.d] > distance[cur.d] + next.cost){
                    distance[next.d] = distance[cur.d] + next.cost;
                    pq.offer(new Node(next.d, distance[next.d]));
                }
            }
        }
        System.out.println(distance[N]);
    }
}
