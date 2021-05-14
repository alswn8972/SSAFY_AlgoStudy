import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026 {
    static int N;
    static char[][] map;
    static boolean[][][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        v = new boolean[N][N][2];
        for(int i = 0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        int nomalCnt = 0;
        int redgreen = 0;
        char[][] gg = new char[N][N];
        for(int r = 0; r<N; r++){
            for(int c = 0; c<N; c++){
                if(map[r][c] == 'R')
                    gg[r][c] = 'G';
                else{
                    gg[r][c] = map[r][c];
                }
            }
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(v[i][j][0])continue;
                else{
                    nomal(i,j,map[i][j]);
                    nomalCnt++;
                }

                if(v[i][j][1])continue;
                else{
                    char c = map[i][j]=='R'?'G':map[i][j];
                    rg(i,j,gg,c);
                    redgreen++;
                }
            }
        }
        System.out.println(nomalCnt+ " "+redgreen);
    }

    private static void rg(int i, int j,char[][] gg, char rgb) {
        v[i][j][1] = true;
        for(int d = 0; d<4; d++){
            int ni = i+dx[d];
            int nj = j+dy[d];
            if(ni<0||nj<0||ni>=N||nj>=N||v[ni][nj][1]||gg[ni][nj]!=rgb)continue;

            rg(ni,nj,gg,rgb);
        }
    }

    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    private static void nomal(int i, int j, char rgb) {
        v[i][j][0] = true;
        for(int d = 0; d<4; d++){
            int ni = i+dx[d];
            int nj = j+dy[d];
            if(ni<0||nj<0||ni>=N||nj>=N||v[ni][nj][0]||map[ni][nj]!=rgb)continue;

            nomal(ni, nj, rgb);
        }
    }
}
