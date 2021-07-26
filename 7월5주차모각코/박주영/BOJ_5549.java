import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5549 {
    static int M,N,K;
    static int[][][] map;
    static int finds[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        map = new int[M+1][N+1][3];
        for(int i = 1; i<=M; i++){
            String tmp = br.readLine();
            for(int j = 1; j<=N; j++){
                char now = tmp.charAt(j-1);
                if(now == 'J')
                    map[i][j][0]++;
                else if(now == 'O')
                    map[i][j][1]++;
                else if(now == 'I')
                    map[i][j][2]++;
            }
            for(int j = 1; j<=N; j++){
                for(int k = 0; k<3; k++){
                    map[i][j][k] += map[i-1][j][k];
                }
            }
        }
        finds = new int[K][4];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            finds[i] = new int[]{a,b,c,d};

            for(int j = 0; j<3; j++){
                int tmp  = 0;
                for(int k = b; k<=d; k++){
                    tmp+=map[c][k][j] - map[a-1][k][j];
                }
                sb.append(tmp).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
