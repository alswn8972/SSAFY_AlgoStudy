import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16174_유시준 { 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int a[][]=new int[65][65];
	static boolean visit[][]=new boolean[65][65];
	static int n;
	static int dx[]= {0,1};
	static int dy[]= {1,0};
	static Queue<Graph> q=new LinkedList<>();
	public static void main(String[] args) throws IOException { 
		n=Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				a[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		q.add(new Graph(1,1));
		visit[1][1]=true;
		bfs();
		bw.write((visit[n][n]?"HaruHaru":"Hing"));
		bw.flush();
	}
	static void bfs() {
		while(!q.isEmpty()) {
			int x=q.peek().x;
			int y=q.peek().y;
			int k=a[x][y];
			q.poll();
			for(int i=0;i<2;i++) {
				int mx=x+dx[i]*k;
				int my=y+dy[i]*k;
				if(mx<1||my<1||mx>n||my>n) continue;
				if(visit[mx][my]) continue;
				q.add(new Graph(mx,my));
				visit[mx][my]=true;
			}
		}
	}
}
class Graph{
	int x,y;

	public Graph(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
}