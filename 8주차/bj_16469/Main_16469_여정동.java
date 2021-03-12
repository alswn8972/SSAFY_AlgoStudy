import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16469_여정동 {
	static int R,C;
	static char[][] map;
	static B[] bs;
	static Iv[][] ivd;
	static boolean isFound = false;
	static int min = Integer.MAX_VALUE;
	static int counter = 0;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static void bfs() {
		Queue<B> q = new LinkedList<B>();
		for(int i = 0; i < 3; i++) {
			ivd[bs[i].y][bs[i].x].v[bs[i].n] = true;
			ivd[bs[i].y][bs[i].x].min = 0;
			q.offer(bs[i]);
		}
		while(!q.isEmpty()) {
			B now = q.poll();
			int ny,nx;
			for(int d = 0; d < 4; d++) {
				ny = now.y + dy[d];
				nx = now.x + dx[d];
				if(ny > -1&& nx > -1&& ny < R && nx < C && !ivd[ny][nx].v[now.n] && map[ny][nx] == '0') {
					q.offer(new B(now.n,ny,nx,now.move+1));
					ivd[ny][nx].v[now.n] = true;
					ivd[ny][nx].min = now.move+1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		ivd = new Iv[R][C];
		bs = new B[3];
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				ivd[i][j] = new Iv();
			}
		}

		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			bs[i] = new B(i,y-1,x-1,0); 
		}
		bfs();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == '0' && ivd[i][j].v[1] && ivd[i][j].v[2] && ivd[i][j].v[2]) {
					isFound = true;
					min = Math.min(min, ivd[i][j].min);
				}
			}
		}
		if(isFound) {
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(min == ivd[i][j].min) {
						counter++;
					}
				}
			}
			bw.write(min+"\n"+counter);
		}

		else bw.write("-1");
		bw.flush();
	}
}
class Iv{
	boolean[] v;
	boolean chked = false;
	int min = -1;
	Iv() {
		v = new boolean[3];
		v[0] = false;
		v[1] = false;
		v[2] = false;
	}
}
class B{
	int y;
	int x;
	int n;
	int move;
	B(int n,int y, int x, int m){
		this.n = n;
		this.x = x;
		this.y = y;
		this.move = m;
	}
}
