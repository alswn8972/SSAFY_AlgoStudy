import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_µ¿Àü2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[10001];
		int[] D = new int[K+1];
		
		Arrays.fill(D, 10001);
		D[0] = 0;
		for(int i=1; i<=N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			
			for(int j = coin[i]; j<=K; j++) {
				D[j] = Math.min(D[j], D[j-coin[i]]+1);
			}
		}
		
		if(D[K] == 10001)
			System.out.println(-1);
		else
			System.out.println(D[K]);
		
	}
	

}
