import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static int a[][]=new int[101][101];
	static int visit[][][]=new int[101][101][5];
	static int dx[]= {0,0,0,1,-1};
	static int dy[]= {0,1,-1,0,0};
	static Queue<Pos> q=new LinkedList<>();
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=m;j++) {
				a[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(br.readLine());
		int x,y,dir;
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		dir=Integer.parseInt(st.nextToken());
		q.offer(new Pos(x,y,dir));
		visit[x][y][dir]=1;
		bfs();
		st=new StringTokenizer(br.readLine());
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		dir=Integer.parseInt(st.nextToken());
		bw.write(Integer.toString(visit[x][y][dir]-1));
		bw.flush();
		bw.close();
		br.close();
	}
	static void bfs() {
		while(!q.isEmpty()) {
			int x=q.peek().x;
			int y=q.peek().y;
			int dir=q.peek().dir;
			q.poll();
			for(int k=1;k<=3;k++) {
				int mx=x+dx[dir]*k;
				int my=y+dy[dir]*k;
				if(mx<1||my<1||mx>n||my>m) break;
				if(visit[mx][my][dir]!=0) continue;
				if(a[mx][my]==1) break;
				visit[mx][my][dir]=visit[x][y][dir]+1;
				q.offer(new Pos(mx,my,dir));
			}	
			for(int i=1;i<=4;i++) {
				if(visit[x][y][i]!=0) continue;
				if(dir==1) {
					if(i==2) {
						visit[x][y][i]=visit[x][y][dir]+2;
					}else {
						visit[x][y][i]=visit[x][y][dir]+1;
					}
				}else if(dir==2) {
					if(i==1) {
						visit[x][y][i]=visit[x][y][dir]+2;
					}else {
						visit[x][y][i]=visit[x][y][dir]+1;
					}
				}else if(dir==3) {
					if(i==4) {
						visit[x][y][i]=visit[x][y][dir]+2;
					}else {
						visit[x][y][i]=visit[x][y][dir]+1;
					}
				}else if(dir==4) {
					if(i==3) {
						visit[x][y][i]=visit[x][y][dir]+2;
					}else {
						visit[x][y][i]=visit[x][y][dir]+1;
					}
				}
				q.offer(new Pos(x,y,i));
			}
					
		}
	}
}
class Pos{
	int x;
	int y;
	int dir;
	public Pos(int x, int y, int dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
}
