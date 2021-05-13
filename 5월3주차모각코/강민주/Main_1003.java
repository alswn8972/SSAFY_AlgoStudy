import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		
		int[][] dp=new int[41][2];
		dp[0][0]=1;
		dp[0][1]=0;
		dp[1][0]=0;
		dp[1][1]=1;
		
		for(int i=2;i<41;i++) {
			dp[i][0]=dp[i-2][0]+dp[i-1][0];
			dp[i][1]=dp[i-2][1]+dp[i-1][1];
		}
		
		for(int i=0;i<N;i++) {
			int a=Integer.parseInt(br.readLine());
			System.out.println(dp[a][0]+" "+dp[a][1]);
		}
	}
}
