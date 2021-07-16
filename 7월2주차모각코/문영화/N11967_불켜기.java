package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11967_ºÒÄÑ±â {

	static boolean[][] light;
	static int N;
	static boolean[][] v;
	static boolean[][] room;
	static boolean[][] go;
	static HashMap<String, String> map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()) + 1;
		int M = Integer.parseInt(st.nextToken());
		v = new boolean[N][N];
		light = new boolean[N][N];
		room = new boolean[N][N];
		go = new boolean[N][N];
		light[1][1] = true;
		go[1][1] = true;
		go[1][2] = true;
		go[2][1] = true;
		v[1][1] = true;
		
		
		map = new HashMap<>();
		String key = "";
		String val = "";
		String temp = "";
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			key = "";
			val = "";

			key += st.nextToken();
			key += ",";
			key += st.nextToken();

			val += st.nextToken();
			val += ",";
			val += st.nextToken();
			val += "/";

			if (map.containsKey(key)) {
				temp = map.get(key);
				temp += val;
				map.put(key, temp);
			} else {
				map.put(key, val);
			}

		}

		bfs();
		int ans = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (light[i][j])
					ans++;
			}
		}
		System.out.println(ans);

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void bfs() {

		Queue<int[]> q = new LinkedList<>();
		StringTokenizer st,st2;
		q.add(new int[] { 1, 1 });
		int[] cur;
		int cx, cy;
		while (!q.isEmpty()) {
			cur = q.poll();
			cx = cur[0];
			cy = cur[1];
			if (!room[cx][cy]) {
				String str = cx + "," + cy;

				if (map.containsKey(str)) {
					st = new StringTokenizer(map.get(str), "/");
					room[cx][cy] = true;
					while (st.hasMoreTokens()) {
						str = st.nextToken();
						if (str.equals(""))
							break;
						st2 = new StringTokenizer(str,",");
						int lx = Integer.parseInt(st2.nextToken());
						int ly = Integer.parseInt(st2.nextToken());
						light[lx][ly] = true;
						
					}

				}
				for(int i=0;i<4;i++) {
					int nx = cx+dx[i];
					int ny = cy+dy[i];
					
					if(nx<0||ny<0||nx>=N||ny>=N)continue;
					go[nx][ny]=true;
				}
				for (int i = 1; i < N; i++) {
					for (int j = 1; j < N; j++) {
						if(v[i][j]||!light[i][j]||!go[i][j])continue;
						q.add(new int[] {i,j});
						v[i][j]=true;
					}
				}

			}

		}
	}

}
