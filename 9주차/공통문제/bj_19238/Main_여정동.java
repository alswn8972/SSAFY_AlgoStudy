import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_여정동{
	static int N, M, oil;
	static int[][] map;
	static int[] dy = {-1,0,0,1};
	static int[] dx = {0,-1,1,0};
	static int[] taxi;
	static Guest[] g;
	static ArrayList<Dist> dlist;
	
	static boolean findGuest() {
		Queue<int[]> q = new LinkedList<int[]>();
		int[] temp = {0, taxi[0], taxi[1]};
		q.offer(temp);
		boolean[][] iv = new boolean[N+1][N+1];
		iv[taxi[0]][taxi[1]] = true;
		boolean flag = false;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(now[0] > oil) continue;
			if(map[now[1]][now[2]] > 1) {
				dlist.add(new Dist(map[now[1]][now[2]], now[0], now[1], now[2]));
				flag = true;
			}
			int ny, nx;
			for(int d = 0; d < 4; d++) {
				ny = now[1] + dy[d];
				nx = now[2] + dx[d];
				if(ny > 0 && nx > 0 && ny <= N && nx <= N && map[ny][nx] != 1 && !iv[ny][nx]) {
					iv[ny][nx] = true;
					int[] next = {now[0]+1, ny, nx};
					q.offer(next);
				}
			}
		}
		return flag;
	}
	
	static boolean goToDt(int ind) {
		Queue<int[]> q = new LinkedList<int[]>();
		int[] temp = {0, taxi[0], taxi[1]};
		q.offer(temp);
		boolean[][] iv = new boolean[N+1][N+1];
		iv[taxi[0]][taxi[1]] = true;
		map[taxi[0]][taxi[1]] = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(now[0] > oil) continue;
			if(now[1] == g[ind].ed[0] && now[2] == g[ind].ed[1]) {
				oil -= now[0];
				oil += 2*now[0];
				taxi[0] = now[1];
				taxi[1] = now[2];
				return true;
			}
			int ny, nx;
			for(int d = 0; d < 4; d++) {
				ny = now[1] + dy[d];
				nx = now[2] + dx[d];
				if(ny > 0 && nx > 0 && ny <= N && nx <= N && map[ny][nx] != 1 && !iv[ny][nx]) {
					iv[ny][nx] = true;
					int[] next = {now[0]+1, ny, nx};
					q.offer(next);
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		oil = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		taxi = new int[2];
		taxi[0] = Integer.parseInt(st.nextToken());
		taxi[1] = Integer.parseInt(st.nextToken());
		g = new Guest[M+2];
		for(int i = 2; i < M+2; i++) {
			st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			map[sy][sx] = i;
			g[i] = new Guest(i, ey, ex);
		}
		while(M > 0) {
			dlist = new ArrayList<Dist>();
			if(!findGuest()) {
				bw.write("-1");
				break;
			}
			else {
				Collections.sort(dlist);
				taxi[0] = dlist.get(0).y;
				taxi[1] = dlist.get(0).x;
				oil -= dlist.get(0).cost;
				if(goToDt(dlist.get(0).gn)) {
					--M;
				}
				else {
					bw.write("-1");
					break;
				}
			}
		}
		
		if(M <= 0) {
			bw.write(Integer.toString(oil));
		}
		bw.flush();
	}
}
class Guest{
	int[] ed;
	int num;
	Guest(int num, int ey, int ex){
		this.num = num;
		ed = new int[2];
		ed[0] = ey;
		ed[1] = ex;
	}
}
class Dist implements Comparable<Dist>{
	int gn;
	int cost;
	int y;
	int x;
	public Dist(int gn, int cost, int y, int x) {
		this.gn = gn;
		this.cost = cost;
		this.y = y;
		this.x =x;
	}
	@Override
	public int compareTo(Dist o) {
		if(this.cost == o.cost) {
			if(this.y == o.y) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}
		return this.cost - o.cost;
	}
}