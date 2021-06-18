import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
    static int N, M;
    static int map[][];
    static boolean v[][][];
    static class Item{
        int r,c, sum;
        int wall;

        public Item(int r, int c, int sum, int wall) {
            this.r = r;
            this.c = c;
            this.wall = wall;
            this.sum = sum;
        }
    }
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M][2];
        for(int i = 0; i<N; i++){
            String row = br.readLine();
            for(int j = 0; j<M; j++)
                map[i][j] = row.charAt(j)-'0';
        }

        Queue<Item> q = new LinkedList<>();
        q.offer(new Item(0,0, 1,0));
        v[0][0][0] = true;
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Item cur = q.poll();
            if(cur.r == N-1 && cur.c == M-1){
                min = Math.min(min, cur.sum);
                continue;
            }
            if(cur.sum>min)continue;
            for(int d = 0; d<4; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if(nr<0 || nc<0 || nr>=N || nc>=M)continue;
                int nextWall = cur.wall;
                if(map[nr][nc]==1){
                    if(cur.wall == 1)continue;
                    else nextWall = 1;
                }
                if(v[nr][nc][nextWall])continue;
                q.offer(new Item(nr,nc,cur.sum+1,nextWall));
                v[nr][nc][nextWall] = true;
            }
        }
        System.out.println(min==Integer.MAX_VALUE?-1:min);
    }
}
