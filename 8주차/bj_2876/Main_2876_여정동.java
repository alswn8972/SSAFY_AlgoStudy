import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2876_여정동{
	static int N;
	static int min_grade;
	static int max_num = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int[][] dp = new int[6][N+1];
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dp[a][i] = dp[a][i-1]+1;  
			dp[b][i] = dp[b][i-1]+1;
		}
		for(int i = 1; i < 6; i++) {
			for(int j = 0; j <= N; j++) {
				if(max_num < dp[i][j]) {
					min_grade=i;
					max_num = dp[i][j];
				}
			}
		}
		bw.write(max_num+" "+min_grade);
		bw.flush();
	}
}