import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {
    static int[][] map;
    static int N,M;
    static class Node{
        int r, c, d;

        public Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine()," ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        Node start = new Node(r,c,d);

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(start);
        System.out.println(cnt);
    }

    static int cnt = 0;
    private static void dfs(Node cur) {
        if(cur.r <= 0 || cur.c <= 0 || cur.r >= N-1 || cur.c >= M-1){
            return;
        }
        // 1.현재위치 청소
        cnt++;
        map[cur.r][cur.c] = 2;
        dfs2(cur);
    }

    private static void dfs2(Node cur){
        // 2.인접칸 탐색
        for(int i = 1; i<=4; i++) {
            int nd = (cur.d - i + 4) % 4;
            int nr = cur.r + dr[nd];
            int nc = cur.c + dc[nd];
            if(nr<0 || nc<0 || nr>=N || nc>=M || map[nr][nc] == 1) continue;
            if(map[nr][nc] == 0){
                dfs(new Node(nr, nc, nd));
                return;
            }
        }
        int br = cur.r+dr[(cur.d+2)%4];
        int bc = cur.c+dc[(cur.d+2)%4];
        if(map[br][bc]!=1){
            dfs2(new Node(br, bc, cur.d));
        }
    }
}
