import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3085 {
    static int N;
    static char[][] map;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i = 0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        int max = -1;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N;j++){
                // col
                if(j+1<N && map[i][j] != map[i][j+1]){
                    char cur = map[i][j];
                    map[i][j] = map[i][j+1];
                    map[i][j+1] = cur;
                    int c = check(map);
                    if(max<c) max = c;

                    map[i][j+1] = map[i][j];
                    map[i][j] = cur;
                }

                // row
                if(i+1<N && map[i][j] != map[i+1][j]){
                    char cur = map[i][j];
                    map[i][j] = map[i+1][j];
                    map[i+1][j] = cur;
                    int c = check(map);
                    if(max<c) max = c;

                    map[i+1][j] = map[i][j];
                    map[i][j] = cur;
                }
            }
        }
        System.out.println(max);
    }

    private static int check(char[][] m) {
        int res = 1;
        for(int i = 0; i<N; i++){
            int cnt = 1;
            for(int j = 1; j<N; j++){
                // col
                if(m[i][j] == m[i][j-1]) cnt++;
                else cnt = 1;
                if(res<cnt) res = cnt;
            }
            cnt = 1;
            for(int j = 1; j<N; j++){
                // row
                if(m[j][i] == m[j-1][i]) cnt++;
                else cnt = 1;
                if(res<cnt) res = cnt;
            }
        }
        return res;
    }

}
