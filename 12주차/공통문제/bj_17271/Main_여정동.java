import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_여정동 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp = new int[100001];
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 1 ; i < M; i++) {
			dp[i] = 1;
		}
		dp[M] = 2;
		
		for(int i = M+1; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-M])%1000000007;
		}
		
		System.out.println(dp[N]);
	}
}
