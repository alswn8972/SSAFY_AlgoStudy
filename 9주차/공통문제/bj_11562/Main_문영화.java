import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_문영화 {
	static int[][] map;
	static boolean[] v;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		for(int i=0;i<N+1;i++) {
			for(int j=0;j<N+1;j++) {
				if(i==j) continue;
				map[i][j]=999_999_999;
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			int ck =Integer.parseInt(st.nextToken());
				map[a][b]=0;
				if(ck==0) {
					map[b][a]=1;
				}else {
					map[b][a]=0;
				}
		}
		//플로이드
		for(int k=1;k<=N;k++)
			for(int i=1;i<=N;i++)
				for(int j=1;j<=N;j++)
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
		
		int P = Integer.parseInt(br.readLine());
		for(int i=0;i<P;i++) {
			st = new StringTokenizer(br.readLine());
			int c=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			
			sb.append(map[c][d]+"\n");
			
		}
		
		System.out.println(sb.toString());
	}
	public static int bfs(int start, int end) {
		int total=0;
		v=new boolean[N+1];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {start, 0});
		v[start]=true;
		
		int[] nd;
		while(!q.isEmpty()) {
			nd = q.poll();
			if(nd[0]==end) {
				total=nd[1];
				break;
			}
			for(int i=1;i<N+1;i++) {
				if(v[i]) continue;
				if(map[nd[0]][i]==1) {
					v[i]=true;
					q.offer(new int[] {i,nd[1]});
					
				}else if(map[nd[0]][i]==-1) {
					v[i]=true;
					q.offer(new int[] {i,nd[1]+1});
				}
			}
			
		}
		return total;
	}
	
}
