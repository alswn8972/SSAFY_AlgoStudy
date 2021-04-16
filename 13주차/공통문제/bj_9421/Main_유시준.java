import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_유시준 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static long MOD=1000000007;
    static int n,m;
    static int visit[]=new int[1000001];
    static boolean d[]=new boolean[1000001];
    static boolean prime[]=new boolean[1000001];
    static Queue<Integer> q=new LinkedList<>();
	public static void main(String[] args) throws IOException {
		int n=Integer.parseInt(br.readLine());
		visit[1]=1;
		d[1]=true;
		primeNum();
		for(int i=2;i<=n;i++) {
			if(visit[i]!=0) continue;
			visit[i]=i;
			q.add(i);
			bfs(i);
		}
		for(int i=2;i<=n;i++) {
			if(prime[i]) continue;
			if(!d[visit[i]]) continue;
			bw.write(i+"\n");
		}
		bw.flush();
        bw.close();
        br.close();
	}
	static void primeNum() {
		for(int i=2;i<=1000000;i++) {
			if(prime[i]) continue;
			for(int j=i*2;j<=1000000;j+=i) {
				prime[j]=true;
			}
		}
	}
	static void bfs(int k) {
		while(!q.isEmpty()) {
			int x=q.poll();
			int next=0;
			while(x>0) {
				next+=((x%10)*(x%10));
				x/=10;
			}
			if(next==1) {
				d[k]=true;
			}else {
				if(visit[next]!=0 && !d[visit[next]]) {
					d[k]=false;
					break;
				}
				visit[next]=k;
				q.add(next);
			}
		}
		while(!q.isEmpty()) {
			q.poll();
		}
	}
}
