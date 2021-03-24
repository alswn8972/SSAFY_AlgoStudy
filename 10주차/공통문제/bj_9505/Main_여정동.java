import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_여정동 {
	static int K, W, H, sy, sx;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] map;
	static Map<Character, Integer> cos;
	static int min_cost;
	static PriorityQueue<Node> pq;

	static void dij() {
		boolean[][] iv = new boolean[H][W];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		int[][] cost = new int[H][W];
		pq.offer(new Node(sy, sx, 0));
		
		for(int i = 0; i < H; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}
		
		cost[sy][sx] = 0;
		int ny=0, nx=0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.y == 0 || now.x == 0 || now.y == H-1 || now.x == W-1) {
				min_cost = Math.min(min_cost, now.v);
				continue;
			}
			
			if(iv[now.y][now.x]) continue;
			iv[now.y][now.x] = true;
			
			for(int d = 0; d < 4; d++) {
				ny = now.y + dy[d];
				nx = now.x + dx[d];
				if(!iv[ny][nx] && cost[ny][nx] > map[ny][nx] + now.v) {
					cost[ny][nx] = map[ny][nx] + now.v;
					pq.offer(new Node(ny,nx,cost[ny][nx]));
				}
			}
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			cos = new HashMap<Character, Integer>();
			map = new int[H][W];
			
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				char key = st.nextToken().charAt(0);
				int val = Integer.parseInt(st.nextToken());
				cos.put(key, val);
			}
			for(int i = 0; i < H; i++) {
				String m = br.readLine();
				for(int j = 0; j < W; j++) {
					char input = m.charAt(j);
					if(input == 'E') {
						sy = i;
						sx = j;
						map[i][j] = 0;
					}
					else {
						map[i][j] = cos.get(input);
					}
				}
			}

			if(sy == 0 || sy == H-1 || sx == 0 || sx == W-1) {
				bw.write("0\n");
			}

			else {
				min_cost = Integer.MAX_VALUE;

				dij();

				bw.write(min_cost+"\n");
			}
		}
		bw.flush();
	}
	
	static class Node implements Comparable<Node>{
		int y;
		int x;
		int v;
		Node(int y, int x, int v){
			this.y = y;
			this.x = x;
			this.v = v;
		}
		@Override
		public int compareTo(Node o) {
			return this.v - o.v;
		}
	}
}


