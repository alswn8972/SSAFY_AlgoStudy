import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21610 {
    static int N, M;
    static int[][] a;
    static boolean[][] cloud;
    static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j<N; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cloud = new boolean[N][N];
        cloud[N-1][0] = cloud[N-1][1] = cloud[N-2][0] = cloud[N-2][1] = true;
        for(int i = 0; i<M; i++){
            // M번 비바라기
            st = new StringTokenizer(br.readLine()," ");
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            move(d,s);
        }

        int total = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                total += a[i][j];
            }
        }
        System.out.println(total);
    }

    private static void move(int d, int s) {
        // move cloud d방향 s만큼
        boolean nextCloud[][] = new boolean[N][N];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(cloud[i][j]){
                    int ni = ((i+dr[d]*s)+N*s)%N;
                    int nj = ((j+dc[d]*s)+N*s)%N;
                    if(ni<0 || nj<0 || ni>=N || nj>=N)continue;
                    nextCloud[ni][nj] = true; // 1.
                    a[ni][nj]++; // 2.
                    cloud[i][j] = false;
                }
            }
        }
        cloud = nextCloud; // 3.

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(cloud[i][j]){ // 4.
                    int cnt = 0;
                    for(int k = 2; k<=8; k+=2){
                        int ni = i+dr[k];
                        int nj = j+dc[k];
                        if(ni<0 || nj<0 || ni>=N || nj>=N || a[ni][nj]<=0)continue;
                        cnt++;
                    }
                    a[i][j] += cnt;
                }
            }
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(cloud[i][j]){
                    cloud[i][j] = false;
                    continue;
                }
                if(a[i][j]<2)continue;
                // 5.
                cloud[i][j] = true;
                a[i][j] -= 2;
            }
        }
    }
}
