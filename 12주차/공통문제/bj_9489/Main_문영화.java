import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_문영화 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			if(N==0 && T==0) break;
			int[] number = new int[N];
			int[] p = new int[N];
			int[] depth = new int[N];
			depth[0]=0;
			int idx=0;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int x =Integer.parseInt(st.nextToken());
				if(x==T)idx=i;
				number[i]=x;
			}
			int parent=-1;
			for(int i=1;i<N;i++) {
				
				if(number[i-1]+1==number[i]) {
					p[i-1]=parent;
				}else {
					p[i-1]=parent;
					parent++;
				}
				
			}
			p[N-1]=parent;
			
			int result=0;
			
			for(int i=1;i<N;i++) {
				if(p[idx]!=p[i]&&p[p[idx]]==p[p[i]]) {
					result++;
				}
			}
			sb.append(result+"\n");

		}
		System.out.println(sb.toString());
	}

}
