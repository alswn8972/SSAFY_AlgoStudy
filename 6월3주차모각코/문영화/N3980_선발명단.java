import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N3980_선발명단 {

	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static boolean[] position;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0;t<TC;t++) {
			map = new int[11][11];
			position = new boolean[11];
			max = Integer.MIN_VALUE;
			for(int i=0;i<11;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<11;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0,0);
			sb.append(max).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	public static void dfs(int n, int sum) {
		if(n==11) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0;i<11;i++) {
			if(position[i]||map[n][i]==0) continue;
			position[i]=true;
			dfs(n+1,sum+map[n][i]);
			position[i]=false;
		}
	}

}
