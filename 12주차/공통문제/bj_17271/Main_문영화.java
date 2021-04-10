import java.util.Scanner;

public class Main_문영화 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] dp=new int[N+1];
		int res=0;
		int result=0;
		dp[0]=1;
		for(int i=1;i<=N;i++) {
			dp[i]=dp[i-1];
			if(i-M>=0) dp[i]=(dp[i]+dp[i-M])%1000000007;
		}
		System.out.println(dp[N]);
	}

}
