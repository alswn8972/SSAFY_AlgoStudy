import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16973 {
    static int n,m,sr,sc,fr,fc,h,w;
    static int[][] map;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static class Square implements Comparable<Square>{
        int r,c;
        int h,w;
        int cnt;

        public Square(int r, int c, int h, int w, int cnt) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.w = w;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Square o) {
            return this.cnt-o.cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 1; j<=m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        fr = Integer.parseInt(st.nextToken());
        fc = Integer.parseInt(st.nextToken());

        PriorityQueue<Square> pq = new PriorityQueue<>();
        boolean[][] v = new boolean[n+1][m+1];
        v[sr][sc] = true;
        pq.add(new Square(sr,sc,h,w,0));

        int res = -1;
        while (!pq.isEmpty()){
            Square cur = pq.poll();
            if(cur.r==fr && cur.c==fc){
                res = cur.cnt;
                break;
            }
            for(int d = 0; d<4; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if(nr<1 || nc<1 || nr>n || nc>m || nr+cur.h-1>n || nc+cur.w-1>m || v[nr][nc])continue;
                if(!check(nr,nc,cur.h,cur.w)) continue;

                v[nr][nc] = true;
                pq.add(new Square(nr,nc,cur.h,cur.w,cur.cnt+1));
            }
        }
        System.out.println(res);
    }

    private static boolean check(int nr, int nc, int h, int w) {
        //사각형 놓일 수 있는지 확인
        for(int i = nr; i<nr+h; i++){
            for(int j = nc; j<nc+w; j++){
                if(map[i][j] == 1) return false;
            }
        }
        return true;
    }
}

