import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15486 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N+2];
		int[] P = new int[N+2];
		int[] dp = new int[N+2];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N+1; i++) {
			if(dp[i-1] >= dp[i]) dp[i] = dp[i-1];
			if((i+T[i]) <= N+1 && (dp[i] + P[i]) > dp[i+T[i]]) {
				dp[i+T[i]] = dp[i] + P[i];
			}
		}
		
		System.out.println(dp[N+1]);
	}
}
