import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static long MOD=1000000000;
    static int dx[]= {0,0,1,-1};
    static int dy[]= {1,-1,0,0};
    static int n;
    static long d[]=new long[200001];
	public static void main(String[] args) throws IOException {
		n=Integer.parseInt(br.readLine());
		for(long i=1;i<100001;i++) {
			d[(int)i]=i*i;
		}
		int l=1;
		int r=2;
		ArrayList<Integer> list=new ArrayList<>();
		while(l<=r) {
			if(r>200000) {
				break;
			}
			long a=d[l];
			long b=d[r];
			if(b-a>n) {
				l++;
			}else if(b-a<n) {
				r++;
			}else {
				list.add((int)Math.sqrt(b));
				l++;
				r++;
			}
		}
		Collections.sort(list);
		if(list.size()==0) bw.write("-1");
		else {
			for(long a:list) {
				bw.write(a+"\n");
			}
		}
        bw.flush();
        bw.close();
        br.close();
	}

}