import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_여정동{
	static int N, M, c;
	static boolean[][] in;
	static boolean[][] iv;
	static int[][] map;
	static ArrayList<Integer> counter = new ArrayList<Integer>();
	static int gid = 0, max = 0;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static void dfs(int i, int j, int gid) {
		map[i][j] = gid;
		int ny, nx;
		iv[i][j] = true;
		++c;
		for(int d = 0; d < 4 ; d++) {
			ny = i + dy[d];
			nx = j + dx[d];
			if(ny > -1 && nx > -1 && ny < N && nx < M && !iv[ny][nx] && in[ny][nx]) {
				dfs(ny,nx,gid);
			}
		}
	}
	
	private static int sd(int y, int x) {
		int[] ids = new int[4];
		int ny,nx,count=1;
		for(int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if(ny > -1 && nx > -1 && ny < N && nx < M) {
				boolean flag = true;
				for(int j = 0; j < i; j++) {
					if(ids[j] == map[ny][nx]) {
						flag = false;
						break;
					}
				}
				if(flag) {
					ids[i] = map[ny][nx];
					if(map[ny][nx] >= 1) {
						count += counter.get(map[ny][nx]-1);
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		in = new boolean[N][M];
		iv = new boolean[N][M];
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				if(st.nextToken().equals("1"))
					in[i][j] = true;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M ; j++) {
				if(in[i][j] && !iv[i][j]) {
					++gid;
					c = 0;
					dfs(i,j,gid);
					counter.add(c);
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!in[i][j]) {
					max = Math.max(max, sd(i,j));
				}
			}
		}
		
		bw.write(Integer.toString(max));
		bw.flush();
	}

}