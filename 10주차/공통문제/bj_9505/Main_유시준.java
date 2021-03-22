import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int dist[][]=new int[1000][1000];
	static boolean visit[][]=new boolean[1000][1000];
	static int a[]=new int[26];
	static int n,w,h,T;
	static char b[][]=new char[1000][1000];
	static PriorityQueue<Node> pq=new PriorityQueue<>();
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		T=Integer.parseInt(br.readLine());
		while(T-->0) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			int x=0,y=0;
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				char c=st.nextToken().charAt(0);
				int now=Integer.parseInt(st.nextToken());
				a[c-'A']=now;
			}
			for(int i=0;i<w;i++) {
				String now=br.readLine();
				for(int j=0;j<h;j++) {
					b[i][j]=now.charAt(j);
					if(b[i][j]=='E') {
						x=i;
						y=j;
					}
				}
			}
			memset();
			pq.add(new Node(0,x,y));
			dist[x][y]=0;
			int ans=1000000000;
			while(!pq.isEmpty()) {
				x=pq.peek().x;
				y=pq.peek().y;
				pq.poll();
				if(x==0||y==0||x==w-1||y==h-1) {
					ans=Math.min(ans, dist[x][y]);
				}
				if(visit[x][y]) continue;
				visit[x][y]=true;
				for(int i=0;i<4;i++) {
					int mx=x+dx[i];
					int my=y+dy[i];
					if(mx<0||my<0||mx>=w||my>=h) continue;
					int cost=a[b[mx][my]-'A'];
					if(dist[mx][my]>dist[x][y]+cost) {
						dist[mx][my]=dist[x][y]+cost;
						pq.add(new Node(dist[mx][my],mx,my));
					}
				}
			}
			bw.write(Integer.toString(ans)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void memset() {
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				dist[i][j]=1000000000;
				visit[i][j]=false;
			}
		}
	}
}
class Node implements Comparable<Node>{
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.cost-o.cost;
	}
	int cost;
	int x,y;
	public Node(int cost, int x, int y) {
		super();
		this.cost = cost;
		this.x = x;
		this.y = y;
	}

	
	
}