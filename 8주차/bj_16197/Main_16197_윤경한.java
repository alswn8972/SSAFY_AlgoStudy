import java.util.*;
import java.io.*;

public class Main_16197_윤경한 {
	static char[][] map;
	static int N,M;
	static int res = Integer.MAX_VALUE;
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		int x1=-1,y1=-1,x2=-1,y2=-1;
		for (int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = line[j];
				if(map[i][j] == 'o') {
					if(x1 == -1) {
						x1 = i;
						y1 = j;
					} else {
						x2 = i;
						y2 = j;
					}
				}
			}
		}
	
		
		dfs(x1,y1,x2,y2,0);
		
		if(res == Integer.MAX_VALUE) res = -1;
		System.out.println(res);
		
		
	}
	

	static void dfs(int x1,int y1,int x2, int y2 ,int move)
	{
		if(res <= move || move >= 10) return;
		
	
		
		for (int i = 0; i <4; i++) {
			boolean c1drop=false, c2drop=false;
			int nx1= x1+dir[i][0];
			int ny1= y1+dir[i][1];
			
			int nx2= x2+dir[i][0];
			int ny2= y2+dir[i][1];
			
			if(nx1 < 0 || ny1< 0 || nx1 >= N || ny1 >= M ) c1drop=true;
			if(nx2 < 0 || ny2< 0 || nx2 >= N || ny2 >= M ) c2drop=true;
			
			if(c1drop && c2drop) continue;
			
			if(c1drop || c2drop)
			{
				res = res > move + 1 ? move + 1 : res;
				
				return;
			}
			
			
			if(!c1drop && map[nx1][ny1] == '#') { nx1=x1; ny1=y1;}
			if(!c2drop && map[nx2][ny2] == '#') { nx2=x2; ny2=y2;}
			
			if((nx1==nx2) && (ny1==ny2)) continue;
			
			dfs(nx1,ny1,nx2,ny2,move+1);
		}
		
		
	}
}
