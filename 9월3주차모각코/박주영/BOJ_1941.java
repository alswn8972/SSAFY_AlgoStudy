import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1941 {
    static char[][] map;
    static boolean[][] v2;
    static boolean[] v1;
    static int cnt;
    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        for(int i = 0; i<5; i++){
            map[i] = br.readLine().toCharArray();
        }

        cnt = 0;
        for(int i = 0; i<25; i++){
            v1 = new boolean[25];
            v2 = new boolean[5][5];
            dfs(i, 1, 0);
        }

        System.out.println(cnt);
    }

    private static void dfs(int i, int sum, int Ssum) {
        if(map[i/5][i%5]=='S')Ssum++;

        v1[i] = true;
        v2[i/5][i%5] = true;

        if(sum == 7){
            if(Ssum>=4) {
                if (check()) cnt++;
            }
        }
        else{
            for(int j = i+1; j<25; j++){
                if(v1[j])continue;
                dfs(j, sum+1, Ssum);
            }
        }

        v1[i] = false;
        v2[i/5][i%5] = false;
    }

    private static boolean check() {
        // 7명이 인접해있는지 체크
        near = 1;
        boolean[][] tmp = new boolean[5][5];
        a: for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                if(v2[i][j]){
                    tmp[i][j] = true;
                    nearNum(i, j, tmp);
                    break a;
                }
            }
        }
        return near==7?true:false;
    }

    static int near;
    private static void nearNum(int i, int j, boolean[][] tmp) {
        for(int d = 0; d<4; d++){
            int ni = i+dr[d];
            int nj = j+dc[d];
            if(ni<0||nj<0||ni>=5||nj>=5||tmp[ni][nj]||!v2[ni][nj])continue;

            tmp[ni][nj] = true;
            near += 1;
            nearNum(ni, nj, tmp);
        }
    }
}
