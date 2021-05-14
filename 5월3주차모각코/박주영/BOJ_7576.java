import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7576 {
    static int N, M;
    static int[][] map;
    static boolean[][] v;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M];
        int noTomatoCnt = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) noTomatoCnt++;
                if(map[i][j]==1) {
                    q.offer(new int[]{i,j});
                    v[i][j] = true;
                }
            }
        }

        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0; s<size; s++) {
                int[] cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int ni = cur[0] + dx[d];
                    int nj = cur[1] + dy[d];
                    if (ni < 0 || nj < 0 || ni >= N || nj >= M || v[ni][nj] || map[ni][nj] == -1) continue;

                    v[ni][nj] = true;
                    if (map[ni][nj] == 0) map[ni][nj] = 1;
                    q.offer(new int[]{ni, nj});
                }
            }
            cnt++;
        }

        int vCnt = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(v[i][j]) vCnt++;
            }
        }
        if(vCnt == (N*M-noTomatoCnt)){
            System.out.println(cnt-1);
            return;
        }
        System.out.println(-1);
    }
}
