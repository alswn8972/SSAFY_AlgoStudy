import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20168_박주영 {
    static int n,m,a,b,c;
    static int map[][] = new int[11][11];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[r][c] = v;
            map[c][r] = v;
        }
        visited = new boolean[11][11];
        boolean res = dfs(a, 0, -1);
        System.out.println(res?min:-1);
    }

    static int min = Integer.MAX_VALUE;
    private static boolean dfs(int cur, int sum, int max) {
        if(sum>c)return false;
        if(cur==b){
            if(min>max){
                min = max;
            }
            return true;
        }
        boolean res = false;
        for(int i = 1; i<=n; i++){
            if(map[cur][i] == 0 || visited[cur][i])continue;
            visited[cur][i] = true;
            visited[i][cur] = true;
            res = dfs(i,sum+map[cur][i], Math.max(max, map[cur][i]));
        }
        return res;
    }
}
