import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_문영화 {
	static class fire{
		int x,y,t;

		public fire(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
			
		}

		@Override
		public String toString() {
			return "fire [x=" + x + ", y=" + y + ", t=" + t + "]";
		}
		
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		int[][] firevtd = new int[R][C];
		int[] jh= {};
		boolean[][] v= new boolean[R][C];
		Queue<fire> q = new LinkedList<>(); 
		for(int i=0;i<R;i++) {
			String s =br.readLine();
			for(int j=0;j<C;j++) {
				char c =s.charAt(j);
				if(c=='J') {
					jh = new int[] {i,j};
				}else if(c=='F') {
					q.offer(new fire(i,j,1));
					firevtd[i][j]=1;
					v[i][j]=true;
				}else if(c=='#') {
					firevtd[i][j]=-1;
				}
				map[i][j]=c;
			}
		}
		fire f;
		while(!q.isEmpty()) {
			f=q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = f.x+dx[i];
				int ny = f.y+dy[i];
				
				if(nx<0||ny<0||nx>=R||ny>=C||v[nx][ny]) continue;
				
				if(map[nx][ny]!='#') {
					firevtd[nx][ny]=f.t;
					q.offer(new fire(nx,ny,f.t+1));
					v[nx][ny]=true;
				}
				
			}
			
		}
		v= new boolean[R][C];
		q.offer(new fire(jh[0],jh[1],1));
		v[jh[0]][jh[1]]=true;
		
		while(!q.isEmpty()) {
			f=q.poll();
			if(f.x==R-1||f.x==0||f.y==C-1||f.y==0) {
				System.out.println(f.t);
				return;
			}
			for(int i=0;i<4;i++) {
				int nx = f.x+dx[i];
				int ny = f.y+dy[i];
				
				if(nx<0||ny<0||nx>=R||ny>=C||v[nx][ny]) continue;
				
				if(firevtd[nx][ny]>f.t||firevtd[nx][ny]==0) {
					q.offer(new fire(nx,ny,f.t+1));
					v[nx][ny]=true;
				}
				
			}
		}
		System.out.println("IMPOSSIBLE");
	}

}
