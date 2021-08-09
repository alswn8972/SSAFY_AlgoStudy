package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11123 {
	static char[][] map;
	static boolean[][] v;
	static int ans,H,W;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<TC;t++) {
			st=new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			v= new boolean[H][W];
			ans=0;
			for(int i=0;i<H;i++) {
				map[i]=br.readLine().toCharArray();
			}
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(map[i][j]=='#'&&!v[i][j]) 
						bfs(i,j);
				}
			}
			sb.append(ans).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	public static void bfs(int i, int j) {
		v[i][j]=true;
		int[] dx= {-1,1,0,0};
		int[] dy= {0,0,-1,1};
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		
		int[] temp;
		while(!q.isEmpty()) {
			temp=q.poll();
			
			for(int x=0;x<4;x++) {
				int nx = temp[0]+dx[x];
				int ny = temp[1]+dy[x];
				
				if(nx<0||ny<0||nx>=H||ny>=W||v[nx][ny]||map[nx][ny]=='.') continue;
				
				v[nx][ny]=true;
				q.add(new int[] {nx,ny});
			}
			
		}
		ans++;
	}

}
