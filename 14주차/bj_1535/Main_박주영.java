import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_박주영 {
    static int N, maxJoy = Integer.MIN_VALUE;
    static int[] L,J;
    static boolean[] v;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        L = new int[N+1];
        J = new int[N+1];
        v = new boolean[N+1];
        // dp[i][1] == 체력 100 -> dp[i][100] == 체력 0
        // 체력 0이면 죽음 -> dp[N][99]를 구해야 한
        dp = new int[N+1][101];

        StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
        for(int i = 1; i<=N; i++){
            L[i] = Integer.parseInt(st1.nextToken());
            J[i] = Integer.parseInt(st2.nextToken());
        }
        //dfs(0, 100, 0);

        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=100; j++){
                if(L[i]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-L[i]]+J[i]);
                }
            }
        }
        maxJoy = dp[N][99];
        System.out.println(maxJoy);
    }

    private static void dfs(int cnt, int power, int joy) {
        if(cnt == N){
            if(power>0){
                maxJoy = Math.max(maxJoy, joy);
            }
            return;
        }

        for(int i = cnt; i<=N; i++){
            if(v[i])continue;

            v[i] = true;
            dfs(cnt+1, power-L[i], joy+J[i]);
            v[i] = false;
        }
    }

}
