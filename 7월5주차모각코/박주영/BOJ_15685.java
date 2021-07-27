import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15685 {
    static int gen[][];
    static boolean map[][] = new boolean[101][101];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        init();
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            int curC = c;
            int curR = r;
            map[curR][curC] = true;

            int end = (int)Math.pow(2, g);
            for(int j = 0; j<end; j++){
                if(gen[d][j] == 0) curC++;
                else if(gen[d][j] == 1) curR--;
                else if(gen[d][j] == 2) curC--;
                else if(gen[d][j] == 3) curR++;

                map[curR][curC] = true;
            }
        }

        // 정사각형 체크
        int cnt = 0;
        for(int i = 0; i<100; i++){
            for(int j = 0; j<100; j++){
                if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1])
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
    static void init(){
        // 세대별 드래곤커브
        gen = new int[4][1024]; // 4방
        gen[0][0] = 0;
        gen[1][0] = 1;
        gen[2][0] = 2;
        gen[3][0] = 3;

        for(int i = 0; i<4; i++){ // 4방
            for(int j =1; j<=10; j++){ // 10세대
                int start = (int)Math.pow(2, j-1);
                int end = (int)Math.pow(2, j);
                int gap = 1;
                for(int k = start; k<end; k++){
                    gen[i][k] = (gen[i][k-gap]+1)%4;
                    gap+=2;
                }
            }
        }
    }
}
