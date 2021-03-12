import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20168_문영화 {
	static int N,M,A,B,C;
	static int[][] map;
	static boolean[] v;
	static int result=999_999_999;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //교차로개수
		M = Integer.parseInt(st.nextToken()); //골목개수
		A = Integer.parseInt(st.nextToken()); //출발
		B = Integer.parseInt(st.nextToken()); //도착
		C = Integer.parseInt(st.nextToken()); //돈
		
		map=new int[N+1][N+1];
		v=new boolean[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b]=c;
			map[b][a]=c;
		}
		v[A]=true;
		dfs(A,0,0);
		if(result==999_999_999) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}
	public static void dfs(int start, int money, int max) {
		if(start==B) {
			result=Math.min(max, result);
			return;
		}
		for(int i=1;i<N+1;i++) {
			if(map[start][i]!=0&&!v[i]&&money+map[start][i]<=C) {
				int m = Math.max(map[start][i], max);
				v[i]=true;
				dfs(i,money+map[start][i],m);
				v[i]=false;
			}
		}
	}
}
