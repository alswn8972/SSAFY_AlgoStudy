import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_유시준 { 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int a[][]=new int[251][251];
	static int n,m,k;
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				a[i][j]=100000000;
			}
			a[i][i]=0;
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if(b==1) {
				a[s][e]=0;
				a[e][s]=0;
			}else {
				a[s][e]=0;
				a[e][s]=1;
			}
		}
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					a[i][j]=Math.min(a[i][j], a[i][k]+a[k][j]);
				}
			}
		}
		int k=Integer.parseInt(br.readLine());
		for(int i=0;i<k;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			bw.write(Integer.toString(a[s][e])+"\n");
		}
		bw.flush();
	}
}

