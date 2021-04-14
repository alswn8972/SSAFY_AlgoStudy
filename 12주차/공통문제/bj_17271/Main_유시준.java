import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static long MOD=1000000007;
    static int dx[]= {0,0,1,-1};
    static int dy[]= {1,-1,0,0};
    static int n,m;
    static long d[]=new long[10001];
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		for(int i=0;i<=m;i++) {
			d[i]=1;
		}
		for(int i=m;i<=n;i++) {
			d[i]=d[i-m]+d[i-1];
			d[i]%=MOD;
		}
		bw.write(d[n]+"");
        bw.flush();
        bw.close();
        br.close();
	}
}