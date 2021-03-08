import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] iv; 
	static int[] dy = {0,1};
	static int[] dx = {1,0};
	
	static boolean bfs() {
		int[] temp = {0,0};
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(temp);
		iv[0][0] = true;
		int ny,nx;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int j = map[now[0]][now[1]];
			if(j == -1) return true;
			for(int d = 0; d < 2; d++) {
				ny = now[0] + (j * dy[d]);
				nx = now[1] + (j * dx[d]);
				if(ny > -1 && ny < N && nx > -1 && nx < N && !iv[ny][nx]) {
					iv[ny][nx] = true;
					int[] next = {ny,nx};
					q.offer(next);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		iv = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(bfs()) bw.write("HaruHaru");
		else { bw.write("Hing"); };
		bw.flush();
	}

}
