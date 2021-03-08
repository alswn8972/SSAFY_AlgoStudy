import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16174_박주영 {
    static int n;
    static int[][] map = new int[65][65];
    static boolean[][] v = new boolean[65][65];
    static int[] dx = {0,1};
    static int[] dy = {1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(sol(0,0)){
            System.out.println("HaruHaru");
        }
        else{
            System.out.println("Hing");
        }
    }

    private static boolean sol(int i, int j) {
        boolean res = false;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        v[i][j] = true;

        a: while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d=0; d<2; d++){
                int ni = cur[0]+(dx[d]*map[cur[0]][cur[1]]);
                int nj = cur[1]+(dy[d]*map[cur[0]][cur[1]]);
                if(ni<0||nj<0||ni>=n||nj>=n||v[ni][nj])continue;
                v[ni][nj] = true;
                if(map[ni][nj] == -1){
                    res = true;
                    break a;
                }
                q.offer(new int[]{ni,nj});
            }
        }
        return res;
    }
}
