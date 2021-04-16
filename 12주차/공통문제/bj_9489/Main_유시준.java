import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_유시준 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static long MOD=1000000007;
    static int dx[]= {0,0,1,-1};
    static int dy[]= {1,-1,0,0};
    static int n,k;
    static int a[]=new int[1001];
    static int d[]=new int[1001];
	public static void main(String[] args) throws IOException {
		while(true) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			if(n+k==0) break;
			st=new StringTokenizer(br.readLine());			
			for(int i=1;i<=n;i++) {
				a[i]=Integer.parseInt(st.nextToken());
				d[i]=0;
			}
			d[0]=-100;
			int depth=0;
			int idx=0;
			for(int i=2;i<=n;i++) {
				if(a[i]-a[i-1]!=1) {
					depth++;
				}
				d[i]=depth;
				if(a[i]==k) {
					idx=i;
				}
			}
			int ans=0;
			if(idx==1) {
				bw.write("0\n");
				continue;
			}
			for(int i=2;i<=n;i++) {
				if(d[i]==d[idx]) continue;
				if(d[d[i]]!=d[d[idx]]) continue;
				ans++;
			}
			bw.write(ans+"\n");
		}
        bw.flush();
        bw.close();
        br.close();
	}
}