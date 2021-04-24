import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_문영화 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] items = new int[N+1][N+1]; //가치 무게
		int[][] dp = new int[N+1][101];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i=1;i<=N;i++) {
			items[i][0]=Integer.parseInt(st2.nextToken());
			items[i][1]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) { //물건 
			for(int j=1;j<=100;j++) { //배낭무게
				if(items[i][1]>j) {
					dp[i][j]=dp[i-1][j];
				}else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-items[i][1]]+items[i][0]);
				}
				
			}
		}
		
		System.out.println(dp[N][99]);
	}

}
