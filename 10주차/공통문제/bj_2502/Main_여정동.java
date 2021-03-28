import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_여정동 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int a,b;
		
		int[] dp = new int[31];
		dp[1] = 1; dp[2] = 1;
		
		
		for(int i = 3; i <= D; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		int x = dp[D-2];
		int y = dp[D-1];
		int i = 1;
		while(true) {
			a = i++;
			if((K - x * a) % y != 0) {
				continue;
			}
			b = (K - x * a) / y;
			break;
		}
		
		System.out.println(a);
		System.out.println(b);
	}
}