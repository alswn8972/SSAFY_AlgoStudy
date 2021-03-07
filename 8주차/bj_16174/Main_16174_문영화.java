import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16174_문영화 {
	static int N;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v=new boolean[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
	}
	
	public static void bfs() {
		int[] dx= {0,1};
		int[] dy= {1,0};
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0,0});
		v[0][0]=true;
		int[] temp;
		while(!queue.isEmpty()) {
			temp=queue.poll();
			for(int i=0;i<2;i++) {
				int nx = temp[0]+dx[i]*map[temp[0]][temp[1]];
				int ny = temp[1]+dy[i]*map[temp[0]][temp[1]];
				
				if(nx<0||ny<0||nx>=N||ny>=N||v[nx][ny]) continue;
				if(nx==N-1&&ny==N-1) {
					System.out.println("HaruHaru");
					return;
				}
				queue.offer(new int[] {nx,ny});
				v[nx][ny]=true;
			}
		}
		System.out.println("Hing");
	}
}
