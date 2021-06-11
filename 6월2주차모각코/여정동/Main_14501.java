import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Co[] c = new Co[N+1];
		int[] dp = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			c[i] = new Co(T, P);
			dp[i] = c[i].P;
		}
		
		for(int i = 2; i <= N ; i++) {
			for(int j = 1 ; j < i; j++) {
				if(c[j].T <= i - j) dp[i] = Math.max(c[i].P + dp[j], dp[i]);
			}
		}
		
		 int max = 0;
		 
		    for (int i = 1; i <= N; i++) {
		        if (i + c[i].T <= N + 1) {
		            if (max < dp[i]) {
		                max = dp[i];
		            }
		        }
		    }
		
		System.out.print(max);
	}
	
	static class Co{
		int T;
		int P;
		Co(int T, int P){
			this.T = T;
			this.P = P;
		}
	}
}
