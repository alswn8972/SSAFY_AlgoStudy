import java.io.*;
import java.util.*;
public class Main_1719 {
	static int N,M;
	static int map[][];
	static int dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N+1][N+1];
		dp = new int[N+1][N+1];


		for (int i = 1; i < N+1; i++) 
		{
			Arrays.fill(map[i], 10001);
			map[i][i]=0; 
		}



		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s,f,d;
			s= Integer.parseInt(st.nextToken());
			f= Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			map[s][f] =d;
			map[f][s] =d;

			dp[s][f] = s;
			dp[f][s] = f;
		}



		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <=  N; j++) {
					if(map[i][j] > map[i][k] + map[k][j])
					{
						map[i][j] = map[i][k] + map[k][j];
						dp[i][j] = dp[k][j];


					}
				}
			}
		}

		for (int i = 1; i < N+1; i++)
		{ 
			for (int j = 1; j < N+1; j++)
			{ 
				if(i==j) sb.append("- "); 
				else sb.append(dp[j][i]+" "); 
			}
			sb.append("\n"); 
		} 

		System.out.println(sb.toString());


	}
}
