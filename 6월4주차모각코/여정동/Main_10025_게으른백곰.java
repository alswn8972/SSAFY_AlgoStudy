import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10025_게으른백곰 {
	
	static int N, K;
	static int[] map = new int[1000001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int sum = 0;
		int max = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[x] = g;
		}
		
		K = 2*K + 1;
		
		for(int i = 0 ; i <= 1000000; i++) {
			if(i >= K) 
				sum -= map[i-K];
			sum += map[i];
			max = Math.max(sum, max);
		}
		
		System.out.println(max);
	}
}