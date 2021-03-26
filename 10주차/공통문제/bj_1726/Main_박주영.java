import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1726 {
    static class Pos implements Comparable<Pos>{
        int x,y;
        int dir;
        int move;
        public Pos(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
        public Pos(int x, int y, int dir, int move) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.move = move;
        }

        @Override
        public int compareTo(Pos o) {
            return this.move-o.move;
        }
    }
    static int N,M;
    static int[][] map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int[] dx = { 0, 0, 1, -1}; // 동(1) 서(2) 남(3)  북(4)
    static int[] dy = { 1,-1, 0,  0};
    static int v[][][];

    public static void main(String[] args) throws IOException {st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //출발지 도착지
        Pos start = makePos();
        Pos end = makePos();

        PriorityQueue<Pos> pq = new PriorityQueue<>();
        v = new int[M][N][5];
        pq.offer(start);
        v[start.x][start.y][start.dir] = 1;

        int move = 0;
        while(!pq.isEmpty()){
            Pos cur = pq.poll();
            if(cur.x== end.x && cur.y == end.y && cur.dir == end.dir){
                move = cur.move;
                break;
            }

            int ni = -1, nj = -1;
            // Go k
            for(int k = 1; k<=3; k++){
                ni = cur.x + (dx[cur.dir]*k);
                nj = cur.y + (dy[cur.dir]*k);
                if(ni<0||nj<0||ni>=M||nj>=N||v[ni][nj][cur.dir]>0)continue;
                if(map[ni][nj] == 1) break;
                v[ni][nj][cur.dir]++;
                pq.offer(new Pos(ni, nj, cur.dir, cur.move+1));
            }

            // Turn dir (left/right)
            if(cur.dir<2) {//동 서일떄{
                if(v[cur.x][cur.y][2]==0) {
                    pq.offer(new Pos(cur.x, cur.y, 2, cur.move + 1));
                    v[cur.x][cur.y][2]++;
                }
                if(v[cur.x][cur.y][3]==0) {
                    pq.offer(new Pos(cur.x, cur.y, 3, cur.move + 1));
                    v[cur.x][cur.y][3]++;
                }
            }
            else{
                if(v[cur.x][cur.y][0]==0) {
                    pq.offer(new Pos(cur.x, cur.y, 0, cur.move + 1));
                    v[cur.x][cur.y][0]++;
                }
                if(v[cur.x][cur.y][1]==0) {
                    pq.offer(new Pos(cur.x, cur.y, 1, cur.move + 1));
                    v[cur.x][cur.y][1]++;
                }
            }
        }

        System.out.println(move);
    }

    private static Pos makePos() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;
        int d = Integer.parseInt(st.nextToken())-1;
        return new Pos(x,y,d,0);
    }
}
