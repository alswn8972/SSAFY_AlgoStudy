import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_유시준 { 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int a[][]=new int[1001][1001];
	static int visit[][]=new int[1001][1001];
	static Queue<Pos> q=new LinkedList<>();
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static int cnt[]=new int[500001];
	static int n,m,k;
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=m;j++) {
				a[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int idx=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(visit[i][j]!=0) continue;
				if(a[i][j]==1) {
					visit[i][j]=idx;
					q.offer(new Pos(i,j));
					cnt[idx++]=bfs();
				}
			}
		}
		int ans=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(a[i][j]==1) continue;
				int now=0;
				Set<Integer> s=new HashSet<>();
				for(int k=0;k<4;k++) {
					int mx=i+dx[k];
					int my=j+dy[k];
					if(mx<1||my<1||mx>n||my>m) continue;
					if(s.contains(visit[mx][my])) continue;
					s.add(visit[mx][my]);
					now+=cnt[visit[mx][my]];
				}
				ans=Math.max(now, ans);
			}
		}
		bw.write(Integer.toString(ans+1));
		bw.flush();
	}
	static int bfs() {
		int ret=0;
		while(!q.isEmpty()) {
			ret++;
			int x=q.peek().x;
			int y=q.peek().y;
			q.poll();
			for(int i=0;i<4;i++) {
				int mx=x+dx[i];
				int my=y+dy[i];
				if(mx<1||my<1||mx>n||my>m) continue;
				if(visit[mx][my]!=0) continue;
				if(a[mx][my]==0) continue;
				visit[mx][my]=visit[x][y];
				q.offer(new Pos(mx,my));
			}
		}
		return ret;
	}
}
class Pos{
	int x,y;

	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

