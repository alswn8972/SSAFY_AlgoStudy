import java.util.*;
import java.io.*;
public class Main_2410 {
	public static void main(String[] args) throws IOException {

        Scanner sc= new Scanner(System.in);
        int dp[] = new int[1000001];
        dp[0] = 1;
    	dp[1] = 1;
    	int N =sc.nextInt();
    	
    	for(int i = 2; i <= N ; i++)
    		dp[i] = (dp[i - 2] + dp[i / 2])%1000000000;
    	
    	System.out.println(dp[N]);
	}
	
}
