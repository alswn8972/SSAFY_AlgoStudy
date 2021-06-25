import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    static int N, steps[], dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        steps = new int[N+1];
        dp = new int[N+1]; // idx번째 계단을 마지막으로 밟을 때 max값 저장
        for(int i = 1; i<=N; i++){
            steps[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = steps[1];
        if(N<2){ //계단 한개일 수 있
            System.out.println(dp[N]);
            return;
        }
        dp[2] = steps[1]+steps[2];
        for(int i = 3; i<=N; i++){
            dp[i] = Math.max(steps[i]+steps[i-1]+dp[i-3], steps[i]+dp[i-2]);
        }
        System.out.println(dp[N]);
    }
}