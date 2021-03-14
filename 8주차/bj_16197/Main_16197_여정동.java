import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16197_여정동{
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int N,M;
	static char[][] map;
	static boolean iv[][][][] = new boolean[20][20][20][20];
	static int y0, x0, y1, x1;
	
	static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		int[] temp = {y0, x0, y1, x1, 0};
		q.offer(temp);
		iv[y0][x0][y1][x1] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int ny0, nx0, ny1, nx1;
			for(int d = 0; d < 4; d++) {
				ny0 = now[0] + dy[d];
				nx0 = now[1] + dx[d];
				ny1 = now[2] + dy[d];
				nx1 = now[3] + dx[d];
				if(now[4]>9) continue;
				if(ny0 > -1 && ny0 < N && nx0 > -1 && nx0 < M && map[ny0][nx0]=='#') {
					ny0 = now[0];
					nx0 = now[1];
				}
				if(ny1 > -1 && ny1 < N && nx1 > -1 && nx1 < M && map[ny1][nx1]=='#') {
					ny1 = now[2];
					nx1 = now[3];
				}
				if(((ny0 < 0 || nx0 < 0 || ny0 > N-1 || nx0 > M-1)&&((ny1 > -1 && nx1 > -1 && ny1 < N && nx1 < M))) ||
						((ny1 < 0 || nx1 < 0 || ny1 > N-1 || nx1 > M-1)&&(ny0 > -1 && nx0 > -1 && ny0 < N && nx0 < M))) {
					return now[4]+1;
				}
				else if((ny0 < 0 || nx0 < 0 || ny0 > N-1 || nx0 > M-1)&&(ny1 < 0 || nx1 < 0 || ny1 > N-1 || nx1 > M-1)) {
					continue;
				}
				else if((ny0 > -1 && nx0 > -1 && ny0 < N && nx0 < M) && (ny1 > -1 && nx1 > -1 && ny1 < N && nx1 < M) && !iv[ny0][nx0][ny1][nx1]){
					iv[ny0][nx0][ny1][nx1] = true;
					int[] next = {ny0, nx0, ny1, nx1, now[4]+1};
					q.offer(next);
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		boolean cf = false;
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='o'&&!cf) {
					cf = true;
					y0 = i;
					x0 = j;
				}
				else if(map[i][j]=='o'&&cf) {
					y1 = i;
					x1 = j;
				}
			}
		}
		int result = bfs();
		bw.write(Integer.toString(result));
		bw.flush();
	}
}