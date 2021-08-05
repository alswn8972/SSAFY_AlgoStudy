import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11404 {
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                if(i == j)continue;
                map[i][j] = 10000001;
            }
        }
        StringTokenizer st = null;
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b], c);
        }

        //floyd-warshall
        for(int k = 1; k<=N; k++) {//경유지
            for(int i = 1; i<=N; i++) {//출발지
                if(map[i][k] == 0)continue;
                for(int j = 1; j<=N; j++){//도착지
                    if(map[k][j] == 0 || i==j)continue;
                    map[i][j] = Math.min(map[i][k]+map[k][j], map[i][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                if(map[i][j]==10000001)
                    sb.append("0 ");
                else
                    sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
