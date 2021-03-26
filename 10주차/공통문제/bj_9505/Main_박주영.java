import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_박주영 {
    static int[][] map;
    static int K,W,H;
    static HashMap<Character, Integer> clingons;
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    static class Node implements Comparable<Node>{
        int val, x, y;

        public Node(int x, int y,int val) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }
    static Node start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            // input
            st = new StringTokenizer(br.readLine(), " ");
            K = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            clingons = new HashMap<>();
            for(int i = 0; i<K; i++){
                st = new StringTokenizer(br.readLine(), " ");
                char key = st.nextToken().charAt(0);
                int val = Integer.parseInt(st.nextToken());
                clingons.put(key, val);
            }

            map = new int[H][W];
            for(int i = 0; i<H; i++){
                String tmp = br.readLine();
                for(int j = 0; j<W; j++){
                    char now = tmp.charAt(j);
                    if(now == 'E'){
                        map[i][j] = 0;
                        start = new Node(i,j,0);
                        continue;
                    }
                    for(Character c: clingons.keySet()){
                        if(c==now) {
                            map[i][j] = clingons.get(c);
                            break;
                        }
                    }
                }
            }

            // Priority Queue bfs
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(start);

            boolean[][] v = new boolean[H][W];
            v[start.x][start.y] = true;

            int sum = 0;

            a: while(!pq.isEmpty()){
                Node cur = pq.poll();
                if(cur.x==0 || cur.y==0 ||cur.x==H-1 || cur.y ==W-1){
                    sum = cur.val;
                    break;
                }
                for(int d = 0; d<4; d++){
                    int ni = cur.x+dx[d];
                    int nj = cur.y+dy[d];
                    if(ni<0||nj<0||ni>=H||nj>=W) continue;
                    if(v[ni][nj]) continue;

                    v[ni][nj] = true;
                    pq.offer(new Node(ni, nj, cur.val+map[ni][nj]));
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }

}
