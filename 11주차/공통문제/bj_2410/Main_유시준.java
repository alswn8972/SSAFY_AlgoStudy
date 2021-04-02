import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static long MOD=1000000000;
    static int dx[]= {0,0,1,-1};
    static int dy[]= {1,-1,0,0};
    static long d[]=new long[1000001];
    static int a[]=new int[31];
    static int n,m;
	public static void main(String[] args) throws IOException {
		n=Integer.parseInt(br.readLine());
		int idx=1;
		int k=0;
		while(idx<=n) {
			a[k++]=idx;
			idx<<=1;
		}
		d[0]=1;
		for(int i=0;i<k;i++) {
			for(int j=a[i];j<=n;j++) {
				d[j]+=d[j-a[i]];
				d[j]%=MOD;
			}
		}
		bw.write(Long.toString(d[n]));
        bw.flush();
        bw.close();
        br.close();
	}
}