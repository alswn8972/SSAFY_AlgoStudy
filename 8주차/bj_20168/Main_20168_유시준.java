import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main { 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int graph[][]=new int[11][11];
	static boolean visit[]=new boolean[11];
	static int n,m,a,b,c,ans;
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		a=Integer.parseInt(st.nextToken());
		b=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		for(int i=1;i<=m;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int cos=Integer.parseInt(st.nextToken());
			graph[s][e]=cos;
			graph[e][s]=cos;
		}
		visit[a]=true;
		ans=100000;
		dfs(a,1,0,0);
		bw.write(Integer.toString((ans==100000?-1:ans)));
		bw.flush();
	}
	static void dfs(int now,int depth,int cost,int max) {
		if(now==b) {
			ans=Math.min(ans, max);
			return;
		}
		if(depth==n) return;
		for(int i=1;i<=n;i++) {
			if(graph[now][i]==0) continue;
			if(visit[i])continue;
			if(cost+graph[now][i]>c) continue;
			visit[i]=true;
			dfs(i,depth+1,cost+graph[now][i],Math.max(max, graph[now][i]));
			visit[i]=false;
		}
	}
}