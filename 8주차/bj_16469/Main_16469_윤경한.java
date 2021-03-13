import java.util.*;
import java.io.*;

public class Main_16469_윤경한 {
	static int map[][];
	static int akdangmap[][][];
	static int R,C;
	static Queue<Pos> que;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R+1][C+1];
		akdangmap = new int[R+1][C+1][3];
		que = new LinkedList<>();
		for (int i = 1; i <= R; i++) {
			String str = new String(br.readLine());
			for (int j = 1; j <=C ; j++) {
				map[i][j] = str.charAt(j-1)-'0';
			}
		}

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			bfs(x,y,i);
		}

		int Maxmin = Integer.MAX_VALUE;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {

				if(akdangmap[i][j][0] != 0 && akdangmap[i][j][1] != 0 && akdangmap[i][j][2] != 0 ){
					int stepmax = Math.max(akdangmap[i][j][0] , Math.max(akdangmap[i][j][1] ,akdangmap[i][j][2]));

					if(Maxmin > stepmax)
					{
						Maxmin = stepmax;
						res =1;
					}
					else if( Maxmin == stepmax)
					{
						res+=1;
					}
				}

			}
		}
		if( res == -1 ) System.out.println(-1);
		else
		{
			System.out.println(Maxmin);
			System.out.println(res);
		}


	}

	static int res = -1;
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	static void bfs(int x,int y, int ak)
	{
		que.add(new Pos(x,y,0));
		akdangmap[x][y][ak]=-1;
		while(!que.isEmpty())
		{
			Pos cur = que.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x+dir[i][0];
				int ny = cur.y+dir[i][1];
				int ns = cur.step+1;

				if(nx<= 0 || ny <= 0 || nx> R || ny>C) continue;

				if(map[nx][ny] == 1 ||akdangmap[nx][ny][ak] != 0) continue;

				akdangmap[nx][ny][ak] = ns;
				que.add(new Pos(nx,ny,ns));

			}
		}
	}
	static class Pos{
		int x,y,step;

		public Pos(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}

	}

}
