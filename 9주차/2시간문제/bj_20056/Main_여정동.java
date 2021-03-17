import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_여정동{
	static int N, M, K, turns;
	static Location[][] map;
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	
	static void move(Fireball fb) {
		int ny = fb.r + dy[fb.d] * fb.s % N;
		int nx = fb.c + dx[fb.d] * fb.s % N;
		
		if(ny < 1) ny = N - (Math.abs(ny) % N);
		else if(ny > N) ny %= N;	
		if(nx < 1) nx = N - (Math.abs(nx) % N);
		else if(nx > N) nx %= N;
		
		fb.r = ny;
		fb.c = nx;
		fb.turn++;
		map[fb.r][fb.c].q.offer(fb);
	}
	
	static void div(int y, int x) {
		int sm = 0, ss = 0;
		int odd_count = 0;
		int ev_count = 0;
		while(!map[y][x].q.isEmpty()) {
			Fireball temp = map[y][x].q.poll();
			sm += temp.m;
			ss += temp.s;
			if(temp.d % 2 != 1) ev_count++;
			else odd_count++;
		}
		sm /= 5;
		ss /= (ev_count+odd_count);
		int d;
		if(odd_count == 0 || ev_count == 0) {
			d = 0;	
		}
		else {
			d = 1;
		}
		for(int i = 0; i < 4; i++) {
			if(sm <= 0) break;
			Fireball ntemp = new Fireball(turns+1, y, x, sm, ss, d);
			d += 2;
			map[y][x].q.add(ntemp);
		}
	}
	
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Location[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				map[i][j] = new Location();
			}
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());//질량
			int s = Integer.parseInt(st.nextToken());//위치
			int d = Integer.parseInt(st.nextToken());//속력
			Fireball fb_temp = new Fireball(0, r, c, m, s, d);			
			map[r][c].q.offer(fb_temp);  
		}
		
		for(turns = 0; turns < K; turns++) {	
			for(int y = 1; y <= N; y++) {
				for(int x = 1; x <= N; x++) {
					while(!map[y][x].q.isEmpty() && map[y][x].q.peek().turn == turns) {
						move(map[y][x].q.poll());
					}
				}
			}
			
			for(int y = 1 ; y <= N; y++) {
				for(int x = 1; x <= N; x++) {
					if(map[y][x].q.size() >= 2) {
						div(y,x);
					}
				}
			}
		}
		
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				while(!map[i][j].q.isEmpty()) {
					sum += map[i][j].q.poll().m;
				}
			}
		}
		
		bw.write(Integer.toString(sum));
		bw.flush();
	}
}
class Fireball{
	int turn;
	int r;
	int c;
	int m;
	int s;
	int d;
	Fireball(int t, int r, int c, int m, int s, int d) {
		this.turn = t;
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}
}
class Location{
	Queue<Fireball> q = new LinkedList<Fireball>();
}