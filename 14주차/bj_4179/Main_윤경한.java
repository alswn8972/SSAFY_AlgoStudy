import java.io.*;
import java.util.*;
public class Main_4179 {
	static char[][] map;
	static int R,C;
	static int Jr,Jc;
	static int Fsr,Fsc;
	static int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		Queue<Fire> Fque = new LinkedList<>();

		for (int i = 0; i <R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'J')
				{
					Jr =i ; Jc =j;
					map[i][j] = '.';
				}
				if(map[i][j] == 'F')
				{
					Fque.add(new Fire(i, j));
				}
			}
		}
		boolean check[][] = new boolean[R][C];

		Queue<Jihun> pq = new LinkedList<>();
		pq.add(new Jihun(Jr, Jc, 0));
		int res = Integer.MAX_VALUE;
		boolean flag = false;
		
		aa:while(!pq.isEmpty())
		{
			// 불이동 
			int Fsize = Fque.size();
			for (int i = 0; i <Fsize; i++) {
				Fire curFire = Fque.poll();
				for (int j = 0; j <4; j++) {
					int Fnr = curFire.r + dir[j][0];
					int Fnc = curFire.c + dir[j][1];

					if(Fnr < 0 ||Fnr >= R || Fnc <0 || Fnc >=C ) continue;
					if(map[Fnr][Fnc] == '#' ||map[Fnr][Fnc] == 'F' ) continue;

					map[Fnr][Fnc] = 'F';
                    Fque.add(new Fire(Fnr, Fnc));
				}
			}
			//지훈이 이동
			int Jsize = pq.size();
			for (int i = 0; i < Jsize; i++) {
				Jihun curJihun = pq.poll();

				if( curJihun.r == R-1 || curJihun.r == 0 || curJihun.c == C-1 || curJihun.c ==0)
				{
					flag = true;
					res = curJihun.time;
					break aa;
				}
				
				for (int j = 0; j < 4; j++) {
					int nr = curJihun.r + dir[j][0];
					int nc = curJihun.c + dir[j][1];

					if(nr < 0 || nr >= R || nc <0 || nc >=C ) continue;
					if(check[nr][nc]) continue;
					if(map[nr][nc]=='#' || map[nr][nc]=='F') continue;

					
					check[nr][nc] = true;
					pq.add(new Jihun(nr, nc, curJihun.time+1));
				}
			}



		}

		if(flag) System.out.println(res+1);
		else System.out.println("IMPOSSIBLE");

	}
	static int res;
	static class Fire
	{
		int r,c;
		public Fire(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}
	static class Jihun 
	{
		int r,c,time;

		public Jihun(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
		
	}
}
