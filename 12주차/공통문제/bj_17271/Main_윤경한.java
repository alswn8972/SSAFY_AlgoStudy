import java.io.*;
import java.util.*;
public class Main_boj_17271 {
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int N = Integer.parseInt(st.nextToken());
		 int M = Integer.parseInt(st.nextToken());
		 
		 int dp[] = new int[10001];
		 
		 dp[0] =1;
		 for (int i = 1; i <= N ; i++) {
			dp[i] = dp[i-1];
			if(i-M>= 0) {
				dp[i] = (dp[i] + dp[i-M])%1000000007;
			}
		}
		 
		System.out.println(dp[N]);
	}

}
