import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2876_유시준 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int d[][]=new int[6][100001];
	static int a[][]=new int[2][100001];
	static boolean visit[][]=new boolean[100][100];
	static int n,m;
	public static void main(String[] args) throws IOException{
		n=Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			a[0][i]=Integer.parseInt(st.nextToken());
			a[1][i]=Integer.parseInt(st.nextToken());
		}
		int ans=0;
		int idx=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=5;j++) {
				if(a[0][i]==j) d[j][i]=d[j][i-1]+1;
				if(a[1][i]==j) d[j][i]=d[j][i-1]+1;
				if(ans<d[j][i]) {
					ans=d[j][i];
					idx=j;
				}else if(ans==d[j][i]&&idx>j) {
					idx=j;
				}
			}
		}
		bw.write(Integer.toString(ans)+" "+Integer.toString(idx));
		bw.flush();
		bw.close();
		br.close();
	}
}



