import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_유시준 { 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int a[][]=new int[21][21];
	static int visit[][]=new int[21][21];
	static boolean chk[]=new boolean[500];
	static ArrayList<Node> list=new ArrayList<>();;
	static int n,m,k;
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static Queue<Graph> q=new LinkedList<>();
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				a[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(br.readLine());
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		a[x][y]=2;
		list.add(new Node(0,0,0,0));
		list.add(new Node(0,0,0,0));
		for(int i=1;i<=m;i++) {
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			a[x1][y1]=i+1;
			list.add(new Node(x1,y1,x2,y2));
		}
		int cnt=0;
		while(true) {
			if(cnt==m) break;
			memset();
			visit[x][y]=1;
			q.add(new Graph(x,y));
			bfs();
			int mx=0;
			int my=0;
			int dist=100000;
			for(int i=2;i<m+2;i++) {
				int x1=list.get(i).sx;
				int y1=list.get(i).sy;
				if(visit[x1][y1]==0) continue;
				if(chk[i]) continue;
				if(dist>visit[x1][y1]-1) {
					dist=visit[x1][y1]-1;
					mx=x1;
					my=y1;
				}
				else if(dist==visit[x1][y1]-1&&mx>x1) {
					mx=x1;
					my=y1;
				}else if(dist==visit[x1][y1]-1&&mx==x1&&my>y1) {
					mx=x1;
					my=y1;
				}
			}
			if(mx==0&&my==0) {
				k=-1;
				break;
			}
			if(k<dist) {
				k=-1;
				break;
			}
			x=mx;
			y=my;
			k-=dist;
			memset();
			visit[x][y]=1;
			q.add(new Graph(x,y));
			bfs();
			if(a[x][y]==0) {
				k=-1;
				break;
			}
			chk[a[x][y]]=true;
			mx=list.get(a[x][y]).ex;
			my=list.get(a[x][y]).ey;
			a[x][y]=0;
			x=mx;
			y=my;
			if(visit[x][y]==0) {
				k=-1;
				break;
			}
			dist=visit[x][y]-1;
			if(k<dist) {
				k=-1;
				break;
			}
			k+=dist;
			cnt++;
		}
		bw.write(Integer.toString(k));
		bw.flush();
	}
	static void memset() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				visit[i][j]=0;
			}
		}
	}
	static void bfs() {
		while(!q.isEmpty()) {
			int x=q.peek().x;
			int y=q.peek().y;
			q.poll();
			for(int i=0;i<4;i++) {
				int mx=x+dx[i];
				int my=y+dy[i];
				if(mx<1||my<1||mx>n||my>n)continue;
				if(visit[mx][my]!=0) continue;
				if(a[mx][my]==1) continue;
				q.add(new Graph(mx,my));
				visit[mx][my]=visit[x][y]+1;
			}
		}
	}
}
class Node{
	int sx,sy,ex,ey;

	public Node(int sx, int sy, int ex, int ey) {
		super();
		this.sx = sx;
		this.sy = sy;
		this.ex = ex;
		this.ey = ey;
	}
	
}
class Graph{
	int x,y;
	public Graph(int x, int y) {
		this.x = x;
		this.y = y;
	}
}