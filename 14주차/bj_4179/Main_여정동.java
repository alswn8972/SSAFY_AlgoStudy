import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_여정동 {
	static char[][] map;
	static int R, C, min = Integer.MAX_VALUE;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static boolean[][] iv;
	static Queue<int[]> ji = new LinkedList<int[]>();
	static Queue<int[]> q = new LinkedList<int[]>();
	
	static boolean simulation() {
		int timer = 1;
		while(true) {
			if(isEsc()) {
				min = timer;
				return true;
			}
			burn();	
			if(!run()) break;
			timer++;
		}
		return false;
	}
	
	static boolean isEsc() {
		int ed = ji.size();
		int i = 0;
		while(i < ed) {
			int[] now = ji.poll();
			if(now[0] == R-1 || now[0] == 0 || now[1] == C-1 || now[1] == 0) {
				return true;
			}
			else {
				ji.offer(now);
			}
			i++;
		}
		return false;
	}
	
	static boolean run() {
		boolean save = false;
		int ed = ji.size();
		int i = 0;
		while(i < ed) {
			int[] now = ji.poll(); 
			int ny, nx;
			for(int d = 0; d < 4; d++) {
				ny = now[0] + dy[d];
				nx = now[1] + dx[d];
				if(ny < R && nx < C && ny > -1 && nx > -1 && map[ny][nx] == '.' && !iv[ny][nx]) {
					int[] next = {ny, nx};
					ji.offer(next);
					save = true;
					iv[ny][nx] = true;
				}
			}
			i++;
		}
		return save;
	}
	
	static void burn() {
		int ed = q.size();
		int i = 0;
		while(i < ed) {
			int[] now = q.poll(); 
			int ny, nx;
			for(int d = 0; d < 4; d++) {
				ny = now[0] + dy[d];
				nx = now[1] + dx[d];
				if(ny < R && nx < C && ny > -1 && nx > -1 && map[ny][nx] == '.') {
					map[ny][nx] = 'F';
					int[] next = {ny, nx};
					q.offer(next);
				}
			}
			i++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		iv = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'J') {
					int[] p = {i,j};
					ji.offer(p);
					map[i][j] = '.';
					iv[i][j] = true;
				}
				else if(map[i][j] == 'F') {
					int[] fire = {i,j};
					q.offer(fire);
				}
			}
		}
		
		if(simulation()) {
			System.out.println(min);
			return;
		}
		System.out.println("IMPOSSIBLE");
	}
}
