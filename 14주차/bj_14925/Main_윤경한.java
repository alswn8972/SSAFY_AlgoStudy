import java.io.*;
import java.util.*;
public class Main_14925 {
	static int N,M;
	static int map[][];
	static int dp[][];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M+1][N+1];
		dp= new int[M+1][N+1];
		
		for (int i = 1; i <=M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		int res =0;
		for (int i = 1; i <=M; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j] == 0)
				{
					dp[i][j] = (Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]));
					dp[i][j] +=1;
					res = Math.max(res, dp[i][j]);
				}
			}
		}
		
		
		
		System.out.println(res+"");
	}
}
