import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_강민주 {
	static int M,N,x,y,d,rx,ry,rd;
	static int[][] map;
	
	static int[] dx={0,0,0,1,-1};
	static int[] dy={0,1,-1,0,0};
	static int result=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());;
		
		M=Integer.parseInt(st.nextToken());//세로
		N=Integer.parseInt(st.nextToken());//가로
		map=new int[M+1][N+1];
		

		for(int i=1;i<=M;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}	
		}

		st=new StringTokenizer(br.readLine());
		rx=Integer.parseInt(st.nextToken());
		ry=Integer.parseInt(st.nextToken());
		rd=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		
		

		bfs();
		System.out.println(result);

	}
	static void bfs() {
		Queue<Point> que=new LinkedList<>();
		boolean[][][] v=new boolean[M+1][N+1][5];
		que.offer(new Point(rx,ry,rd,0));
		v[rx][ry][rd]=true;
		while(!que.isEmpty()) {
			Point cur=que.poll();
			if(cur.sx==x&&cur.sy==y&&cur.sd==d) {
				result=cur.sc;
				return;
			}
			
			for(int i=1;i<=3;i++) {
				int nx=cur.sx+dx[cur.sd]*i;
				int ny=cur.sy+dy[cur.sd]*i;
				if(nx<=0||ny<=0||nx>M||ny>N) continue;
				if(v[nx][ny][cur.sd]==true) continue;
				if(map[nx][ny]==0) {
                    v[nx][ny][cur.sd]=true;
					que.offer(new Point(nx,ny,cur.sd,cur.sc+1));	
				}
				else {
					break;
				}				
			}
			switch(cur.sd) {
			case 1:
			case 2:
				if(v[cur.sx][cur.sy][3]==false) {
					v[cur.sx][cur.sy][3]=true;
					que.offer(new Point(cur.sx,cur.sy,3,cur.sc+1));
				}
				if(v[cur.sx][cur.sy][4]==false) {
					v[cur.sx][cur.sy][4]=true;				
					que.offer(new Point(cur.sx,cur.sy,4,cur.sc+1));
				}
				break;
			case 3:
			case 4:
				if(v[cur.sx][cur.sy][1]==false) {
					v[cur.sx][cur.sy][1]=true;
					que.offer(new Point(cur.sx,cur.sy,1,cur.sc+1));
				}
				if(v[cur.sx][cur.sy][2]==false) {
					v[cur.sx][cur.sy][2]=true;
					que.offer(new Point(cur.sx,cur.sy,2,cur.sc+1));
				}
				break;
			}


		}
	}

	static class Point{
		int sx;
		int sy;
		int sd;
		int sc;
		Point(int sx, int sy, int sd, int sc){
			this.sx=sx;
			this.sy=sy;
			this.sd=sd;
			this.sc=sc;
		}
	}
}
