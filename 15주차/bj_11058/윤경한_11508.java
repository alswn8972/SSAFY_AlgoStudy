import java.io.*;
import java.util.*;
public class Main_11508 {
	static long dp[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new long[101];
		
		dp[0] =0;
		dp[1] =1;
		dp[2] =2;
		dp[3] =3;
		dp[4] =4;
		dp[5] =5;
		
		for (int i = 6; i < 101; i++) {
			dp[i] = Math.max(Math.max(dp[i-1]+1, dp[i-3]*2),Math.max(dp[i-4]*3, dp[i-5]*4));
		}
		
		System.out.println(dp[N]+"");
	}
	
}
