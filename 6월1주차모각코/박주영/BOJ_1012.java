import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012 {
    static int[][] map;
    static int M,N,K;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        while(tc-->0){
            st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for(int i = 0; i<K; i++){
                st = new StringTokenizer(br.readLine()," ");
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                map[r][c] = 1;
            }

            int cnt = 0;
            for(int i = 0; i<N; i++){
                for(int j = 0; j<M; j++){
                    if(map[i][j]==0)continue;
                    cnt++;
                    map[i][j] = 0;
                    dfs(i,j);
                }
            }
            System.out.println(cnt);
        }
    }

    private static void dfs(int i, int j) {
        for(int d= 0; d<4; d++){
            int ni = i+dx[d];
            int nj = j+dy[d];
            if(ni<0||nj<0||ni>=N||nj>=M||map[ni][nj]==0)continue;
            map[ni][nj] = 0;
            dfs(ni, nj);
        }
    }
}
