import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N16236_아기상어 {
	static class shark{
		int x;
		int y;
		int size;
		int time;
		int fish;
		public shark(int x, int y, int size, int time,int fish) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.time = time;
			this.fish = fish;
		}
		
		
	}
	
	static class CurL{
		int x;
		int y;
		int dis;
		public CurL(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
		@Override
		public String toString() {
			return "CurL [x=" + x + ", y=" + y + ", dis=" + dis + "]";
		}
		
	}
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//아기상어 크기 2 시작 9
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		
		shark s=new shark(0,0,0,0,0);
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] =Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					s=new shark(i, j, 2, 0,0);
					map[i][j]=0;
				}
			}
		}
		
		while(true) {
			shark temp = bfs(s);
			if(temp.x==21) {
				System.out.println(temp.time);
				return;
			}
			
			s=temp;
		}
		
		
		
	}
	public static shark bfs(shark s) {
		int mindis = 401; // 최소거리
		int eat=s.fish;
		int[] answer = new int[]{21,21};
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		int N = map.length;
		boolean[][] v = new boolean[N][N];
		v[s.x][s.y]=true;
		Queue<CurL> q = new LinkedList<>();
		q.add(new CurL(s.x,s.y,0));
		CurL cur;
		while(!q.isEmpty()) {
			cur=q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx==0&&ny==1) {
					int degug=1;
				}
				// 최소거리보다 더 멀 경우, 아기상어보다 몸집이 큰경우
				if(nx<0||ny<0||nx>=N||ny>=N||v[nx][ny]||mindis<cur.dis||s.size<map[nx][ny])continue;
				//0
				q.add(new CurL(nx,ny,cur.dis+1));
				v[nx][ny]=true;
				if(s.size==map[nx][ny]||map[nx][ny]==0) {
					continue;
				}else if(s.size>map[nx][ny]) {
					
					if(mindis==cur.dis+1&&nx==answer[0]&&ny<answer[1]) { //이동거리가 같은데 같은 x축
						answer=new int[] {nx,ny};
						mindis=cur.dis+1;
					}
					if(mindis==cur.dis+1&&answer[0]>nx) { // 이동거리가 같은경우  가장 위쪽
						answer=new int[] {nx,ny};
						mindis=cur.dis+1;
					}
					if(mindis>cur.dis+1) { //이동거리가 작은경우
						answer=new int[] {nx,ny};
						mindis=cur.dis+1;
					}
				}
				
			}
		}
		shark re;
		
		if(mindis==401) {
			re= new shark(answer[0], answer[1], s.size, s.time,eat);
			return re;
		}
		map[answer[0]][answer[1]]=0;
		eat++;
		if(eat==s.size) {
			s.size++;
			eat=0;
		}
		re = new shark(answer[0], answer[1], s.size, s.time+mindis,eat);
		return re;
	}

}
