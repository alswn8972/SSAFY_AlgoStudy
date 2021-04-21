import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_여정동 {
	static int N, M, R;
	static int[][] cost;
	static int[] items;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		cost = new int[N+1][N+1];
		items = new int[N+1];

		for(int i = 1; i <= N; i++) {
			Arrays.fill(cost[i], 99999999);
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int n0 = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			cost[n0][n1] = c;
			cost[n1][n0] = c;
		}

		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				if(k == i) continue;
				for(int j = 1; j <= N; j++) {
					if(k==j||i==j) continue;
					cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
				}
			}
		}
		int max = 0;
		for(int i = 1; i <= N; i++) {
			int t = items[i];
			for(int j = 1; j <= N; j++) {
				if(cost[i][j] <= M) {
					t += items[j];
				}
			}
			max = Math.max(max, t);
		}
		System.out.println(max);
	}
}
