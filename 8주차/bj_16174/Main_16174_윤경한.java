import java.io.*;
import java.util.*;
public class Main_BOJ_16174 {
	static int N;
	//ㅇㅇㅇㅇ
	static int map[][];
	static Queue<Pos> que;
	static int dir[][] = {{1,0},{0,1}};
	static boolean[][] check;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		que = new LinkedList<Pos>();

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		que.add(new Pos(0,0));

		boolean flag = false;
		aaa:while(!que.isEmpty())
		{
			Pos cur = que.poll();

			for (int i = 0; i < 2; i++) {
				int nx = cur.x + map[cur.x][cur.y]*dir[i][0];
				int ny = cur.y + map[cur.x][cur.y]*dir[i][1];


				if(nx < 0 || ny < 0 || nx >= N || ny >=N) continue;
				if(check[nx][ny]) continue;
				
				if(map[nx][ny] == -1)
				{
					flag =true; 
					break aaa;
				}
				check[nx][ny] = true;
				que.add(new Pos(nx,ny));
			}
		}

		if(flag) System.out.println("HaruHaru");
		else System.out.println("Hing");

	}
	static class Pos
	{
		int x,y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
			
		}

	}
}
