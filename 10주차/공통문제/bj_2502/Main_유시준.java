import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static long d[]=new long[31];
	static int n;
	static long m;
	public static void main(String[] args) throws IOException{
		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Long.parseLong(st.nextToken());
		d[1]=1;
		d[2]=1;
		for(int i=3;i<=30;i++) {
			d[i]=d[i-1]+d[i-2];
		}
		long a=1;
		while(true) {
			long now=m-a*d[n-2];
			if(now%d[n-1]==0) {
				bw.write(Long.toString(a)+"\n"+Long.toString((m-(a*d[n-2]))/d[n-1]));
				break;
			}
			a++;
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}



