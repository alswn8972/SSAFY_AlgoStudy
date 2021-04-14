import java.util.Scanner;

public class Main_2410 {
		private static int dp[][];
		private static int MOD = 1000000000;
		private static int result = 0;
		
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			
			int n = scanner.nextInt();
			
			dp = new int[n+1][20]; // 0, 0 은안씀	
			
			int dp[] = new int[n+1];
			dp[0] = 1;
			dp[1] = 1;
			for(int i = 2 ; i <= n ; i ++)
				dp[i] = (dp[i-2] + dp[i/2])%MOD;
			System.out.println(dp[n]);
		} 
}
