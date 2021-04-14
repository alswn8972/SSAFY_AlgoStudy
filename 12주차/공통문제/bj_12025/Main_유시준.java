import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static long MOD=1000000007;
    static int dx[]= {0,0,1,-1};
    static int dy[]= {1,-1,0,0};
    static long n;
    static int d[]=new int[61];
	public static void main(String[] args) throws IOException {
		String input=br.readLine();
		n=Long.parseLong(br.readLine());
		int size=input.length();
		int idx=0;
		char c[]=input.toCharArray();
		for(int i=size-1;i>=0;i--) {
			char now=input.charAt(i);
			if(now=='2'||now=='1'||now=='6'||now=='7') {
				d[idx++]=i;
				if(now=='6') {
					c[i]='1';
				}
				if(now=='7') {
					c[i]='2';
				}
			}
		}
		long t=1;
		for(long i=0;i<idx;i++) {
			t*=2;
		}
		if(t<n) {
			bw.write("-1");
			bw.flush();
			return;
		}
		n--;
		int k=0;
		while(n>0) {
			if((n&1)==1) {
				if(c[d[k]]=='1') {
					c[d[k]]='6';
				}else {
					c[d[k]]='7';
				}
			} 
			k++;
			n>>=1;
		}
		for(int i=0;i<size;i++) {
			bw.write(c[i]);
		}
        bw.flush();
        bw.close();
        br.close();
	}
}