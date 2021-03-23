import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class N16932 {

	static int[][] map;
	static int[][] check;
	static boolean[][] v;
	static int N,M;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int maxbfs=0;
	static int group=1;
	static HashMap<Integer, Integer> nodegroup= new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		nodegroup.put(0, 0);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new int[N][M];
		v= new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				if(map[i][j]==1&&!v[i][j]) {
					v[i][j]=true;
					bfs(i,j,group);
					group++;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				Set<Integer> set = new HashSet<>();
				int cnt=1;
				if(map[i][j]==0) {
					for(int k=0;k<4;k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx<0||ny<0||nx>=N||ny>=M) continue;
						set.add(map[nx][ny]);
					}
					Iterator<Integer> key = set.iterator();
					while(key.hasNext()) {
						cnt+=nodegroup.get(key.next());
					}
					maxbfs = Math.max(maxbfs, cnt);
				}
			}
		}
		System.out.println(maxbfs);
	}
	public static void bfs(int x, int y, int g) {
		
		int cnt=1;
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x,y});
		while(!q.isEmpty()) {
			int[] tp = q.poll();
			map[tp[0]][tp[1]]=g;
			for(int k=0;k<4;k++) {
				int nx = tp[0]+dx[k];
				int ny = tp[1]+dy[k];
				if(nx<0||ny<0||nx>=N||ny>=M||map[nx][ny]==0||v[nx][ny]) continue;
				q.offer(new int[] {nx,ny});
				v[nx][ny]=true;
				cnt++; 
			}
		}
		nodegroup.put(group, cnt);
	}

}

