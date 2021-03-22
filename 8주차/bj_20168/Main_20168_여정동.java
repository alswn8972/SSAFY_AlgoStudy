import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20168_여정동{
	static int N, M, A, B, C, temp;
	static int[][] map;
	static boolean[] iv;
	static int[] D;
	
	static boolean check() {
		D = new int[N+1];
		iv = new boolean[N+1];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[A] = 0;
		for(int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			int now = 0;
			for(int j = 1; j <= N; j++) {
				if(!iv[j] && min > D[j]) {
					min = D[j];
					now = j;
				}
			}
			iv[now] = true;
			if(now == B) break;
			
			for(int j = 1; j <= N; j++) {
				if(!iv[j] && map[now][j] != 0 && D[j] > min + map[now][j]) {
					D[j] = min + map[now][j];
				}
			}
		}
		
		if(D[B] > C) {
			return false;
		}
		return true;
	}
	
	static void dfs(int start, int amount, int max) {
		iv[start] = true;
		if(start == B) {
			temp = Math.min(temp, max);
			return;
		}
		else {
			for(int i = 1; i <= N; i++) {
				if(!iv[i] && map[start][i] != 0) {
					if(map[start][i] > amount)
						continue;
					iv[i] = true;
					dfs(i,amount-map[start][i],Math.max(max, map[start][i]));
					iv[i] = false;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[x][y] = v;
			map[y][x] = v;
		}
		
		if(!check()) {
			bw.write("-1");
		}
		else {
			iv = new boolean[N+1];
			temp = Integer.MAX_VALUE;
			dfs(A,C,0);
			bw.write(Integer.toString(temp));
		}
		bw.flush();
	}
}