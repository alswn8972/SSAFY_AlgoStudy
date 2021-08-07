import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];
        for(int i=0; i<10; i++){
            dp[1][i] = 1;
        }
        for(int i=2;i<=n;i++) { //  2부터 n까지 반복
            for(int j=0;j<10;j++) { // 0 ~ 9를 탐색하는데,
                for(int k=0;k<=j;k++) { // j를 기준으로 0부터 j까지 탐색
                    dp[i][j] += dp[i-1][k]; // k로 탐색한 값을 j에 누적
                }
                dp[i][j] %= 10007;
            }

        }
        int sum = 0;
        for(int i=0;i<10;i++) {
            sum+=dp[n][i];
        }

        System.out.println(sum % 10007);
    }
}
