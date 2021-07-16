import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_18428 {
    static int N;
    static String[][] map;
    static boolean sol;
    static ArrayList<Integer> teacher;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        teacher = new ArrayList<>();
        int tmp = 0;
        StringTokenizer st = null;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j<N; j++){
                map[i][j] = st.nextToken();
                if(map[i][j].equals("T")) teacher.add(tmp);
                tmp++;
            }
        }

        sol = false;
        dfs(0,0);

        if(sol)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static void dfs(int idx, int count) {
        if(sol) return;
        if(idx == N*N) return;
        if(count == 3){
            if(find()){
                sol = true;
            }
            return;
        }

        int r = idx/N;
        int c = idx%N;
        if(map[r][c].equals("X")){
            map[r][c] = "O";
            dfs(idx+1, count+1);
            map[r][c] = "X";
        }
        dfs(idx+1, count);
    }

    private static boolean find() {
        for(int t:teacher){//선생님 위치만큼
            int r = t/N;
            int c = t%N;
            for(int i = 0; i<4; i++) {
                int spread = 1;
                boolean find = false;
                while(true) {
                    int nr = r + dx[i] * spread;
                    int nc = c + dy[i] * spread;
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc].equals("O")) break;
                    if (map[nr][nc].equals("S"))return false;
                    spread++;
                }
            }
        }
        return true;
    }
}
