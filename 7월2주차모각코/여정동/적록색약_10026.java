import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약_10026 {
	static int N;
	static char[][] map;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static boolean[][] vi;
	
	static int[] count() {
		int result0 = 0;
		int result1 = 0;
		
		vi = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!vi[i][j]) {
					result0++;
					bfs0(i, j);
				}
			}
		}
		
		vi = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!vi[i][j]) {
					result1++;
					if(map[i][j] == 'B') bfs0(i,j);
					else bfs1(i,j);
				}
			}
		}
		
		int[] result = {result0, result1};
		return result;
	}
	
	private static void bfs1(int i, int j) {
		
		Queue<int[]> q = new LinkedList<int[]>();
		vi[i][j] = true;
		int[] temp  = {i,j};
		q.offer(temp);
		
		int ny, nx;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int d = 0; d < 4; d++) {
				ny = now[0] + dy[d];
				nx = now[1] + dx[d];
				if(ny < N && nx < N && ny > -1 && nx > -1 && !vi[ny][nx] && (map[ny][nx] == 'R' || map[ny][nx] == 'G')) {
					vi[ny][nx] = true;
					int[] next = {ny, nx};
					q.offer(next);
				}
			}
		}
	}

	private static void bfs0(int i, int j) {
		char c = map[i][j];
		Queue<int[]> q = new LinkedList<int[]>();
		vi[i][j] = true;
		int[] temp  = {i,j};
		q.offer(temp);
		
		int ny, nx;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int d = 0; d < 4; d++) {
				ny = now[0] + dy[d];
				nx = now[1] + dx[d];
				if(ny < N && nx < N && ny > -1 && nx > -1 && !vi[ny][nx] && map[ny][nx] == c) {
					vi[ny][nx] = true;
					int[] next = {ny, nx};
					q.offer(next);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int[] result = count();
		System.out.println(result[0] + " " + result[1]);
	}
}
